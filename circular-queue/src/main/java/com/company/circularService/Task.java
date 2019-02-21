package com.company.circularService;

import com.company.scheduler.TimerContext;

import java.util.*;

public class Task extends TimerTask {



    private CircleQueue circleQueue;

    public Task(CircleQueue circleQueue) {
        this.circleQueue = circleQueue;
    }


    public CircleQueue getCircleQueue() {
        return circleQueue;
    }

    public void setCircleQueue(CircleQueue circleQueue) {
        this.circleQueue = circleQueue;
    }



//    Task task = new Task(circleQueue);


    @Override
    public void run() {


        System.out.println("lai ");
        if(circleQueue == null){
            return;
        }

        //启动任务线程
        Queue<Slot> currentSlots = circleQueue.getCurrentSlot();
        synchronized (currentSlots) {
            Iterator<Slot> iterator = currentSlots.iterator();
            while(iterator.hasNext()){
                Slot currentSlot = iterator.next();
                if(currentSlot.isTimeOut()){
                    System.out.println("执行任务并移除该任务");
                    iterator.remove();
                }else{
                    currentSlot.cutDown();
                }
            }
        }
        circleQueue.jumpNext();
    }


}
