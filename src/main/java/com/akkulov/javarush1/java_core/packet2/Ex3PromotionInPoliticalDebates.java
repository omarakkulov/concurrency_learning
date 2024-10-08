package com.akkulov.javarush1.java_core.packet2;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture05; Продвижение на политических дебатах
 */
public class Ex3PromotionInPoliticalDebates {

  public static int totalSpeechCount = 200;
  public static int utterancesPerSpeech = 1000000;

  public static void main(String[] args) throws InterruptedException {
    Politician ivanov = new Politician("Иванов");
    ivanov.join();

    Politician petrov = new Politician("Петров");
    Politician sidorov = new Politician("Сидоров");

    while (ivanov.getSpeechCount() + petrov.getSpeechCount() + sidorov.getSpeechCount() < totalSpeechCount) {
    }

    System.out.println(ivanov);
    System.out.println(petrov);
    System.out.println(sidorov);
  }

  public static class Politician extends Thread {

    private volatile int utteranceCount;

    public Politician(String name) {
      super(name);
      start();
    }

    public void run() {
      while (utteranceCount < totalSpeechCount * utterancesPerSpeech) {
        utteranceCount++;
      }
    }

    public int getSpeechCount() {
      return utteranceCount / utterancesPerSpeech;
    }

    @Override
    public String toString() {
      return String.format("%s сказал речь %d раз", getName(), getSpeechCount());
    }
  }
}
