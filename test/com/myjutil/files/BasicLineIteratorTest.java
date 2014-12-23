package com.myjutil.files;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 1/4/14
 * Time: 9:53 PM
 */
public class BasicLineIteratorTest {

    @Test
    public void basicTest() throws FileNotFoundException {
        BasicLineIterator strings = BasicLineIterator.create(new BufferedReader(new StringReader(String.format("a%nb%nc"))));
        List<String> lst = new ArrayList<>();
        for (String s : strings) {
            lst.add(s);
        }
        assertThat(lst, is(Arrays.asList("a", "b", "c")));
    }

}
