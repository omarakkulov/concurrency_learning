package com.akkulov.javarush1.java_core.packet7.ex4_synchronized_president;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture04; Синхронизированный президент
 */
public class Ex4SynchronizedPresident {

  public static void main(String[] args) {
    OurPresident expectedPresident = OurPresident.getOurPresident();
    OurPresident ourPresident = OurPresident.getOurPresident();
    System.out.println(expectedPresident == ourPresident);
  }
}
