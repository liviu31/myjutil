package com.myjutil.util;

import java.text.SimpleDateFormat;

/**
 * Created by liviu on 25.12.2016.
 */
public class ThreadLocalSimpleDateFormat extends ThreadLocal<SimpleDateFormat> {

    private final String format;

    public ThreadLocalSimpleDateFormat(String format) {
        this.format = format;
    }

    @Override
    protected SimpleDateFormat initialValue(){
        return new SimpleDateFormat(format);
    }

}
