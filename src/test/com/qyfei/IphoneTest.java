package com.qyfei;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IphoneTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testCall() {
        Iphone iphone = new Iphone();
        System.out.println(iphone);
        iphone.call();
    }

    @Test
    public void testSendmsg() {
        Iphone iphone = new Iphone();
        iphone.sendmsg();
        System.out.println(iphone);
    }

}