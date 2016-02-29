package com.myjutil.util;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;

/**
 * User: liviu
 * Date: 2/29/16
 * Time: 7:56 PM
 */
public class DoubleArray {

    public static double[] operation(double[] array, DoubleFunction<Double> function) {
        double result[] = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = function.apply(array[i]);
        }
        return result;
    }

    public static double[] merge(double[] x, double[] y, BiFunction<Double, Double, Double> function) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("nonconformant arguments");
        }
        int length = x.length;
        double result[] = new double[length];
        for (int i = 0; i < length; i++) {
            result[i] = function.apply(x[i], y[i]);
        }
        return result;
    }


}
