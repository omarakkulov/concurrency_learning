package com.akkulov.dmdev.simple;

public class Main {

  public static void main(String[] args) {
    Thread mainThread = Thread.currentThread();
    System.out.println(mainThread.getName() + "=" + mainThread.getState());

    SimpleThread simpleThread = new SimpleThread("simpleThread");
    System.out.println(simpleThread.getName() + "=" + simpleThread.getState());

    simpleThread.start();
    System.out.println(simpleThread.getName() + "=" + simpleThread.getState() + "=");
    System.out.println(mainThread.getName() + "=" + mainThread.getState());

    try {
      System.out.println(mainThread.getName() + "=" + mainThread.getState());
      simpleThread.join();
      System.out.println(mainThread.getName() + "=" + mainThread.getState());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    SimpleRunnable simpleRunnable = new SimpleRunnable();
    Thread anime = new Thread(simpleRunnable, "anime");
    anime.start();

    System.out.println(mainThread.getName());
  }
}
