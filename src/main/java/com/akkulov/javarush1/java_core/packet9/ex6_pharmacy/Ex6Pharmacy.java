package com.akkulov.javarush1.java_core.packet9.ex6_pharmacy;

import java.util.ArrayList;
import java.util.List;

public class Ex6Pharmacy {

  public static DrugsController drugsController = new DrugsController();
  public static boolean isStopped = false;

  public static void main(String[] args) throws InterruptedException {
    Thread apteka = new Thread(new Apteka(), "Apteka");
    Thread man = new Thread(new Person(), "Мужчина");
    Thread woman = new Thread(new Person(), "Женщина");

    apteka.start();
    man.start();
    woman.start();

    Thread.sleep(1000);
    isStopped = true;

    if (isStopped) {
      apteka.interrupt();
      man.interrupt();
      woman.interrupt();
    }
  }

  public static class Apteka implements Runnable {

    @Override
    public void run() {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          drugsController.sell(getRandomDrug(), getRandomCount());
          Thread.sleep(300);
        }
      } catch (InterruptedException e) {
      }
    }
  }

  public static class Person implements Runnable {

    @Override
    public void run() {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          drugsController.buy(getRandomDrug(), getRandomCount());
          Thread.sleep(100);
        }
      } catch (InterruptedException e) {
      }
    }
  }

  public static int getRandomCount() {
    return (int) (Math.random() * 3) + 1;
  }

  public static Drug getRandomDrug() {
    int index = (int) ((Math.random() * 1000) % (DrugsController.allDrugs.size()));
    List<Drug> drugs = new ArrayList<>(DrugsController.allDrugs.keySet());
    return drugs.get(index);
  }

  private static void waitAMoment() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
    }
  }
}
