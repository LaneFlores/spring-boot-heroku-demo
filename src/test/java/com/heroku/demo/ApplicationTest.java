package com.heroku.demo;// PURPOSE: 

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApplicationTest {
    Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testExample() {
        // This is a test, just trying to see if it runs.
        log.info("This is a test run.");
        System.out.println("Test run?!");
    }

    /*@Test public void failingExample() {
        System.out.println("This is going to intentionally fail.");
        Assert.assertTrue(false);
    }*/
}
