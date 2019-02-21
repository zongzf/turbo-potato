package com.company.ring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RingTest {

    RingServiceImpl service;

    @Before
    public void setUp(){
        service = new RingServiceImpl(new RingQueue(5,1));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
    }

    @Test
    public void ring(){
        System.out.println("begin");
        for (int i = 0; i < 5; i++) {

        service.timeOut();
        }

        System.out.println("done");
    }
}
