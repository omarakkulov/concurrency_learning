package com.akkulov.javarush1.java_core.packet7;


import java.util.ArrayList;
import java.util.List;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture04; Синхронизированные заметки 2
 */
public class Ex2SyncNotes2 {

  public static void main(String[] args) {

  }

  public static class Note {

    public final List<String> notes = new ArrayList<>();

    public synchronized void addNote(int index, String note) {
      System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
      notes.add(index, note);
      System.out.println("Уже добавлена заметка [" + note + "]");
    }

    public synchronized void removeNote(int index) {
      System.out.println("Сейчас будет удалена заметка с позиции " + index);
      String note = notes.remove(index);
      System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
    }
  }
}
