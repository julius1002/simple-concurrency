package com.concurrency.app.carparkcontrol.conditionsync;

public record Departure(CarParkControl carParkControl) implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                carParkControl.departure();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
