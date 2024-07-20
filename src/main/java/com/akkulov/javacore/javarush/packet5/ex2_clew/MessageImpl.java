package com.akkulov.javacore.javarush.packet5.ex2_clew;

public class MessageImpl implements Message, Runnable {

  @Override
  public void showWarning() {
    Thread.currentThread().interrupt();
  }

  @Override
  public void run() {
    Thread currentThread = Thread.currentThread();

    while (!currentThread.isInterrupted()) {

    }
  }
}
