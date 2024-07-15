package com.akkulov.dmdev.list;

import java.util.List;

public class ListThread extends Thread {

  private final List<Integer> list;
  private final static Object listLock = new Object();

  public ListThread(List<Integer> list) {
    this.list = list;
  }

  @Override
  public void run() {
    synchronized (listLock) {
      for (int i = 0; i < 400; i++) {
        list.add(i);
      }
    }
  }
}
