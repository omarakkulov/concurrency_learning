package com.akkulov.javacore.javarush.packet5;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Создание по образцу
 */
public class Ex9CreationAccordingToPattern {

  public static int number = 5;

  public static void main(String[] args) {
    new Thread(new CountdownRunnable(), "Уменьшаем").start();
    new Thread(new CountUpRunnable(), "Увеличиваем").start();

  }

  public static class CountUpRunnable implements Runnable {

    private int countIndexUp = 1;

    @Override
    public void run() {
      try {
        while (countIndexUp != Ex9CreationAccordingToPattern.number + 1) {
          System.out.println(this);
          countIndexUp++;

          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    public String toString() {
      return Thread.currentThread().getName() + ": " + countIndexUp;
    }
  }


  public static class CountdownRunnable implements Runnable {

    private int countIndexDown = Ex9CreationAccordingToPattern.number;

    public void run() {
      try {
        while (true) {
          System.out.println(this);
          countIndexDown--;

          if (countIndexDown == 0) {
            return;
          }

          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
      }
    }

    public String toString() {
      return Thread.currentThread().getName() + ": " + countIndexDown;
    }
  }
}
