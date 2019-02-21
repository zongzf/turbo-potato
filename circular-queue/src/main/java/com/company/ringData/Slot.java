package com.company.ringData;


public class Slot {

    //第几圈执行
    private int cycle;

    //任务
    private Runnable currentTask;

    public void cutCycle(){
        cycle--;
    }

    public Slot(int cycle, Runnable currentTask) {
        this.cycle = cycle;
        this.currentTask = currentTask;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public Runnable getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(Runnable currentTask) {
        this.currentTask = currentTask;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "cycle=" + cycle +
                ", currentTask=" + currentTask +
                '}';
    }
}
