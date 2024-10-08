package com.akkulov.javarush1.java_core.packet8;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture06; Предложения
 */
public class Ex2Offers {

  public volatile static int proposal = 0;

  public static void main(String[] args) throws InterruptedException {
    new AcceptProposal().start();
    new MakeProposal().start();
    Thread.sleep(2000);
    System.out.println(proposal);
  }

  public static class MakeProposal extends Thread {

    @Override
    public void run() {
      int thisProposal = proposal;

      while (proposal < 10) {
        System.out.println("Сделано предложение №" + (thisProposal + 1));
        proposal = ++thisProposal;
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static class AcceptProposal extends Thread {

    @Override
    public void run() {
      int thisProposal = proposal;

      while (thisProposal < 10) {
        if (thisProposal != proposal) {
          System.out.println("Принято предложение №" + proposal);
          thisProposal = proposal;
        }

      }
    }
  }
}
