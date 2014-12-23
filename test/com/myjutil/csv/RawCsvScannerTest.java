package com.myjutil.csv;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * User: liviu
 * Date: 1/5/14
 * Time: 2:55 AM
 */
public class RawCsvScannerTest {

    @Test
    public void testBasicNext() {
        String s = "1997,Ford,E350,\"Super, \"\"luxurious\"\" truck\",\"\",aaa,,a1"+System.lineSeparator()
                +"1997,Ford,E350,\"Go get one now they are going fast\"";

        BufferedReader br = new BufferedReader(new StringReader(s));
        RawCsvScanner rcv = new RawCsvScanner(br);
        assertEquals("1997", rcv.next());
        assertEquals("Ford", rcv.next());
        assertEquals("E350", rcv.next());
        assertEquals("Super, \"luxurious\" truck", rcv.next());
        assertEquals("", rcv.next());
        assertEquals("aaa", rcv.next());
        assertEquals("", rcv.next());
        assertEquals("a1", rcv.next());
        assertEquals("1997", rcv.next());
        assertEquals("Ford", rcv.next());
        assertEquals("E350", rcv.next());
        assertEquals("Go get one now they are going fast", rcv.next());
    }


    @Test
    public void testBasicNextIntLong() {
        String s = "1997,Ford,E350,\"Super, \"\"luxurious\"\" truck\",\"\",aaa,,a1"+System.lineSeparator()
                +"1997,Ford,E350,\"Go get one now they are going fast\"";

        BufferedReader br = new BufferedReader(new StringReader(s));
        RawCsvScanner rcv = new RawCsvScanner(br);
        assertEquals(1997, rcv.nextInt());
        assertEquals("Ford", rcv.next());
        assertEquals("E350", rcv.next());
        assertEquals("Super, \"luxurious\" truck", rcv.next());
        assertEquals("", rcv.next());
        assertEquals("aaa", rcv.next());
        assertEquals("", rcv.next());
        assertEquals("a1", rcv.next());
        assertEquals(1997L, rcv.nextLong());
        assertEquals("Ford", rcv.next());
        assertEquals("E350", rcv.next());
        assertEquals("Go get one now they are going fast", rcv.next());
    }

    @Test
    public void testBasicNextLine() {
        String s = "1997,Ford,E350,\"Super, \"\"luxurious\"\" truck\",\"\",aaa,,a1"+System.lineSeparator()
                +"1997,Ford,E350,\"Go get one now they are going fast\"";

        BufferedReader br = new BufferedReader(new StringReader(s));
        RawCsvScanner rcv = new RawCsvScanner(br);
        assertEquals("1997", rcv.next());
        assertEquals("Ford", rcv.next());
        assertEquals("E350", rcv.next());
        assertEquals("\"Super, \"\"luxurious\"\" truck\",\"\",aaa,,a1", rcv.nextLine());

        assertEquals("1997", rcv.next());
        assertEquals("Ford", rcv.next());
        assertEquals("E350", rcv.next());
        assertEquals("Go get one now they are going fast", rcv.next());
    }


}
