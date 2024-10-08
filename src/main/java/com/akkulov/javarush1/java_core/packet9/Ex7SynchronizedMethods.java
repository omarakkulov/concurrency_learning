package com.akkulov.javarush1.java_core.packet9;

public class Ex7SynchronizedMethods {

  private volatile double param = Math.random();
  private StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {

  }

  private void method0() {
    Double d = method3();
  }

  protected void method1(String param1) {
    Ex7SynchronizedMethods solution = new Ex7SynchronizedMethods();
    solution.method0();
  }

  public void method2(int param1) {
    param1++;
  }

  double method3() {
    double random;
    synchronized (this) {
      random = Math.random();
      param += 40.7;
    }
    return random + param;
  }

  private void method4() {
    synchronized (sb) {
      sb.append(1).append(1).append(1).append(1);
    }
  }

  protected void method5(String param2) {
    new StringBuffer().append(param2).append(param2).append(param2);
  }

  public String method6(int param2) {
    System.out.println("Thinking....");
    method7(5e-2);
    synchronized (sb) {
      sb = new StringBuilder("Got it!.");
    }
    return sb.toString();
  }

  String method7(double param2) {
    return "" + param2;
  }
}
