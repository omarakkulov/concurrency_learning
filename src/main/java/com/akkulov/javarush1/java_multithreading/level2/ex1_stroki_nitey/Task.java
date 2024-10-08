package com.akkulov.javarush1.java_multithreading.level2.ex1_stroki_nitey;

public class Task implements Runnable {

  private String initialString;
  private Ex1StrokiNitey solution;

  public Task(Ex1StrokiNitey solution, String initialString) {
    this.solution = solution;
    this.initialString = initialString;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    String str = this.initialString;
    do {
      System.out.println(name + str);
    } while ((str = solution.getPartOfString(str, name)) != null || !str.isEmpty());
  }
}
