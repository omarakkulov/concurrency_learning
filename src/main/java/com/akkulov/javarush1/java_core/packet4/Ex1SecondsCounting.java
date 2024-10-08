package com.akkulov.javarush1.java_core.packet4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture10; Считаем секунды
 */
public class Ex1SecondsCounting {

  public static void main(String[] args) throws IOException {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(in);

    //create and run thread
    Stopwatch stopwatch = new Stopwatch();
    stopwatch.start();

    //read a string
    reader.readLine();
    stopwatch.interrupt();

    //close streams
    reader.close();
    in.close();
  }

  public static class Stopwatch extends Thread {

    private int seconds;

    public void run() {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          Thread.sleep(1000);
          seconds++;
        }
      } catch (InterruptedException e) {
        System.out.println(seconds);
      }
    }
  }
}
