package com.myjutil.util;

import java.util.List;

/**
 * User: liviu
 * Date: 12/11/13
 * Time: 10:55 PM
 */
public class Numbers {

    public static boolean floatEquals(float value1, float value2, float delta) {
        return Float.compare(value1, value2) == 0 || Math.abs(value1 - value2) <= delta;

    }

    public static boolean doubleEquals(double value1, double value2, double delta) {
        return Double.compare(value1, value2) == 0 || (Math.abs(value1 - value2) <= delta);
    }

    public static int closeTo(Number num, List<? extends Number> numbers) {
        int pos = 0;
        double difference = Double.MAX_VALUE;
        int found = 0;
        for (Number n : numbers) {
            double abs = Math.abs(diff(num, n));
            if (abs < difference) {
                found = pos;
                difference = abs;
            }
            pos++;
        }
        return found;


    }

    public static double diff(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }

}
