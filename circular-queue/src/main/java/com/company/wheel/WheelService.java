package com.company.wheel;

import io.netty.util.Timer;
import io.netty.util.TimerTask;

public interface WheelService {

    //超时监控接口
    void timeOut(int timeOut, int flag);
}
