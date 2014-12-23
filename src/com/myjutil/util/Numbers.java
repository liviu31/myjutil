package com.myjutil.util;

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

}
