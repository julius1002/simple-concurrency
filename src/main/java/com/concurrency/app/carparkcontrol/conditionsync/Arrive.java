package com.concurrency.app.carparkcontrol.conditionsync;


public record Arrive(CarParkControl carParkControl) implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                carParkControl.arrive();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
