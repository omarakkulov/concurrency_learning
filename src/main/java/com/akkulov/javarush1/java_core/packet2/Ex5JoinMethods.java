package com.akkulov.javarush1.java_core.packet2;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture05; Расставь вызовы методов join().
 */
public class Ex5JoinMethods {

  public static void main(String[] args) throws InterruptedException {
    Cat cat1 = new Cat("Мурка");
    cat1.join();

    Cat cat2 = new Cat("Пушинка");
//    cat2.join();
  }

  private static void investigateWorld() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

  public static class Cat extends Thread {

    protected Kitten kitten1;
    protected Kitten kitten2;

    public Cat(String name) {
      super(name);
      kitten1 = new Kitten("Котенок 1, мама - " + getName());
      kitten2 = new Kitten("Котенок 2, мама - " + getName());
      start();
    }

    public void run() {
      System.out.println(getName() + " родила 2 котят");
      try {
        initAllKittens();
      } catch (InterruptedException e) {
      }
      System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
    }

    private void initAllKittens() throws InterruptedException {
      kitten1.start();
      kitten1.join();
      kitten2.start();
      kitten2.join();
    }
  }

  public static class Kitten extends Thread {

    public Kitten(String name) {
      super(name);
    }

    public void run() {
      System.out.println(getName() + ", вылез из корзинки");
      investigateWorld();
    }
  }
}
