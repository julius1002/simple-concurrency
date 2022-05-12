package com.concurrency.app.carparkcontrol.producerconsumer;

public class Consumer implements Runnable {
    Buffer<Character> buf;

    public Consumer(Buffer<Character> buf) {
        this.buf = buf;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Character c = buf.get();
                System.out.println("get " + c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
