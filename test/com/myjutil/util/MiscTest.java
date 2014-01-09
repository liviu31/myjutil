package com.myjutil.util;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * User: liviu
 * Date: 12/12/13
 * Time: 6:42 PM
 */
public class MiscTest {

    @Test
    public void testNoneNull() {
        Object a = new Object();
        String b = "AAAA";
        Double c = 10d;
        assertTrue(Misc.noneNull(a, b, c));
    }

    @Test
    public void testIsAnyNull() {
        Object a = new Object();
        String b = "AAAA";
        Double c = 10d;
        assertFalse(Misc.isAnyNull(a, b, c));
    }

    @Test
    public void testNoneNull2() {
        Object a = new Object();
        String b = "AAAA";
        Double c = 10d;
        assertFalse(Misc.noneNull(a, null, b, c));
    }

    @Test
    public void testIsAnyNull2() {
        Object a = new Object();
        String b = "AAAA";
        Double c = 10d;
        assertTrue(Misc.isAnyNull(a, null, b, c));
    }
}
