package com.myjutil.util;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 1/10/14
 * Time: 1:38 AM
 */
public class MultiIterableTest {

    @Test
    public void test() {
        List<String> lst = new ArrayList<>();
        for (String s : MultiIterable.create(Arrays.asList("1", "2", "3"), Arrays.asList("A", "B"))) {
            lst.add(s);
        }
        assertThat(lst, is(Arrays.asList("1", "2", "3", "A", "B")));
    }

    @Test
    public void test2() {
        List<String> lst = new ArrayList<>();
        for (String s : MultiIterable.create(Arrays.asList("1", "2", "3"), Collections.<String>emptyList(), Arrays.asList("1", "2", "3"), Collections.<String>emptyList())) {
            lst.add(s);
        }
        assertThat(lst, is(Arrays.asList("1", "2", "3", "1", "2", "3")));
    }

}
