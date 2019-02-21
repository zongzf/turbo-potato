package com.company.circularService;



import com.company.scheduler.TimerScheduler;

import java.sql.SQLOutput;
import java.util.*;

public class CircularServiceImpl implements CircularService {

    public CircleQueue getCircleQueue() {
        return circleQueue;
    }

    public void setCircleQueue(CircleQueue circleQueue) {
        this.circleQueue = circleQueue;
    }

    private CircleQueue circleQueue;


    @Override
    public void bookingTimeout(int timeout) {

        CircleQueue circleQueue = new CircleQueue();
        circleQueue.create(10,1);
        System.out.println(circleQueue.getCurrentIndex()+"环形队列创建完成");
        circleQueue.addTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("第"+circleQueue.getCurrentIndex()+"个slot。");
            }
        },2);

//        this.run();
        Task task = new Task(circleQueue);

        System.out.println(task);
        task.run();
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(task,0,1000);

//        Runnable callback = null;
//        circleQueue.addTask(callback,timeout);



    }

    @Override
    public void timeout(String s) {
        System.out.println("测试");
    }


}
