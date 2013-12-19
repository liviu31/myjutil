package com.myjutil.util;

import java.util.*;

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
     * @param n      number of examples
     * @param <T>    type
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

    /**
     * like guava Strings.isNullOrEmpty
     */
    public static boolean isNullOrEmpty(Collection<?> collection) {
        return (collection == null) || collection.isEmpty();
    }

    public static boolean hasNull(Iterable<?> itbl) {
        for (Object t : itbl) {
            if (t == null) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterable<T> noNull(Iterable<T> itbl, String message) {
        if (itbl == null) {
            throw new IllegalArgumentException(message);
        }
        if (hasNull(itbl)) {
            throw new IllegalArgumentException(message);
        }
        return itbl;
    }

    public static <T> Collection<T> newWithoutNulls(Collection<T> collection, Collection<T> returnCollection) {
        for (T t : collection) {
            if (t != null) {
                returnCollection.add(t);
            }
        }
        return returnCollection;
    }

    public static <T> List<T> newWithoutNulls(List<T> collection) {
        return (List<T>) newWithoutNulls(collection, new ArrayList<T>());
    }

    public static <T> Set<T> newWithoutNulls(Set<T> collection) {
        return (Set<T>) newWithoutNulls(collection, new HashSet<T>());
    }

    public static <T> List<T> selectNonNull(T... obj) {
        return (List<T>) newWithoutNulls(Arrays.asList(obj), new ArrayList<T>());
    }

    public static <T> List<T> noneNull(List<T> list, String message) {
        return (List<T>) noNull(list, message);
    }

    public static <T> Set<T> noneNull(Set<T> itbl, String message) {
        return (Set<T>) noNull(itbl, message);
    }

}
