package com.akkulov;

public class Main {

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      try {
        System.out.println("Thread going to sleep");
        Thread.sleep(10000); // Поток засыпает на 10 секунд
        System.out.println("Thread woke up naturally");
      } catch (InterruptedException e) {
        System.out.println("Thread was interrupted during sleep");
        // Проверяем флаг прерывания
        System.out.println("Interrupted flag: " + Thread.currentThread().isInterrupted());
      }
    });

    thread.start();

    // Прерывание потока через 3 секунды
    try {
      Thread.sleep(3000); // Основной поток ждет 3 секунды
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    thread.interrupt(); // Прерывание потока
  }

}

