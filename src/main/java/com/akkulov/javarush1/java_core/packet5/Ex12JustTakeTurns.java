package com.akkulov.javarush1.java_core.packet5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Только по-очереди!
 */
public class Ex12JustTakeTurns {

  public static volatile BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in));

  public static void main(String[] args) throws InterruptedException {
    Read3Strings t1 = new Read3Strings();
    Read3Strings t2 = new Read3Strings();

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    t1.printResult();
    t2.printResult();
  }

  public static class Read3Strings extends Thread {

    private final StringBuilder sb = new StringBuilder();

    @Override
    public void run() {
      try {
        for (int i = 0; i < 3; i++) {
          String value = reader.readLine();
          sb.append(value).append(" ");
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    public void printResult() {
      System.out.println(sb.toString());
    }
  }
}
