package com.qyfei;
import org.junit.*
import org.junit.Test;

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