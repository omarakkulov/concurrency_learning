package com.akkulov.dmdev.shop.shop1;

import com.akkulov.dmdev.shop.Cashbox;
import java.util.Queue;

public class BuyerThread extends Thread {

  private final Queue<Cashbox> cashboxes;

  public BuyerThread(Queue<Cashbox> cashboxes, String threadName) {
    super(threadName);
    this.cashboxes = cashboxes;
  }

  @Override
  public void run() {
    try {
      synchronized (cashboxes) {
        while (true) {
          if (!cashboxes.isEmpty()) {
            Cashbox cashbox = cashboxes.remove();

            System.out.println(
                "Покупатель " + getName() + " обслуживается на кассе " + cashbox.getId()
            );

            cashboxes.wait(20);

            System.out.println(
                "Покупатель " + getName() + " закончил обслуживаться на кассе " + cashbox.getId()
            );

            cashboxes.add(cashbox);
            cashboxes.notifyAll();
            break;
          } else {
            System.out.println("Покупатель " + getName() + " ожидает свободную кассу");
            cashboxes.wait();
          }
        }
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
