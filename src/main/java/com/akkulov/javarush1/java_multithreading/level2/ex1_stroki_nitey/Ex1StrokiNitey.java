package com.akkulov.javarush1.java_multithreading.level2.ex1_stroki_nitey;

/**
 * https://javarush.com/quests/lectures/questmultithreading.level02.lecture05; Строки нитей или
 * строковые нити? Вот в чем вопрос
 */
public class Ex1StrokiNitey {

  public static void main(String[] args) {
    new Ex1StrokiNitey();
  }

  public static final String FIRST_THREAD_NAME = "1#";
  public static final String SECOND_THREAD_NAME = "2#";

  private Thread thread1;
  private Thread thread2;
  private Thread thread3;

  public Ex1StrokiNitey() {
    initThreads();
  }

  protected void initThreads() {
    this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
    this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"),
        SECOND_THREAD_NAME);
    this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

    Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

    this.thread1.start();
    this.thread2.start();
    this.thread3.start();
  }

  public synchronized String getPartOfString(String string, String threadName) {
    try {
      return string.substring(string.indexOf('\t') + 1, string.lastIndexOf('\t'));
    } catch (Throwable e) {
      if (FIRST_THREAD_NAME.equals(threadName)) {
        throw new StringForFirstThreadTooShortException(e);
      } else if (SECOND_THREAD_NAME.equals(threadName)) {
        throw new StringForSecondThreadTooShortException(e);
      } else {
        throw new RuntimeException(e);
      }
    }
  }
}
