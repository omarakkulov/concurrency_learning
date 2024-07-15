package com.akkulov.dmdev.shop.shop2;

import com.akkulov.dmdev.shop.Cashbox;
import java.util.concurrent.BlockingQueue;

public class BuyerThread2 extends Thread {

  private final BlockingQueue<Cashbox> cashboxes;

  public BuyerThread2(BlockingQueue<Cashbox> cashboxes, String threadName) {
    super(threadName);
    this.cashboxes = cashboxes;
  }

  @Override
  public void run() {
    try {
      Cashbox cashbox = cashboxes.take();

      System.out.println(
          "Покупатель " + getName() + " обслуживается на кассе " + cashbox.getId()
      );

      Thread.sleep(500);

      System.out.println(
          "Покупатель " + getName() + " закончил обслуживаться на кассе " + cashbox.getId()
      );

      cashboxes.put(cashbox);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
