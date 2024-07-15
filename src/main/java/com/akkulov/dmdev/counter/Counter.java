package com.akkulov.dmdev.counter;

public class Counter {

  private volatile int count;

  public int getCount() {
    synchronized (this) {
      return count;
    }
  }

  public void increment() {
    count++;
  }

  public void decrement() {
    synchronized (this) {
      count--;
    }
  }
}
