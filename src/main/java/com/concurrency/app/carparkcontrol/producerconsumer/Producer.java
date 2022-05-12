package com.concurrency.app.carparkcontrol.producerconsumer;

public class Producer implements Runnable {
    Buffer<Character> buf;

    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public Producer(Buffer<Character> buf) {
        this.buf = buf;
    }

    @Override
    public void run() {
        int ai = 0;
        while (true) {
            try {
                System.out.println("put " + alphabet.charAt(12));
                buf.put(alphabet.charAt(12));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ai = (ai + 1) % alphabet.length();
        }
    }
}
