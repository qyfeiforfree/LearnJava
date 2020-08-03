package com.qyfei;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DVDPlayerTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testRecordDVD() {
        DVDPlayer dvdPlayer=new DVDPlayer();
        dvdPlayer.playDVD();
    }
}