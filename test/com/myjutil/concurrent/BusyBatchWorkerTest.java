package com.myjutil.concurrent;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: liviu
 * Date: 12/11/13
 * Time: 11:44 PM
 */
public class BusyBatchWorkerTest {

    @Test
    public void test() {
        //TODO
    }

    public class BatchHandler implements BusyBatchWorker.BatchHandler<String> {

        List<String> ls = new ArrayList<>();

        @Override
        public void add(String data) {
            System.out.println(data);
            ls.add(data);
        }

        @Override
        public void commit() {
            System.out.println("COMIT");
        }
    }
}
