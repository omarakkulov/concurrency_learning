package com.akkulov.javarush1.java_core.packet9.ex12_transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ToFileDownloader implements Runnable {

  private final Scanner scanner;
  private final List<String> lines;

  public ToFileDownloader(File file, List<String> lines) {
    try {
      this.scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    this.lines = lines;
  }

  @Override
  public void run() {
    synchronized (this.lines) {
      while (scanner.hasNextLine()) {
        this.lines.add(scanner.nextLine());
      }
    }
  }
}
