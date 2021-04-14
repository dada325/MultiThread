package com.thread;

public class SycTest {

    static class Account{
        int money;
        String name;

        public Account(int money, String name) {
            this.money = money;
            this.name = name;
        }
    }

    static class SafeDrawing extends Thread{

        Account account;
        int drawingMoney;
        int poketTotal;

        public SafeDrawing(Account account, int drawingMoney, String name) {
            super(name);
            this.account = account;
            this.drawingMoney = drawingMoney;
        }

        @Override
        public void run() {
            test();
        }

        public void test() {
            synchronized (account) {
                if (account.money - drawingMoney < 0) {
                    return;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.money -= drawingMoney;
                poketTotal += drawingMoney;
                System.out.println(this.getName() + " --> 账户余额" + account.money);
                System.out.println(this.getName() + " --> 口袋里" + poketTotal);
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account(100, "sal");
        SafeDrawing you = new SafeDrawing(account, 80, "me");
        SafeDrawing boss = new SafeDrawing(account, 90, "boss");
        you.start();
        boss.start();
    }
}
