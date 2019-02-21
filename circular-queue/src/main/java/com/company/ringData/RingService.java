package com.company.ringData;

public interface RingService {

    //提供超时监控服务
    void timeOut(int timeOut,Runnable currentTask);

    void timeTest(int timeOut);

}
