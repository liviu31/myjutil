package com.myjutil.concurrent;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 12/12/13
 * Time: 8:10 PM
 */
public class ConcurrentMultiCounterTest {

    @Test
    public void testCount() throws Exception {
        ConcurrentMultiCounter<String> cmc = new ConcurrentMultiCounter<>();
        assertThat(cmc.count("A"), is(0));
        assertThat(cmc.get("A"), is(1));

        assertThat(cmc.count("B"), is(0));
        assertThat(cmc.get("B"), is(1));

        assertThat(cmc.count("B"), is(1));
        assertThat(cmc.get("B"), is(2));

        assertThat(cmc.count("A"), is(1));
        assertThat(cmc.get("A"), is(2));

        assertThat(cmc.count("A"), is(2));
        assertThat(cmc.get("A"), is(3));

        assertThat(cmc.count("A"), is(3));
        assertThat(cmc.get("A"), is(4));

        assertThat(cmc.count("A"), is(4));
        assertThat(cmc.get("A"), is(5));
    }

}
