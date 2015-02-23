package com.myjutil.util;

import java.util.*;
import java.util.function.Function;

/**
 * User: liviu
 * Date: 12/12/13
 * Time: 6:54 PM
 */
public class MiscMaps {

    public static <K, T> Map<K, T> parse(String strMap, String entrySeparator, String keyValueSeparator,
                                         Function<String, K> key, Function<String, T> value) {
        if (value == null) {
            return Collections.emptyMap();
        }
        Map<K, T> structure = new HashMap<>();
        String[] split = strMap.split(entrySeparator);
        for (String v : split) {
            String[] values = v.split(keyValueSeparator);
            if (values != null && values.length == 2 && values[0] != null && values[1] != null) {
                structure.put(key.apply(values[0].trim()), value.apply(values[1].trim()));
            }
        }
        return structure;
    }

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
