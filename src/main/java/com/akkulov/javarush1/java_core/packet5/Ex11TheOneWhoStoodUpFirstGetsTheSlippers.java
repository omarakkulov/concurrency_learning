package com.akkulov.javarush1.java_core.packet5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Кто первый встал - того и
 * тапки
 */
public class Ex11TheOneWhoStoodUpFirstGetsTheSlippers {

  public static volatile AtomicInteger readStringCount = new AtomicInteger(0);
  public static volatile BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    //read count of strings
    int count = Integer.parseInt(reader.readLine());

    //init threads
    ReaderThread consoleReader1 = new ReaderThread();
    ReaderThread consoleReader2 = new ReaderThread();
    ReaderThread consoleReader3 = new ReaderThread();

    consoleReader1.start();
    consoleReader2.start();
    consoleReader3.start();

    while (count > readStringCount.get()) {
    }

    consoleReader1.interrupt();
    consoleReader2.interrupt();
    consoleReader3.interrupt();
    System.out.println("#1:" + consoleReader1);
    System.out.println("#2:" + consoleReader2);
    System.out.println("#3:" + consoleReader3);

    reader.close();
  }

  public static class ReaderThread extends Thread {

    private List<String> result = new ArrayList<>();

    public void run() {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          String consoleValue = reader.readLine();
          result.add(consoleValue);

          readStringCount.incrementAndGet();
        }
      } catch (IOException e) {
      }
    }

    @Override
    public String toString() {
      return result.toString();
    }
  }
}
