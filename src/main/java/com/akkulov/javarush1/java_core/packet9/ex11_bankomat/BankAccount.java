package com.akkulov.javarush1.java_core.packet9.ex11_bankomat;

import java.math.BigDecimal;

public class BankAccount {

  private BigDecimal balance;
  private String owner;

  public BankAccount(String owner) {
    this(BigDecimal.ZERO, owner);
  }

  public BankAccount(BigDecimal balance, String owner) {
    this.balance = balance;
    this.owner = owner;
  }

  public void deposit(BigDecimal money) {
    synchronized (balance) {
      BigDecimal newBalance = balance.add(money);
      System.out.println("Добавляем " + money + ", на счету " + newBalance);
      balance = newBalance;
    }
  }

  public void withdraw(BigDecimal money) throws NotEnoughMoneyException {
    synchronized (balance) {
      BigDecimal newBalance = balance.subtract(money);

      if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
        throw new NotEnoughMoneyException();
      }

      balance = newBalance;
      System.out.println("Тратим " + money + ", на счету " + balance);
    }
  }

  public void deposit(String money) {
    deposit(new BigDecimal(money));
  }

  public void withdraw(String money) throws NotEnoughMoneyException {
    withdraw(new BigDecimal(money));
  }
}
