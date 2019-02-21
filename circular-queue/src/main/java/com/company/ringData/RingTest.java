package com.company.ringData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class RingTest {
    RingServiceImpl ringService;

    @Before
    public void setUp(){
        HashMap<Integer, HashSet<Slot>> slotMap = new HashMap<>();
        ringService = new RingServiceImpl(new Ring(5, 1, slotMap, 0));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(200000);
    }


    @Test
    public void ringTest() throws InterruptedException {
        System.out.println("ring test beging.");
//        ringService.timeOut(1,demo());
        ringService.timeTest(1);
    }

//    private Runnable demo() throws InterruptedException {
//        Thread.sleep(2000);
//        System.out.println("hahah");
//        return null;
//    }
}
