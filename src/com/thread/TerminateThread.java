package com.thread;

public class TerminateThread implements Runnable{

    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(flag){
            System.out.println(name + "-->");
        }
    }
    //增加一个终止方法
    public void terminate() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread("我");
        new Thread(tt).start();

        for (int i = 0; i<=199; i++){
            if(i==88){
                tt.terminate();// 线程终止
                System.out.println("tt terminated");
            }
            System.out.println("main-->" + i);
        }
    }
}


