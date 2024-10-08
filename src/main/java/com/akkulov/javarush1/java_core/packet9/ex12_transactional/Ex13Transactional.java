package com.akkulov.javarush1.java_core.packet9.ex12_transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Ex13Transactional {

  public static final List<String> allLines = new ArrayList<>();
  public static final List<String> forRemoveLines = new ArrayList<>();

  public static void main(String[] args) throws FileNotFoundException {
    File file1 = new File("/Users/omarakkulov/Downloads/papka1.rtf");
    File file2 = new File("/Users/omarakkulov/Downloads/papka2.rtf");

    ToFileDownloader allLinesDownloader = new ToFileDownloader(file1, allLines);
    ToFileDownloader forRemoveLinesDownloader = new ToFileDownloader(file2, forRemoveLines);

    Thread allLinesThread = new Thread(allLinesDownloader);
    Thread forRemoveLinesThread = new Thread(forRemoveLinesDownloader);

    allLinesThread.start();
    forRemoveLinesThread.start();

    try {
      allLinesThread.join();
      forRemoveLinesThread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    try {
      joinData();
    } catch (CorruptedDataException e) {
      System.out.println("Не готово!");
      return;
    }

    System.out.println("Готово!");
  }


  public static void joinData() throws CorruptedDataException {
    synchronized (allLines) {
      synchronized (forRemoveLines) {
        if (allLines.containsAll(forRemoveLines)) {
          for (String elm : forRemoveLines) {
            allLines.remove(elm);
          }
        } else {
          allLines.clear();
          throw new CorruptedDataException();
        }
      }
    }
  }
}
