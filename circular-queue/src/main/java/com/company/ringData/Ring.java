package com.company.ringData;



import java.util.HashMap;
import java.util.HashSet;

/**
 * 环形数据结构
 */
public class Ring {
    //环形包含的格数
    private int slotNumber = 10;
    //指针每次跳的格数
    private int jump = 1;
    //存储所有的slot
    private HashMap<Integer, HashSet<Slot>> slotMap;
    //当前指针所在的格数
    private int currentIndex = 0;


    /**
     * 初始化环形队列方法
     * @param slotNumber
     * @param jump
     * @return
     */
    public HashMap<Integer,HashSet<Slot>> create(int slotNumber,int jump){
//        HashMap<Integer,Set<Slot>> setHashMap = new HashMap<Integer, Set<Slot>>();
        for(int i=0;i<slotNumber;i++){
            slotMap.put(i,new HashSet<Slot>());
        }
        System.out.println("create new ringData:"+slotMap);
        return slotMap;
    }

    /**
     * 将新进入的任务放入环形队列中
     * @param task
     * @param i
     */
    public void addTask(Runnable task,int i){
        int cycle = i/slotNumber;
        int index = i%slotNumber + currentIndex;
        Slot slot = new Slot(cycle,task);
        slotMap.get(index).add(slot);
    }

    /**
     * 清空当前slot里的任务
     * @param index
     */
    public void cleanSlot(int index){
        slotMap.get(index).clear();
    }


    /**
     * 更新当前指针位置
     * @return
     */
    public int jumpToNext(){
        currentIndex = (currentIndex+1)%slotNumber;
        return currentIndex;
    }

    public Ring(int slotNumber, int jump, HashMap<Integer, HashSet<Slot>> slotMap, int currentIndex) {
        this.slotNumber = slotNumber;
        this.jump = jump;
        this.slotMap = slotMap;
        this.currentIndex = currentIndex;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getJump() {
        return jump;
    }

    public void setJump(int jump) {
        this.jump = jump;
    }

    public HashMap<Integer, HashSet<Slot>> getSlotMap() {
        return slotMap;
    }

    public void setSlotMap(HashMap<Integer, HashSet<Slot>> slotMap) {
        this.slotMap = slotMap;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    @Override
    public String toString() {
        return "Ring{" +
                "slotNumber=" + slotNumber +
                ", jump=" + jump +
                ", slotMap=" + slotMap +
                ", currentIndex=" + currentIndex +
                '}';
    }
}
