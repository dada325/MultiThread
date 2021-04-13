package com.thread;


import java.util.concurrent.*;

/**
 * Race test with multi thread
 */
public class CRace implements Callable<Integer> {

    private static String winner;
    @Override
    public Integer call() throws Exception {
        for (int steps = 1; steps <= 100; steps ++){
            if (Thread.currentThread().getName().equals("r") && steps%10 ==0){
                    Thread.sleep(1);
            }
            System.out.println(Thread.currentThread().getName() + "-->" + steps);
            //比赛是否结束了呢
            boolean flag = gameOver(steps);
            if(flag){
                return steps;
            }
        }
        return null;
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //同一份资源
        CRace r = new CRace();
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Integer> result1 = ser.submit(r);
        Future<Integer> result2 = ser.submit(r);
        //获取结果
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r1 + " -->"+ r2);
        //关闭服务
        ser.shutdownNow();
    }
}
