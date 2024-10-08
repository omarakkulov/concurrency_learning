package com.akkulov.javarush1.java_core.packet4;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture10; Отсчет на гонках
 */
public class Ex2RaceCountdown {

  public static volatile int numSeconds = 3;

  public static void main(String[] args) throws InterruptedException {
    RacingClock clock = new RacingClock();
    Thread.sleep(3500);
    clock.interrupt();
    //add your code here - добавь код тут
  }

  public static class RacingClock extends Thread {

    private final boolean isNumSecondsMoreThanThreeSeconds = numSeconds > 3.5;

    public RacingClock() {
      start();
    }

    public void run() {
      try {
        int tmp = numSeconds;

        while (!isInterrupted() && tmp >= 0) {
          if (tmp == 0) {
            if (isNumSecondsMoreThanThreeSeconds) {
              interrupt();
            } else {
              System.out.print("Марш!");
            }
          } else {
            System.out.print(tmp + " ");
            Thread.sleep(1000);
          }
          tmp--;
        }
      } catch (InterruptedException e) {
        System.out.println("Прервано!");
      }
    }
  }
}
