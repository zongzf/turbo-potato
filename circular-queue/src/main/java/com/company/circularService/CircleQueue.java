package com.company.circularService;

import com.company.scheduler.TaskSlot;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CircleQueue {

    public CircleQueue() {

    }

    private int slotNumber = 10;
    private int jump = 1;
    private Map<Integer, Queue<Slot>> slotMap;
    private int currentIndex = 0;

    public HashMap<Integer,Queue<Slot>> create(int slotNumber,int jump){
        HashMap<Integer, Queue<Slot>> slotMap = new HashMap<Integer, Queue<Slot>>();
        for(int i=0;i<slotNumber;i++){
            slotMap.put(i,new ConcurrentLinkedDeque<Slot>());
            //todo:
//            slotMap.put(i, new Set<Slot>() {
//                @Override
//                public int size() {
//                    return 0;
//                }
//
//                @Override
//                public boolean isEmpty() {
//                    return false;
//                }
//
//                @Override
//                public boolean contains(Object o) {
//                    return false;
//                }
//
//                @Override
//                public Iterator<Slot> iterator() {
//                    return null;
//                }
//
//                @Override
//                public Object[] toArray() {
//                    return new Object[0];
//                }
//
//                @Override
//                public <T> T[] toArray(T[] a) {
//                    return null;
//                }
//
//                @Override
//                public boolean add(Slot slot) {
//                    return false;
//                }
//
//                @Override
//                public boolean remove(Object o) {
//                    return false;
//                }
//
//                @Override
//                public boolean containsAll(Collection<?> c) {
//                    return false;
//                }
//
//                @Override
//                public boolean addAll(Collection<? extends Slot> c) {
//                    return false;
//                }
//
//                @Override
//                public boolean retainAll(Collection<?> c) {
//                    return false;
//                }
//
//                @Override
//                public boolean removeAll(Collection<?> c) {
//                    return false;
//                }
//
//                @Override
//                public void clear() {
//
//                }
//
//                @Override
//                public boolean equals(Object o) {
//                    return false;
//                }
//
//                @Override
//                public int hashCode() {
//                    return 0;
//                }
//            });
        }
        System.out.println("111"+slotMap);
        return slotMap;
    }

    public int jumpNext(){
        currentIndex = (currentIndex +1)%jump;
        return currentIndex;
    }

    public void addTask(Runnable callback,int delay){

        int allSeconds = slotNumber * jump;
        int cycles = delay/allSeconds;
        int index = (delay%allSeconds)/jump + currentIndex;
        Slot slot = new Slot(cycles,delay,callback);
        Queue<Slot> slotSet = slotMap.get(index);
        synchronized (slotSet){
            System.out.println(slotSet+"666");
            slotSet.add(slot);
        }

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

    public Map<Integer, Queue<Slot>> getSlotMap() {
        return slotMap;
    }

    public void setSlotMap(Map<Integer, Queue<Slot>> slotMap) {
        this.slotMap = slotMap;
    }

    public Queue<Slot> getCurrentSlot(){
        return slotMap.get(currentIndex);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public CircleQueue(int slotNumber, int jump, Map<Integer, Queue<Slot>> slotMap, int currentIndex) {
        this.slotNumber = slotNumber;
        this.jump = jump;
        this.slotMap = slotMap;
        this.currentIndex = currentIndex;
    }
}
