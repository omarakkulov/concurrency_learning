package com.akkulov.javarush1.java_core.packet7.ex5_imf;

public final class IMF {

  private static IMF imf;

  private IMF() {
  }

  public static IMF getFund() {
    synchronized (IMF.class) {
      if (imf == null) {
        imf = new IMF();
      }
      return imf;
    }
  }
}
