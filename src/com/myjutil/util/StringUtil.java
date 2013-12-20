package com.myjutil.util;

/**
 * User: liviu
 * Date: 12/12/13
 * Time: 12:01 AM
 */
public class StringUtil {

    public static String firstToUpperCase(String arg) {
        if (arg != null) {
            return arg.substring(0, 1).toUpperCase() + arg.substring(1, arg.length());
        }
        return null;
    }

}
