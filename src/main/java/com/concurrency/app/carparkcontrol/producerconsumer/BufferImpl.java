package com.concurrency.app.carparkcontrol.producerconsumer;

public class BufferImpl<T> implements Buffer<T> {
    protected T[] buf;
    protected int in = 0;
    protected int out = 0;
    protected int count = 0;
    protected int size;


    public BufferImpl(int size) {
        this.size = size;
        buf = (T[]) new Object[size];
    }

    @Override
    public synchronized void put(T o) throws InterruptedException {
        while (count == size) wait();
        System.out.println(count);
        buf[in] = o;
        ++count;
        in = (in + 1) % size;
        notifyAll();
    }

    @Override
    public synchronized T get() throws InterruptedException {
        while (count == 0) wait();
        System.out.println(count);
        T o = buf[out];
        buf[out] = null;
        --count;
        out = (out + 1) % size;
        notifyAll();
        return o;
    }
}
