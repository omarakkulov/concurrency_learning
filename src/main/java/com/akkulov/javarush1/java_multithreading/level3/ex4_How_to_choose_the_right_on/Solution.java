package com.akkulov.javarush1.java_multithreading.level3.ex4_How_to_choose_the_right_on;

/**
 * Как выбрать нужное?
 */
public class Solution {
    public static final String TEST = "test";
    static Object obj;

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }

    }

    public static void main(String[] args) {
        obj = new Solution.TEST();
        System.out.println(obj);
    }
}
