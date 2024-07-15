package com.akkulov.dmdev.shop.shop1;

import com.akkulov.dmdev.shop.Cashbox;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Cashbox cashbox1 = new Cashbox();
//    Cashbox cashbox2 = new Cashbox();
//    Cashbox cashbox3 = new Cashbox();

    Queue<Cashbox> queue = new ArrayDeque<>(1);
    queue.add(cashbox1);
//    queue.add(cashbox2);
//    queue.add(cashbox3);

    List<BuyerThread> threads = Stream.of(
            new BuyerThread(queue, "Buyer1"),
            new BuyerThread(queue, "Buyer2"),
            new BuyerThread(queue, "Buyer3"),
            new BuyerThread(queue, "Buyer4"),
            new BuyerThread(queue, "Buyer5")
        )
        .peek(BuyerThread::start)
        .collect(Collectors.toList());

    for (BuyerThread thread : threads) {
      thread.join();
    }
  }
}
