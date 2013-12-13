package com.myjutil.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * User: liviu
 * Date: 12/13/13
 * Time: 6:57 PM
 */
public class Reflection {

    public static List<Method> searchAnnotation(Object ob, Class annotation) {
        List<Method> result = new ArrayList<>();
        Class c = ob.getClass();
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation methodAnnotation : annotations) {
                if (methodAnnotation.annotationType() == annotation) {
                    result.add(method);
                }
            }
        }
        return result;
    }

}
