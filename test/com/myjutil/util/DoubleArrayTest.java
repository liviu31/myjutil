package com.myjutil.util;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 2/29/16
 * Time: 7:57 PM
 */
public class DoubleArrayTest {

    @Test
    public void testArrayOperation() {
        double a[] = {1, 2, 3};
        double[] r = DoubleArray.operation(a, e -> e * 2);
        assertThat(r, is(new double[]{2d, 4d, 6d}));
    }

}
