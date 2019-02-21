package com.company.circularService;

public interface CircularService {

    //超时监控，创建订单成功后调用
    void bookingTimeout(int timeout);



    void timeout(String s);

}
