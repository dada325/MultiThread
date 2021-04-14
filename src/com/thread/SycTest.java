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

    static class Drawing extends Thread{

        Account account;
        int drawingMoney;
        int poketTotal;

        public Drawing(Account account, int drawingMoney, String name) {
            super(name);
            this.account = account;
            this.drawingMoney = drawingMoney;
        }

        @Override
        public void run() {
            if(account.money -drawingMoney < 0){
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
           poketTotal += drawingMoney;
            System.out.println(this.getName() +" --> 账户余额" + account.money);
            System.out.println(this.getName() +" --> 口袋里" + poketTotal);
        }
    }

    public static void main(String[] args) {
        Account account = new Account(100, "sal");
        Drawing you = new Drawing(account, 80, "me");
        Drawing boss = new Drawing(account, 90, "boss");
        you.start();
        boss.start();
    }
}
