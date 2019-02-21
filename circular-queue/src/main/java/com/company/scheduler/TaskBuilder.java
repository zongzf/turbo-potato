package com.company.scheduler;

import java.util.TimerTask;

public class TaskBuilder extends TimerTask {

    private int id;

    public TaskBuilder(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("这是第"+id+"个线程");
    }
}
