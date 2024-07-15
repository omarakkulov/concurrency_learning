package com.akkulov.dmdev.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.ToString;

@ToString(exclude = "lock")
public class Account {

  private final Lock lock = new ReentrantLock();

  private static int generator = 1;
  private int cash;
  private int id;

  public Account(int cash) {
    this.id = generator++;
    this.cash = cash;
  }

  public void addCash(int amount) {
    cash += amount;
  }

  public void subtractCash(int amount) {
    cash -= amount;
  }

  public int getCash() {
    return cash;
  }

  public Lock getLock() {
    return lock;
  }
}
