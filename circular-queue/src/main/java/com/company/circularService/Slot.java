package com.company.circularService;

/**
 * 环形队列数据结构
 */
public class Slot {

    private int cycle;
    private int delay;
    private Runnable callback;

    public Slot(int cycle, int task, Runnable callback) {
        this.cycle = cycle;
        this.delay = task;
        this.callback = callback;
    }

    public Slot() {

    }

    public boolean isTimeOut(){
        return cycle <= 0;
    }

    public void cutDown(){
        cycle --;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public int getTask() {
        return delay;
    }

    public void setTask(int task) {
        this.delay = task;
    }

    public Runnable getCallback() {
        return callback;
    }

    public void setCallback(Runnable callback) {
        this.callback = callback;
    }
}
