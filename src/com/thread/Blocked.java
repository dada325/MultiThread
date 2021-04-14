package com.thread;

public class Blocked {

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        while(true){
            Thread.sleep(1000);
            System.out.println(num--);
        }
    }
}

