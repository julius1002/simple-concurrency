
package com.concurrency.app.carparkcontrol.conditionsync;


public class CarParkControl {
    private int spaces;
    private final int capacity;

    public CarParkControl(int spaces, int capacity) {
        this.spaces = spaces;
        this.capacity = capacity;
    }

    synchronized void arrive() throws InterruptedException {
        while (spaces == 0) wait(); //thread exits monitor (guard), conditional synchronization, blocks calling thread
        System.out.println("arrive " + spaces);
        Thread.sleep(1000);
        --spaces;
        notify(); //thread enters montitor
    }

    synchronized void departure() throws InterruptedException {
        while (spaces == capacity) wait(); //thread exits monitor (guard), conditional synchronization, blocks calling thread
        System.out.println("departure " + spaces);
        Thread.sleep(1000);
        ++spaces;
        notify(); //thread enters montitor
    }
}
