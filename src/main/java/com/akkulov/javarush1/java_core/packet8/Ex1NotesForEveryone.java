package com.akkulov.javarush1.java_core.packet8;

import java.util.ArrayList;
import java.util.List;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture06; Заметки для всех
 */
public class Ex1NotesForEveryone {

  public static void main(String[] args) {

  }

  public static class Note {

    public volatile List<String> notes = new ArrayList<String>();

    public void addNote(int index, String note) {
      System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
      notes.add(index, note);
      System.out.println("Уже добавлена заметка [" + note + "]");
    }

    public void removeNote(int index) {
      System.out.println("Сейчас будет удалена заметка с позиции " + index);
      String note = notes.remove(index);
      System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
    }
  }
}
