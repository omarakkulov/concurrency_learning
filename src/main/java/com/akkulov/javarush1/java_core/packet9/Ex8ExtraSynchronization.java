package com.akkulov.javarush1.java_core.packet9;

public class Ex8ExtraSynchronization {

  public static void main(String[] args) {
    Thread myThread1 = new Thread(new MyRunnable("Коля", 35));
    Thread myThread2 = new Thread(new MyRunnable("Лена", 21));
    Thread myThread3 = new Thread(new MyRunnable("Ваня", 19));
    myThread1.start();
    myThread2.start();
    myThread3.start();
  }

  public static void printInfo(String name, int age) {
    synchronized (Ex8ExtraSynchronization.class) {
      for (int i = 1; i <= 5; i++) {
        System.out.print(i);
        System.out.print(".");
        System.out.print(" ");
        System.out.print("Меня");
        System.out.print(" ");
        System.out.print("зовут");
        System.out.print(" ");
        System.out.print(name);
        System.out.print(",");
        System.out.print(" ");
        System.out.print("мне");
        System.out.print(" ");
        System.out.print(age);
        System.out.println();
      }
    }
  }

  public static class MyRunnable implements Runnable {

    private final String name;
    private final int age;

    public MyRunnable(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public void run() {
      printInfo(name, age);
    }
  }
}
