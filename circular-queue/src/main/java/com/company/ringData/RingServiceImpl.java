package com.company.ringData;

import java.util.Timer;
import java.util.TimerTask;

public class RingServiceImpl implements RingService{

    private Ring ring;

    public RingServiceImpl() {

    }


    @Override
    public void timeOut(int timeOut, Runnable currentTask) {
        //创建
        ring.create(10,1);
        System.out.println("create ring queue finished.");


    }

    @Override
    public void timeTest(int timeOut) {
        //创建
        ring.create(10,1);
        System.out.println("create ring queue finished.");

        /**
         * 加入新任务
         */
        ring.addTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个新任务");
            }
        },7);

        //定义currentIndex，定时每秒跳一格
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                //跳指针
                int index = ring.getCurrentIndex();
                System.out.println("当前所在格数："+index);


                //查看当前slot中是否有任务
                System.out.println("当前格中的任务："+ring.getSlotMap().get(index));


//                int tempCycle = ring.getSlotMap().get(index).iterator().next().getCycle();
                /**
                 * 判断当前格数中是否有要执行的任务
                 */
                if(ring.getSlotMap().get(index).isEmpty()){
                    int next = ring.jumpToNext();
                    System.out.println("即将跳到的所在格数："+next);
                    System.out.println("=========================");
                }else{
                    ring.getSlotMap().get(index).stream().forEach(e -> {
                        if(e.getCycle()!=0){
                            //圈数减一，继续跳格
                            e.cutCycle();
                            ring.jumpToNext();
                        } else {
                            //执行任务，并将该任务从当前格中移除
                            System.out.println("执行并删除..");
                            ring.cleanSlot(index);
                        }
                    });
//                    if(ring.getSlotMap().get(index).iterator().next().getCycle()==0){
//                        System.out.println("执行当前任务并删除当前格里的任务：");
//                        ring.cleanSlot(index);
//                    }else{
////                        tempCycle--;
//                        ring.jumpToNext();
//                    }

                    /**
                     * 未考虑多圈数的问题
                     */
//                    System.out.println("执行当前任务并删除当前格里的任务：");
//                    ring.cleanSlot(index);


                }

            }
        },0,1000);

    }

    public RingServiceImpl(Ring ring) {
        this.ring = ring;
    }

    public Ring getRing() {
        return ring;
    }

    public void setRing(Ring ring) {
        this.ring = ring;
    }
}
