package com.thread;

public class Ticket implements Runnable{
    private boolean flag = true;
    private int ticketNums = 100;
    @Override
    public  void run() {
        while(flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        test();
        }
    }

    public synchronized void test() {
        if (ticketNums <= 0){
            flag=false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }
    public static void main(String[] args){
        //一份资源
        Ticket t= new Ticket();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(t,"person1").start();
        new Thread(t,"person2").start();
        new Thread(t,"person3").start();
    }
}
