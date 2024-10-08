package com.akkulov.javarush1.java_core.packet9.ex3_restaurant;

public class Table {

  private static byte tableNumber;
  private byte number = ++tableNumber;

  public Order getOrder() {
    return new Order(number);
  }
}
