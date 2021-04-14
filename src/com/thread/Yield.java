package com.thread;

public class Yield {

    static class MyYield implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--> Start");
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "--> end");
        }
    }

    public static void main(String[] args) {
        MyYield my = new MyYield();

        new Thread(my,"a").start();
        new Thread(my,"b").start();
    }
}
