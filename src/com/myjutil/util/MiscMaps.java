package com.myjutil.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * User: liviu
 * Date: 12/12/13
 * Time: 6:54 PM
 */
public class MiscMaps {

    public static <K,T> Map<K,T> submap(Map<K,T> inMap, Set<K> keys) {
        Map<K,T> outMap = new HashMap<>();
        for (Map.Entry<K,T> entry : inMap.entrySet()) {
            if (keys.contains(entry.getKey())) {
                outMap.put(entry.getKey(), entry.getValue());
            }
        }
        return outMap;
    }

    public static <K,T> Map<K,T> newWithoutNulls(Map<K, T> inMap, Set<K> keys) {
        Map<K,T> newMap = new HashMap<>();
        for (Map.Entry<K,T> entry : inMap.entrySet()) {
            if (entry.getValue() != null) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;
    }

}
