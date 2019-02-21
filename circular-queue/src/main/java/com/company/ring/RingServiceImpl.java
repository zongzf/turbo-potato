package com.company.ring;

import com.company.scheduler.TaskSlot;
import com.company.scheduler.TimerContext;
import com.company.scheduler.TimerScheduler;

import java.util.Iterator;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class RingServiceImpl implements RingService {
    private RingQueue ringQueue;

    public RingServiceImpl(RingQueue ringQueue) {
        this.ringQueue = ringQueue;
    }

    public RingQueue getRingQueue() {
        return ringQueue;
    }

    public void setRingQueue(RingQueue ringQueue) {
        this.ringQueue = ringQueue;
    }

    @Override
    public void timeOut() {
        RingQueue queue = new RingQueue(5,1);
        System.out.println("创建队列完成"+queue.toString());
//        RingServiceImpl ringService = new RingServiceImpl(queue);
        Task task = new Task(queue);
        System.out.println("进入timer");
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task,0,1000);




    }

//    public void addTask(Runnable task, int delays) {
//        ringQueue.addTask(task, delays);
//    }



    //todo:
    public void addTask(Runnable task,int delays){
        ringQueue.addTask(task,delays);

    }

    public void run(){
        System.out.println("test");
    }


//    @Override
//    public void run() {
//        System.out.println("进入run");
//        if(ringQueue == null){
//            return;
//        }
//
//        //启动任务线程
//        Queue<RingSlot> ringSlots = ringQueue.getCurrentTasks();
//        System.out.println("ringSlots123456:"+ringSlots);
//        synchronized (ringSlots) {
//
//            Iterator<RingSlot> iterator = ringSlots.iterator();
//            while(iterator.hasNext()){
//                RingSlot ringSlot = iterator.next();
//                //是否已到该执行的slot
//                if(ringSlot.isTimeOut()){
//                    iterator.remove();
//                    System.out.println("已执行。。");
//                }else{
//
//                    ringSlot.cutDown();
//                }
//            }
//
//        }
//
//        //currentIndex在（0—tick）的范围中循环
//        ringQueue.tick();
//    }
}
