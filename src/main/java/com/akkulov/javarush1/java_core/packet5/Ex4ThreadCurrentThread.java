package com.akkulov.javarush1.java_core.packet5;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Thread.currentThread - всегда
 * возвращает текущую нить
 */
public class Ex4ThreadCurrentThread {

  static int count = 5;

  public static void main(String[] args) {
    ThreadNamePrinter tnp = new ThreadNamePrinter();
    tnp.start();

    for (int i = 0; i < count; i++) {
      tnp.printMsg();
    }
  }

  public static class ThreadNamePrinter extends Thread {

    public void run() {
      for (int i = 0; i < count; i++) {
        printMsg();
      }
    }

    public void printMsg() {
      try {
        Thread t = currentThread();

        String name = t.getName();
        System.out.println("Name=" + name);

        Thread.sleep(1);
        //add sleep here - добавь sleep тут
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
