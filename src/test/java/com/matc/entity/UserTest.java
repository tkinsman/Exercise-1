package com.matc.entity;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.*;


/**
 * Created by toddkinsman on 9/8/16.
 */
public class UserTest {
    // You'll need to create a user to test the class
    // the @before means that it will run first
    User user;

    @Before
    public void setUp() {
//        user = new User("test", "one", "5", createLocalDateFromString("01-01-2000"));

    }

    private LocalDate createLocalDateFromString(String inputDate) {

        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MMM0yyyy");
        return LocalDate.parse(inputDate, DATE_FORMAT);

    }


    @Test
    public void calculateAge() throws Exception {
        // verify that calculate age returns the expected value
        // user born Jan 2000 should be 16
//        assertEquals(16, user.calculateAge());



    }

}