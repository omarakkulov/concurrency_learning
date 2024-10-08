package com.akkulov.javarush1.java_core.packet9.ex3_restaurant;

public class Order {

  private long time;
  private byte tableNumber;

  public Order(byte tableNumber) {
    time = (long) (Math.random() * 200);
    this.tableNumber = tableNumber;
  }

  public long getTime() {
    return time;
  }

  public byte getTableNumber() {
    return tableNumber;
  }
}
