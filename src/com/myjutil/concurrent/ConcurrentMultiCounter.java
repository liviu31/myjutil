package com.myjutil.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: liviu
 * Date: 12/12/13
 * Time: 7:59 PM
 */
public class ConcurrentMultiCounter<T> {

    private final ConcurrentHashMap<T, AtomicInteger> trackerMap;

    public ConcurrentMultiCounter() {
        trackerMap = new ConcurrentHashMap<>();
    }

    public int count(final T key) {
        AtomicInteger mapValue = trackerMap.get(key);
        if (mapValue == null) {
            final AtomicInteger newValue = new AtomicInteger(0);
            mapValue = trackerMap.putIfAbsent(key, newValue);
            if (mapValue == null) {
                mapValue = newValue;
            }
        }
        return mapValue.getAndIncrement();
    }

    public int get(final T key) {
        AtomicInteger mapValue = trackerMap.get(key);
        if (mapValue == null) {
            return 0;
        }
        return mapValue.get();
    }
}
