package com.myjutil.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * User: liviu
 * Date: 1/10/14
 * Time: 1:37 AM
 */
public class MultiIterable<I> implements Iterable<I> {

    private final List<Iterable<I>> iterators;

    private MultiIterable(List<Iterable<I>> iterators) {
        this.iterators = iterators;
    }

    public static <I> MultiIterable<I> create(List<Iterable<I>> iterators) {
        return new MultiIterable<I>(iterators);
    }

    public static <I> MultiIterable<I> create(Iterable<I>... iterators) {
        return new MultiIterable<I>(Arrays.asList(iterators));
    }


    @Override
    public Iterator<I> iterator() {
        return new CompositeIterator<I>(iterators);
    }

    public static class CompositeIterator<I> implements Iterator<I> {

        Iterator<Iterable<I>> it;

        Iterator<I> current;

        public CompositeIterator(List<Iterable<I>> iterators) {
            it = iterators.iterator();
        }

        @Override
        public boolean hasNext() {
            while (it.hasNext() || current.hasNext()) {
                if (current != null && current.hasNext()) {
                    return true;
                } else {
                    current = it.next().iterator();
                }
            }
            return false;
        }

        @Override
        public I next() {
            while (it.hasNext() || current.hasNext()) {
                if (current.hasNext()) {
                    return current.next();
                } else {
                    current = it.next().iterator();
                }
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}