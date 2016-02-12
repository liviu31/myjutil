package com.myjutil.concurrent;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 8/30/15
 * Time: 1:36 PM
 */
public class BasicLockFreeCircularRingDisruptorTest {

    BasicLockFreeCircularRingDisruptor<String> blfcrd;

    @Before
    public void setUp() throws Exception {
        blfcrd = new BasicLockFreeCircularRingDisruptor<>(3);
    }

    @Test
    public void basicTest1() {
        assertTrue(blfcrd.pushIfPossible("First"));
        assertThat(blfcrd.consumeIfPossible(), is("First"));
    }

    @Test
    public void basicTestPullEmpty() {
        assertThat(blfcrd.consumeIfPossible(), is(nullValue()));
    }

    @Test
    public void basicTest2() {
        assertTrue(blfcrd.pushIfPossible("First"));
        assertTrue(blfcrd.pushIfPossible("Second"));
        assertThat(blfcrd.consumeIfPossible(), is("First"));
        assertThat(blfcrd.consumeIfPossible(), is("Second"));
    }

    @Test
    public void basicTest3() {
        assertTrue(blfcrd.pushIfPossible("First"));
        assertTrue(blfcrd.pushIfPossible("Second"));
        assertTrue(blfcrd.pushIfPossible("Third"));
        assertThat(blfcrd.consumeIfPossible(), is("First"));
        assertThat(blfcrd.consumeIfPossible(), is("Second"));
        assertThat(blfcrd.consumeIfPossible(), is("Third"));
    }

    @Test
    public void basicTestFull() {
        assertTrue(blfcrd.pushIfPossible("First"));
        assertTrue(blfcrd.pushIfPossible("Second"));
        assertTrue(blfcrd.pushIfPossible("Third"));
        assertFalse(blfcrd.pushIfPossible("last"));
        assertThat(blfcrd.consumeIfPossible(), is("First"));
        assertThat(blfcrd.consumeIfPossible(), is("Second"));
        assertThat(blfcrd.consumeIfPossible(), is("Third"));
        assertThat(blfcrd.consumeIfPossible(), is(nullValue()));
    }

    @Test
    public void basicTestComplex1() {
        assertTrue(blfcrd.pushIfPossible("First"));
        assertTrue(blfcrd.pushIfPossible("Second"));
        assertTrue(blfcrd.pushIfPossible("Third"));
        assertFalse(blfcrd.pushIfPossible("last"));
        assertThat(blfcrd.consumeIfPossible(), is("First"));
        assertThat(blfcrd.consumeIfPossible(), is("Second"));
        assertThat(blfcrd.consumeIfPossible(), is("Third"));
        assertThat(blfcrd.consumeIfPossible(), is(nullValue()));

        assertTrue(blfcrd.pushIfPossible("First"));
        assertThat(blfcrd.consumeIfPossible(), is("First"));

        assertTrue(blfcrd.pushIfPossible("Second"));
        assertTrue(blfcrd.pushIfPossible("Third"));
        assertTrue(blfcrd.pushIfPossible("last"));

        assertThat(blfcrd.consumeIfPossible(), is("Second"));
        assertThat(blfcrd.consumeIfPossible(), is("Third"));
        assertThat(blfcrd.consumeIfPossible(), is("last"));

        assertThat(blfcrd.consumeIfPossible(), is(nullValue()));
        assertThat(blfcrd.consumeIfPossible(), is(nullValue()));
    }


}
