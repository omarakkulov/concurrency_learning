package com.akkulov.dmdev.daemon;

public class DaemonThreadExample {
  public static void main(String[] args) {
    Thread daemonThread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          System.out.println("Демон-поток работает в фоне...");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });

    // Устанавливаем поток как демон
    daemonThread.setDaemon(true);

    // Запускаем поток
    daemonThread.start();

    // Основной поток ждет 3 секунды, затем завершает работу
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Основной поток завершен");
  }
}
