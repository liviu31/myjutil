package com.myjutil.util;

/**
 * User: liviu
 * Date: 12/12/13
 * Time: 6:41 PM
 */
public class Misc {

    public static boolean areEqual(Object one, Object another){
        if(one == another){
            return true;
        }
        if(one == null || another ==null){
            return false;
        }
        return one.equals(another);
    }

    public static boolean isAnyNull(Object ...objs){
        for(Object obj:objs){
            if(obj == null){
                return true;
            }
        }
        return false;
    }

    /**
     * A fancy way of writing a!=null && b!=null && c!=null....
     * @param objs Objects to be tested
     * @return true if none of the provided objects is null
     */
    public static boolean noneNull(Object ...objs){
        return !isAnyNull(objs);
    }

}
