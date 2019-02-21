package com.company.wheel;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

public class WheelServiceImpl implements WheelService {

    /**
     * 线程控制，线程池
     * @param timeOut
     * @param flag
     */
//    static Timer timer = new HashedWheelTimer(1,TimeUnit.SECONDS,10);

    @Override
    public void timeOut(int timeOut, int flag) {
        Timer timer = new HashedWheelTimer(1,TimeUnit.SECONDS,10);
//        Timer timer = new HashedWheelTimer();
        TimerTask task = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println(Thread.currentThread().getName());
                System.out.println("已超时。");
                timer.newTimeout(this,2, TimeUnit.SECONDS);
            }
        };
        timer.newTimeout(task,2, TimeUnit.SECONDS);
    }
}
