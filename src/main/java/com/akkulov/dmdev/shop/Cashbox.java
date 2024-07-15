package com.akkulov.dmdev.shop;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Cashbox {

  private static int generator = 1;
  private final int id;

  public Cashbox() {
    this.id = generator++;
  }
}
