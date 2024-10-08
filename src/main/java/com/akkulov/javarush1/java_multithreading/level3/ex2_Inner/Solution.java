package com.akkulov.javarush1.java_multithreading.level3.ex2_Inner;

public class Solution {

    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];

        for (int i = 0; i < 2; i++) {
            Solution newSolution = new Solution();

            solutions[i] = newSolution;
            newSolution.innerClasses[0] = newSolution.new InnerClass();
            newSolution.innerClasses[1] = newSolution.new InnerClass();
        }

        return solutions;
    }

    public static void main(String[] args) {
        var twoSolutions = getTwoSolutions();
        System.out.println();
    }
}
