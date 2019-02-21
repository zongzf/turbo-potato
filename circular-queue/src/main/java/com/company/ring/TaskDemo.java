package com.company.ring;

import java.util.TimerTask;

public class TaskDemo extends TimerTask {
    @Override
    public void run() {
        System.out.println("test");
    }
}
