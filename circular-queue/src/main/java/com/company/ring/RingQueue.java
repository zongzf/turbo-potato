package com.company.ring;

import com.company.circularService.Slot;
import com.company.scheduler.TaskSlot;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class RingQueue {
    public static final int DEFAUT_TICKS = 10;
    public static final int DEFAUT_TICK_DERATION = 1;

    private int ticks = DEFAUT_TICKS;
    private int tickDuration = DEFAUT_TICK_DERATION;

    private Map<Integer, Queue<RingSlot>> ringSlots;

    private volatile int currentTick = 0;

    public RingQueue(int ticks, int tickDuration){
        this.ticks = ticks;
        this.tickDuration = tickDuration;
        init();
    }

    /**
     * 环形队列形成
     */
    private void init() {
        System.out.println("init..");
        ringSlots = new HashMap<Integer, Queue<RingSlot>>();
        for(int i=0;i<ticks;i++){
            ringSlots.put(i,new ConcurrentLinkedDeque<RingSlot>());
            System.out.println("加入队列个数："+ringSlots.size());

        }
    }


    /**
     * 添加一个定时任务并计算需要走的圈数和落脚的index
     * @return
     */
    public void addTask(Runnable task,int delays){

        int allSeconds = ticks * tickDuration;
        int cycles = delays/allSeconds;
        int index = (delays%allSeconds)/tickDuration + currentTick;

        //任务定义
        RingSlot ringSlot = new RingSlot(cycles,delays,task);
        System.out.println("ringSlot:"+ringSlot);
        Queue<RingSlot> tasks = ringSlots.get(index);
        synchronized (tasks){
            //TODO:
            System.out.println("tasks:"+tasks);
            //添加新任务
            tasks.add(ringSlot);
        }

    }


    //每跳一格更新currentTick指针
    public int tick(){
        currentTick = (currentTick +1)%ticks;
        return currentTick;
    }

    public RingQueue(Map<Integer, Queue<RingSlot>> ringSlots) {
        this.ringSlots = ringSlots;
    }

    public RingQueue(int ticks) {
        this.ticks = ticks;
    }

    public void setTickDuration(int tickDuration) {
        this.tickDuration = tickDuration;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public void setRingSlots(Map<Integer, Queue<RingSlot>> ringSlots) {
        this.ringSlots = ringSlots;
    }

    public void setCurrentTick(int currentTick) {
        this.currentTick = currentTick;
    }

    public Queue<RingSlot> getCurrentTasks() {
        return ringSlots.get(currentTick);
    }


    public int getTicks() {
        return ticks;
    }

    public int getTickDuration() {
        return tickDuration;
    }

    public Map<Integer, Queue<RingSlot>> getRingSlots() {
        return ringSlots;
    }

    public int getCurrentTick() {
        return currentTick;
    }

    @Override
    public String toString() {
        return "TimerContext{" +
                "ticks=" + ticks +
                ", tickDuration=" + tickDuration +
                ", ringSlots=" + ringSlots +
                ", currentTick=" + currentTick +
                '}';
    }
}
