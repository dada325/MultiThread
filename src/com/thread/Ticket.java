package com.thread;

public class Ticket implements Runnable{

    private int ticketNums = 99;
    @Override
    public void run() {
        while(true) {
            if (ticketNums < 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
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
