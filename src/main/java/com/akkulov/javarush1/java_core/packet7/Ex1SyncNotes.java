package com.akkulov.javarush1.java_core.packet7;


import java.util.ArrayList;
import java.util.List;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture04; Синхронизированные заметки
 */
public class Ex1SyncNotes {

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      Note note = new Note();

      note.addNote("Note1");
    });
    thread.start();

    Thread thread2 = new Thread(() -> {
      Note note = new Note();

      note.addNote("Note1");
    });
    thread2.start();

    thread.join();
    thread2.join();

    System.out.println("anime");
  }

  public static class Note {

    public final List<String> notes = new ArrayList<>();

    public void addNote(int index, String note) {
      System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
      synchronized (notes) {
        notes.add(index, note);
        System.out.println("Уже добавлена заметка [" + note + "]");
      }
    }

    public void addNote(String note) {
      System.out.println("Сейчас будет добавлена заметка [" + note + "] в конец");
      synchronized (notes) {
        notes.add(note);
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("Уже добавлена заметка [" + note + "]");
      }
    }

    public void removeNote(int index) {
      System.out.println("Сейчас будет удалена заметка с позиции " + index);
      String note;
      synchronized (notes) {
        note = notes.remove(index);
      }
      System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
    }
  }

}
