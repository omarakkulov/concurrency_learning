package com.akkulov.dmdev.simple;

public class SimpleThread extends Thread {

  public SimpleThread(String threadName) {
    super(threadName);
  }

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
      System.out.println(getName());
      stop();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
