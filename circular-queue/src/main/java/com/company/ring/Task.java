package com.company.ring;

import java.util.Iterator;
import java.util.Queue;
import java.util.TimerTask;

public class Task extends TimerTask {

    RingQueue ringQueue;

//    public RingQueue getRingQueue() {
//        return ringQueue;
//    }

//    public void setRingQueue(RingQueue ringQueue) {
//        this.ringQueue = ringQueue;
//    }

    public Task(RingQueue ringQueue) {
        this.ringQueue = ringQueue;
    }

    @Override
    public void run() {
        System.out.println("进入run");
        if(ringQueue == null){
            return;
        }

        Queue<RingSlot> ringSlots = ringQueue.getCurrentTasks();
        System.out.println("ringSlots123456:"+ringSlots);
//        synchronized (ringSlots) {
//            Iterator<RingSlot> iterator = ringSlots.iterator();
//            while(iterator.hasNext()){
//                RingSlot ringSlot = iterator.next();
//                if(ringSlot.isTimeOut()){
//                    iterator.remove();
//                }else{
//
//                    ringSlot.cutDown();
//                }
//            }
//
//        }

        //currentIndex在（0—tick）的范围中循环
        ringQueue.tick();
    }
}
