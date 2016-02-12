package com.myjutil.util;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 12/11/13
 * Time: 10:59 PM
 */
public class NumbersTest {

    @Test
    public void testDoubles() {
        assertTrue(Numbers.doubleEquals(10d, 10d, .000000000001d));
        assertTrue(Numbers.doubleEquals(1d / 3 * 10, 10d / 3, .000000000001d));
    }

    @Test
    public void testFloats() {
        assertTrue(Numbers.floatEquals(10f, 10f, .000001f));
        assertTrue(Numbers.floatEquals(1f / 3 * 10, 10f / 3, .000001f));
    }

    @Test
    public void testCloseTo(){
        int pos = Numbers.closeTo(11, Arrays.asList(1 ,2, 10, 5, 6));
        assertThat(pos, is(2));
    }


}
