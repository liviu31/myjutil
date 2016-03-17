package com.myjutil.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 3/17/16
 * Time: 12:54 PM
 */
public class J8Test {

    @Test
    public void test(){
        List<String> ar = Arrays.asList("a", "b", "c", "a", "a", "b");
        Map<String, Long> rt = J8.countFrequency(ar);
        Map<String, Long> ex = new HashMap<>();
        ex.put("a",3L);
        ex.put("b",2L);
        ex.put("c",1L);
        assertThat(rt, is(ex));
    }

}
