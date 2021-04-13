package com.thread;


import java.sql.SQLOutput;

/**
 * Race test with multi thread
 */
public class Race implements Runnable{

    private static String winner;
    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps ++){
            if (Thread.currentThread().getName().equals("r") && steps%10 ==0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "-->" + steps);
            //比赛是否结束了呢
            boolean flag = gameOver(steps);
            if(flag){
                break;
            }
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null){
            return true;
        }else{
            if(steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner is " + winner);
                return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        //同一份资源
        Race r = new Race();
        //两个
        new Thread(r,"t").start();
        new Thread(r, "r").start();
    }
}
