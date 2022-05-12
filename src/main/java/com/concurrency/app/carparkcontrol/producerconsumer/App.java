package com.concurrency.app.carparkcontrol.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        Buffer<Character> b = new BufferImpl<>(2);
        Consumer c = new Consumer(b);
        Producer p = new Producer(b);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(p);
        executor.execute(c);
    }
}
