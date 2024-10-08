package com.akkulov.javarush1.java_core.packet5.ex2_clew;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Клубок
 */
public class Ex2Clew {

  public static List<Thread> threads = new ArrayList<>(5);

  static {
    threads.add(new Thread(() -> {
          while (true) {
          }
        })
    );

    threads.add(new Thread(() -> {
          try {
            throw new InterruptedException();
          } catch (InterruptedException e) {
            System.out.println(e.getClass().getName().split("\\.")[2]);
          }
        })
    );

    threads.add(new Thread(() -> {
          try {
            while (true) {
              System.out.println("Ура");
              Thread.sleep(500);
            }
          } catch (InterruptedException e) {
          }
        })
    );

    threads.add(new Thread(new MessageImpl()));

    threads.add(new Thread(() -> {
      Scanner scanner = new Scanner(System.in);

      int sumResult = 0;
      while (scanner.hasNext()) {
        String input = scanner.next();

        if (input.equalsIgnoreCase("N")) {
          break;
        }

        int anInt = Integer.parseInt(input);

        sumResult += anInt;
      }

      System.out.println(sumResult);
    }));
  }

  public static void main(String[] args) throws InterruptedException {
    threads.forEach(Thread::start);

    Thread.sleep(5000);

  }
}
