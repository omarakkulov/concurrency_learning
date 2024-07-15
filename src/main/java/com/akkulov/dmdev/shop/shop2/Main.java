package com.akkulov.dmdev.shop.shop2;

import com.akkulov.dmdev.shop.Cashbox;
import com.akkulov.dmdev.shop.shop1.BuyerThread;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Cashbox cashbox1 = new Cashbox();
//    Cashbox cashbox2 = new Cashbox();
//    Cashbox cashbox3 = new Cashbox();

    BlockingQueue<Cashbox> queue = new ArrayBlockingQueue<>(1);
    queue.add(cashbox1);
//    queue.add(cashbox2);
//    queue.add(cashbox3);

    List<BuyerThread2> threads = Stream.of(
            new BuyerThread2(queue, "Buyer1"),
            new BuyerThread2(queue, "Buyer2"),
            new BuyerThread2(queue, "Buyer3"),
            new BuyerThread2(queue, "Buyer4"),
            new BuyerThread2(queue, "Buyer5")
        )
        .peek(BuyerThread2::start)
        .collect(Collectors.toList());

    for (BuyerThread2 thread : threads) {
      thread.join();
    }
  }

}
