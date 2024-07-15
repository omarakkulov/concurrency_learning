package com.akkulov.dmdev.simple;

public class SimpleRunnable implements Runnable {

  @Override
  public void run() {
    System.out.println(
        "Hello World! " + Thread.currentThread().getState() + "=" + Thread.currentThread()
            .getName());
  }
}
