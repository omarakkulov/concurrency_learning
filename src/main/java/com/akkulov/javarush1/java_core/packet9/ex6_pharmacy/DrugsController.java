package com.akkulov.javarush1.java_core.packet9.ex6_pharmacy;

import java.util.HashMap;
import java.util.Map;

public class DrugsController {

  public static final Map<Drug, Integer> allDrugs = new HashMap<>();   // <Лекарство, Количество>

  static {
    Drug panadol = new Drug();
    panadol.setName("Панадол");
    allDrugs.put(panadol, 5);

    Drug analgin = new Drug();
    analgin.setName("Анальгин");
    allDrugs.put(analgin, 18);

    Drug placebo = new Drug();
    placebo.setName("Плацебо");
    allDrugs.put(placebo, 1);
  }

  public void buy(Drug drug, int count) {
    String currentThreadName = Thread.currentThread().getName();

    synchronized (allDrugs) {
      if (!allDrugs.containsKey(drug)) {
        System.out.println("Нет в наличии");
        return;
      }

      Integer currentCount = allDrugs.get(drug);
      if (currentCount < count) {
        System.out.println(
            String.format("%s хочет %s %d шт. В наличии - %d", currentThreadName, drug.getName(),
                count,
                currentCount));
      } else {
        int drugsLeft = currentCount - count;
        allDrugs.put(drug, drugsLeft);
        System.out.println(
            String.format("%s купил(а) %s %d шт. Осталось - %d", currentThreadName, drug.getName(),
                count,
                drugsLeft));
      }
    }
  }

  public void sell(Drug drug, int count) {
    synchronized (allDrugs) {
      System.out.println(
          Thread.currentThread().getName() + " Закупка " + drug.getName() + " " + count);
      if (!allDrugs.containsKey(drug)) {
        allDrugs.put(drug, 0);
      }
      Integer currentCount = allDrugs.get(drug);
      allDrugs.put(drug, (currentCount + count));
    }
  }
}
