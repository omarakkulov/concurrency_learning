package com.akkulov.dmdev.deadlock;

public class Main2 {

  public static void main(String[] args) throws InterruptedException {
    Account account1 = new Account(200000);
    Account account2 = new Account(200000);

    AccountThread accountThread1 = new AccountThread(account1, account2);
    AccountThread accountThread2 = new AccountThread(account2, account1);

    accountThread1.start();
    accountThread2.start();

    accountThread1.join();
    accountThread1.join();

    System.out.println(account1);
    System.out.println(account2);
  }
}
