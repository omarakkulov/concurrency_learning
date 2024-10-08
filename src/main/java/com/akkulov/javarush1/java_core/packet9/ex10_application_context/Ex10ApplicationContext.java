package com.akkulov.javarush1.java_core.packet9.ex10_application_context;

import java.util.HashMap;
import java.util.Map;

public abstract class Ex10ApplicationContext<GenericsBean extends Bean> {

  private Map<String, GenericsBean> container = new HashMap<>();
  // Map<Name, some class that implements the Bean interface>

  protected Ex10ApplicationContext() {
    parseAllClassesAndInterfaces();
  }

  public GenericsBean getByName(String name) {
    synchronized (container) {
      return container.get(name);
    }
  }

  public GenericsBean removeByName(String name) {
    synchronized (container) {
      return container.remove(name);
    }
  }

  protected abstract void parseAllClassesAndInterfaces();

  public static void main(String[] args) {

  }
}
