package com.xinming.singleton;

public class DoubleCheck {

    // 构造函数私有化，防止外部直接实例
    private DoubleCheck() {
    }

    //volatile的作用是：保证内存的可见性，禁止指令重排序，但不能保证原子性
    private volatile static DoubleCheck instance;

    //双重检查防止同一时间有多个线程等待锁，会造成多个实例的情况
    public final static DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
