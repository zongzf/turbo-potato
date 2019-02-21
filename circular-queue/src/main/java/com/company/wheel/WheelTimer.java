package com.company.wheel;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WheelTimer {



    static Timer wheelTimer = new HashedWheelTimer(1, TimeUnit.SECONDS,10);

//    public Timer getWheelTimer() {
//        return wheelTimer;
//    }


    /**
     * netty时间轮的实例
     * @param args
     */
    public static void main(String[] args){
//        HashedWheelTimer wheelTimer = new HashedWheelTimer();
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("该任务已超时。");
//                addTask(this);
//                wheelTimer.newTimeout(this, 2, TimeUnit.SECONDS);
            }
        };
        addTask(timerTask1);
//        wheelTimer.newTimeout(timerTask1,2,TimeUnit.SECONDS);
    }

    public static void addTask(TimerTask task){
        //根据时长把task任务放到相应的slot上
        wheelTimer.newTimeout(task,2,TimeUnit.SECONDS);
    }


}
