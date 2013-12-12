package com.myjutil.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 12/12/13
 * Time: 7:04 PM
 */
public class MiscCollectionsTest {

    @Test
    public void testExamples(){
        List<String> lst = Arrays.asList("A", "B", "C");
        assertThat((List<String>) MiscCollections.examples(lst, 2), is(Arrays.asList("A", "B")));

        lst = Arrays.asList("A");
        assertThat((List<String>) MiscCollections.examples(lst, 2), is(Arrays.asList("A")));
    }

}
