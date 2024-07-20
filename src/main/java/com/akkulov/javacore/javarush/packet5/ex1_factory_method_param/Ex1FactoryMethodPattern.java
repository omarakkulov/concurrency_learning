package com.akkulov.javacore.javarush.packet5.ex1_factory_method_param;

/**
 * https://javarush.com/quests/lectures/questcore.level06.lecture13; Factory method pattern
 */
public class Ex1FactoryMethodPattern {

  public static void main(String[] args) {
    ImageReader reader = ImageReaderFactory.getImageReader(ImageType.JPG);
    System.out.println(reader);
  }
}
