package com.akkulov.javarush1.java_core.packet1;

import java.util.Date;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture03.
 */
public class Ex5PogovorimOMuzike {

  public static int delay = 1000;

  public static void main(String[] args) {
    Thread violin = new Thread(new Violin("Player"));
    violin.start();
  }

  public static void sleepNSeconds(int n) {
    try {
      Thread.sleep((long) n * delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static class Violin implements MusicalInstrument {

    private final String owner;

    public Violin(String owner) {
      this.owner = owner;
    }

    @Override
    public void run() {
      var startDate = startPlaying();
      sleepNSeconds(1);
      var stopDate = stopPlaying();
      var duration = stopDate.getTime() - startDate.getTime();
      System.out.printf("Playing %s ms", duration);
    }

    public Date startPlaying() {
      System.out.println(this.owner + " is starting to play");
      return new Date();
    }

    public Date stopPlaying() {
      System.out.println(this.owner + " is stopping playing");
      return new Date();
    }

  }

  public interface MusicalInstrument extends Runnable {

    Date startPlaying();

    Date stopPlaying();
  }
}
