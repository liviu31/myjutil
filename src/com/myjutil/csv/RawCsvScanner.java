package com.myjutil.csv;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * like java Scanner but for csv. V1
 * <p/>
 * User: liviu
 * Date: 1/4/14
 * Time: 8:24 PM
 */
public class RawCsvScanner {

    public final Character separator = ',';

    public final Character quote = '"';

    private String line;
    private int start = 0;
    private boolean quotedOpen = false;
    private int i = 0;
    private final BufferedReader br;

    public RawCsvScanner(BufferedReader br) {
        this.br = br;
        nextLine();
    }

    public String nextLine() {
        String old = null;
        if (line != null) {
            old = line.substring(start, line.length());
        }
        try {
            line = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        start = 0;
        quotedOpen = false;
        i = 0;
        return old;
    }

    public String next() {
        while (i < line.length()) {
            if (quote.equals(line.charAt(i))) {
                if (quotedOpen && i + 1 < line.length() && quote.equals(line.charAt(i + 1))) {
                    i++;
                } else {
                    quotedOpen = !quotedOpen;//open if first; close if last
                }
            } else {
                if (separator.equals(line.charAt(i)) && !quotedOpen) {
                    String substring = line.substring(start, i);
                    start = i + 1;
                    i++;
                    return clean(substring);
                }
            }
            i++;
        }
        String substring = line.substring(start, line.length());
        //TODO next line
        nextLine();
        return clean(substring);

    }

    private String clean(String substring) {
        //quick and dirty
        if (substring != null) {
            String s = substring.trim();
            if (s.startsWith("\"")) {
                s = s.substring(1, s.length() - 1);
                return s.replaceAll("" + quote + quote, "" + quote);
            }
        }
        return substring;
    }


}
