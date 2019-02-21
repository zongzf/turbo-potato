package com.company.circularService;

import org.junit.Before;
import org.junit.Test;

public class RingArrayTest {

    CircularServiceImpl circularService;

    @Before
    public void setUp(){
        circularService = new CircularServiceImpl();
    }


    @Test
    public void ringArray(){
        circularService.bookingTimeout(6);
        circularService.timeout("123");
    }

}
