package com.company.scheduler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/***
 * 1.数据结构：每一个slot都是一个set，存放圈数和task；再用Map结构存放下标和set的对应关系
 * 2.如何保证队列单次遍历结束后回到起点继续遍历
 */


/**
 * 用于判断定时器是否到时，执行任务，维护定时器状态
 */
public class TimerScheduler extends TimerTask {

    private TimerContext timerContext;
//    public TimerScheduler(){
//
//    }

    public TimerScheduler(TimerContext timerContext){
        this.timerContext = timerContext;
    }

    public static void main(String[] args) throws IOException {


        //创建一个环形队列
        TimerContext context = new TimerContext(5,1);
        TimerScheduler scheduler = new TimerScheduler(context);
        System.out.println(scheduler.timerContext+"9999999");


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(scheduler,0,1000);
        /**
         * 每隔1秒加入一个新任务
         */
//        for(int i=0;i<10;i++){
//
//            try {
//                scheduler.addTask(new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println("run..");
//                    }
//                },6);
//                Thread.sleep(1000);
//                System.out.println("第"+i+"个任务");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
////            System.out.println("第"+i+"个任务");
//        }

        //添加新的任务线程，5秒后执行
//        scheduler.addTask(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("第"+context.getCurrentTick()+"个slot。");
//            }
//        },7);

        System.out.println(LocalDateTime.now());



//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(scheduler,0,1000);
//        System.in.read();

//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(scheduler,0,context.getTickDuration()*1000L);
//        System.in.read();


    }

    public void addTask(Runnable task, int delays) {
        timerContext.addTask(task, delays);
    }

    /**
     * 定时检测，如果定时器触发时间到了就从集合中删除并执行任务，否则圈数减一。
     */
    @Override
    public void run() {
        System.out.println("执行run。。");
        if(timerContext == null){
            return;
        }

        //启动任务线程
        Queue<TaskSlot> taskSlots = timerContext.getCurrentTasks();
        System.out.println("taskSlots123456:"+taskSlots);
//        synchronized (taskSlots) {
//
//            Iterator<TaskSlot> iterator = taskSlots.iterator();
//            while(iterator.hasNext()){
//                TaskSlot timer = iterator.next();
//                //是否已到该执行的slot
//                if(timer.isTimeOut()){
////                    iterator.remove();
//                    System.out.println("执行任务并移除该任务");
//                    ;
////                    new Thread();
////                    new Thread(timer.getTask()).start();
//                }else{
//                    //不符合执行条件则跳过，圈数减一
//                    timer.cutDown();
//                }
//            }
//
//        }

        //currentIndex在（0—tick）的范围中循环
        timerContext.tick();
    }

    public TimerContext getTimerContext() {
        return timerContext;
    }

    public void setTimerContext(TimerContext timerContext) {
        this.timerContext = timerContext;
    }
}
