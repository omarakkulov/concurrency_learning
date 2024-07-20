package com.akkulov.javacore.javarush.packet5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Последовательный вывод файлов
 */
public class Ex13SerialFileOutput {

  public static String firstFileName;
  public static String secondFileName;

  static {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      firstFileName = reader.readLine();
      secondFileName = reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    systemOutPrintln(firstFileName);
    systemOutPrintln(secondFileName);
  }

  public static void systemOutPrintln(String fileName) throws InterruptedException {
    ReadFileInterface f = new ReadFileThread();
    f.setFileName(fileName);
    f.start();
    f.join();
    System.out.println(f.getFileContent());
  }

  public interface ReadFileInterface {

    void setFileName(String fullFileName);

    String getFileContent();

    void join() throws InterruptedException;

    void start();
  }

  public static class ReadFileThread extends Thread implements ReadFileInterface {

    private String fileName;
    private final StringBuilder fileContentSb = new StringBuilder();

    @Override
    public void run() {
      try (BufferedReader bfrd = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = bfrd.readLine()) != null) {
          fileContentSb.append(line).append(" ");
        }
      } catch (IOException e) {
        this.fileName = null;
      }
    }

    @Override
    public void setFileName(String fullFileName) {
      this.fileName = fullFileName;
    }

    @Override
    public String getFileContent() {
      return fileContentSb.toString();
    }
  }
}
