package com.company.scheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TimerContext {

    public static final int DEFAUT_TICKS = 15;
    public static final int DEFAUT_TICK_DERATION = 1;

    //一圈的长度
    private int ticks = DEFAUT_TICKS;
    //每tick一次的时间间隔（s）
    private int tickDuration = DEFAUT_TICK_DERATION;

    //当前标记和tick
    private Map<Integer, Queue<TaskSlot>> taskSlots;
    /**
     * 锁提供了两种主要特性：互斥（mutual exclusion） 和可见性（visibility）。
     * 互斥即一次只允许一个线程持有某个特定的锁，因此可使用该特性实现对共享数据的协调访问协议，
     * 这样，一次就只有一个线程能够使用该共享数据。
     * 可见性要更加复杂一些，它必须确保释放锁之前对共享数据做出的更改对于随后获得该锁的另一个线程是可见的
     * 如果没有同步机制提供的这种可见性保证，线程看到的共享变量可能是修改前的值或不一致的值，这将引发许多严重问题。
     */
    //初始化当前指针0
    private volatile int currentTick = 0;

    public TimerContext(int ticks,int tickDuration){
        this.ticks = ticks;
        this.tickDuration = tickDuration;
        //初始化任务队列
        init();
    }

    /**
     * 环形队列形成
     */
    private void init() {
        System.out.println("init..");
        taskSlots = new HashMap<Integer, Queue<TaskSlot>>();
        for(int i=0;i<ticks;i++){
            System.out.println("ticks:"+ticks);
            taskSlots.put(i,new ConcurrentLinkedDeque<TaskSlot>());

        }
    }


    /**
     * 添加一个定时任务并计算需要走的圈数和落脚的index
     * @return
     */
    public void addTask(Runnable task,int delays){

        //判断任务和延时
        if (task == null)
            throw new NullPointerException("task must not be null");

        if (delays <=0)
            throw new IllegalArgumentException("delays must be greater than 0");


        //计算任务圈数
        int allSeconds = ticks * tickDuration;
        int cycles = delays/allSeconds;
        //任务应该落在的格数
        int index = (delays%allSeconds)/tickDuration + currentTick;
//        int index = (delays%allSeconds)/tickDuration + currentTick;
        System.out.println("第几个slot执行："+index);

        //任务定义
        TaskSlot taskSlot = new TaskSlot(cycles,delays,task);
        System.out.println("taskSlot:"+taskSlot);
        Queue<TaskSlot> tasks = taskSlots.get(index);
        synchronized (tasks){
            //TODO:
            System.out.println("tasks:"+tasks);
            //添加新任务
            tasks.add(taskSlot);
        }

    }


    //每跳一格更新currentTick指针
    public int tick(){
        currentTick = (currentTick +1)%ticks;
        return currentTick;
    }

    public Queue<TaskSlot> getCurrentTasks() {
        return taskSlots.get(currentTick);
    }


    public int getTicks() {
        return ticks;
    }

    public int getTickDuration() {
        return tickDuration;
    }

    public Map<Integer, Queue<TaskSlot>> getTaskSlots() {
        return taskSlots;
    }

    public int getCurrentTick() {
        return currentTick;
    }

    @Override
    public String toString() {
        return "TimerContext{" +
                "ticks=" + ticks +
                ", tickDuration=" + tickDuration +
                ", taskHolders=" + taskSlots +
                ", currentTick=" + currentTick +
                '}';
    }
}





