package com.akkulov.dmdev.list;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();

    ListThread listThread1 = new ListThread(list);
    ListThread listThread2 = new ListThread(list);
    ListThread listThread3 = new ListThread(list);
    ListThread listThread4 = new ListThread(list);
    ListThread listThread5 = new ListThread(list);

    listThread1.start();
    listThread2.start();
    listThread3.start();
    listThread4.start();
    listThread5.start();

    try {
      listThread1.join();
      listThread2.join();
      listThread3.join();
      listThread4.join();
      listThread5.join();
    } catch (InterruptedException e) {
      throw new RuntimeException();
    }

    System.out.println(list.size());
  }
}
