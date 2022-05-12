package com.concurrency.app.carparkcontrol.producerconsumer;

public interface Buffer<T> {
    void put(T o) throws InterruptedException;

    T get() throws InterruptedException;
}
