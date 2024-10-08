package com.akkulov.javarush1.java_core.packet7.ex4_synchronized_president;

public class OurPresident {

  private static OurPresident president;

  static {
    synchronized (OurPresident.class) {
      president = new OurPresident();
    }
  }

  private OurPresident() {
  }

  public static OurPresident getOurPresident() {
    return president;
  }
}
