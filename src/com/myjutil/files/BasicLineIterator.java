package com.myjutil.files;

import java.io.*;
import java.util.Iterator;

/**
 * something like: FileUtils.lineIterator(file, "UTF-8") from org.apache.commons.io.LineIterator or like
 * com.google.common.io.LineProcessor but lighter
 * <p/>
 * iterate over lines of a text files
 * for (String s : BasicLineIterator.create(new File("file.txt"))) {
 *      System.out.println(s);
 * }
 * <p/>
 * User: liviu
 * Date: 1/4/14
 * Time: 9:33 PM
 */
public class BasicLineIterator implements Iterable<String> {

    private BufferedReader br;

    private BasicLineIterator(BufferedReader br) {
        this.br = br;
    }

    //TODO create br on iterator()
    public static BasicLineIterator create(File file) throws FileNotFoundException {
        return new BasicLineIterator(new BufferedReader(new FileReader(file)));
    }

    public static BasicLineIterator create(BufferedReader br) throws FileNotFoundException {
        return new BasicLineIterator(br);
    }

    @Override
    public Iterator<String> iterator() {
        return new LineIterator(br);
    }

    public static class LineIterator implements Iterator<String> {

        private final BufferedReader br;

        private String line;

        private boolean nextCalled;

        public LineIterator(BufferedReader br) {
            this.br = br;
            line = null;
            nextCalled = false;
            line();
        }

        private void handleNext() {
            if (nextCalled) {
                line();
            }
        }

        private void line() {
            try {
                line = br.readLine();
                if (line == null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            nextCalled = false;
        }

        @Override
        public boolean hasNext() {
            handleNext();
            return line != null;
        }

        @Override
        public String next() {
            nextCalled = true;
            String current = line;
            handleNext();
            return current;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
