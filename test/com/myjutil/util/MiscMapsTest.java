package com.myjutil.util;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 12/29/14
 * Time: 121:41 PM
 */
public class MiscMapsTest {

    @Test
    public void testParseMap() {
        Map<String, Integer> expected = new HashMap<String, Integer>() {{
            put("name1", 1);
            put("name2", 2);
        }};

        Map<String, Integer> mp = MiscMaps.parse("name1=1&name2=2","&", "=", (s) -> s, Integer::parseInt);
        assertThat(mp, is(expected));
    }

}
