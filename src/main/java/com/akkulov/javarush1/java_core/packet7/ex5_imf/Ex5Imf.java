package com.akkulov.javarush1.java_core.packet7.ex5_imf;


/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture04; МВФ
 */
public class Ex5Imf {
  public static void main(String[] args) {
    IMF fund = IMF.getFund();
    IMF anotherFund = IMF.getFund();
    System.out.println(fund == anotherFund);
  }
}
