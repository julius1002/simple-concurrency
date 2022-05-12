package com.concurrency.app.carparkcontrol.semaphores;

public class Semaphore {

    private int value;

    public Semaphore(int value) {
        this.value = value;
    }

    synchronized public void up() {
        ++value;
        notify(); // notify is not used to signal the change in state, but for the value to be incremented
    }

    synchronized public void down() throws InterruptedException {
        while (value == 0) wait();
        --value;
    }
}
