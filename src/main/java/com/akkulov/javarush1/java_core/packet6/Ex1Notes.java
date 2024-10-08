package com.akkulov.javarush1.java_core.packet6;

import java.util.ArrayList;
import java.util.List;

/**
 * https://javarush.com/quests/lectures/questcore.level07.lecture02; Заметки
 */
public class Ex1Notes {

  public static void main(String[] args) throws InterruptedException {
    long startTime = System.nanoTime();
    NoteThread noteThread1 = new NoteThread();
    noteThread1.start();

    NoteThread noteThread2 = new NoteThread();
    noteThread2.start();

    new NoteThread().start();
    new NoteThread().start();
    new NoteThread().start();
    new NoteThread().start();
    new NoteThread().start();
    new NoteThread().start();
    new NoteThread().start();
    new NoteThread().start();

//    noteThread1.join();
//    noteThread2.join();
//
//    long endTime = (System.nanoTime() - startTime) / 1_000_000;
//
//    System.out.println(endTime);
  }

  public static class Note {

    public static final List<String> notes = new ArrayList<>();

    public static void addNote(String note) {
//      synchronized (notes) {
      notes.add(0, note);
//      }
    }

    public static void removeNote(String threadName) {
//      synchronized (notes) {
      String note = notes.remove(0);
      if (note == null) {
        System.out.println("Другая нить удалила нашу заметку");
      } else if (!note.startsWith(threadName)) {
        System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
      } else {
        System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
      }
//      }
    }
  }

  public static class NoteThread extends Thread {

    @Override
    public void run() {
      try {
        Thread currentThread = Thread.currentThread();

        for (int i = 0; i < 1000; i++) {
          Note.addNote(currentThread.getName() + "-Note" + i);
          Thread.sleep(1);
          Note.removeNote(currentThread.getName());
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
