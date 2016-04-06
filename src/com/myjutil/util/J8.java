package com.myjutil.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * User: liviu
 * Date: 3/17/16
 * Time: 1:51 AM
 */
public class J8 {

    public static <T> Map<T, Long> countFrequency(Collection<T> input) {
        Map<T, Long> all = input.stream()
                .collect(groupingBy(Function.<T>identity(), Collectors.counting()));
        return all;
    }

    public static List<Double> toDoubleList(Collection<Long> in) {
        return in.stream().mapToDouble(Long::doubleValue).boxed()
                .collect(Collectors.toList());
    }
}
