package com.qyfei;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.*;

public class PersonTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testPerson() {
        for (int i = 0; i < 3; i++) {
            Person p = new Person("Joe Q Author", 42, 173, 82, "Brown", "MALE");
            Logger l = Logger.getLogger(Person.class.getName());
            l.info("Loop executing iteration# " + i);
            l.info("Name: " + p.getName());
            l.info("Age:" + p.getAge());
            l.info("Height (cm):" + p.getHeight());
            l.info("Weight (kg):" + p.getWeight());
            l.info("Eye Color:" + p.getEyeColor());
            l.info("Gender:" + p.getGender());
            assertEquals("Joe Q Author", p.getName());
            assertEquals(42, p.getAge());
            assertEquals(173, p.getHeight());
            assertEquals(82, p.getWeight());
            assertEquals("Brown", p.getEyeColor());
            assertEquals("MALE", p.getGender());
        }
    }
}