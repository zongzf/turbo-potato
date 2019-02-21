package com.company.wheel;

import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WheelTest {

    WheelService wheelService;

    @Before
    public void setUp(){
        wheelService = new WheelServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
    }

    @Test
    public void test(){
        wheelService.timeOut(2, 1);
    }
}
