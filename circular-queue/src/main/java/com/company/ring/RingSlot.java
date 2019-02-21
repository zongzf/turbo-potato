package com.company.ring;

public class RingSlot {
    private int cycles;
    private int delays;
    private Runnable task;

    public RingSlot(){

    }

    public RingSlot(int cycles,int delays,Runnable task){
        this.cycles = cycles;
        this.delays = delays;
        this.task = task;
    }

    public boolean isTimeOut(){
        return cycles <= 0;
    }

    public void cutDown(){
        cycles--;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public int getDelays() {
        return delays;
    }

    public void setDelays(int delays) {
        this.delays = delays;
    }

    public Runnable getTask() {
        return task;
    }

    public void setTask(Runnable task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskHolder{" +
                "cycles=" + cycles +
                ", delays=" + delays +
                ", task=" + task +
                '}';
    }
}
