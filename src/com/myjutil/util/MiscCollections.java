package com.myjutil.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * User: liviu
 * Date: 12/12/13
 * Time: 6:39 PM
 */
public class MiscCollections {

    /**
     * For reporting sometimes is useful to get a few examples. like com.google.common.collect.Iterables.get
     * but will get you more elements
     *
     * @param values List, Set, Collection...
     * @param n number of example
     * @param <T> type
     * @return Collection<T> n elements in iterator orders
     */
    public static <T> Collection<T> examples(Iterable<T> values, int n) {
        Collection<T> r = new ArrayList<>();
        int k = 0;
        for (T t : values) {
            if (k == n) {
                break;
            }
            r.add(t);
            k++;
        }
        return r;
    }

    public static <T> Iterable<T> noNull(Iterable<T> itbl, String message) {
        if (itbl == null) {
            throw new IllegalArgumentException(message);
        }
        for (T t : itbl) {
            if (t == null) {
                throw new IllegalArgumentException(message);
            }
        }
        return itbl;
    }

    public static <T> List<T> noneNull(List<T> itbl, String message){
        return (List<T>) noNull(itbl, message);
    }

    public static <T> Set<T> noneNull(Set<T> itbl, String message){
        return (Set<T>) noNull(itbl, message);
    }

}
