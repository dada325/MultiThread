package com.thread;

public class Yield02 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i=0; i<100; i++){
                System.out.println("lambda..."+i);
            }
        }).start();

        for (int i=0; i<100; i++){
            if (i%20 == 0){
                Thread.yield(); //main yield

            }
            System.out.println("main"+ i);
        }
    }

}
