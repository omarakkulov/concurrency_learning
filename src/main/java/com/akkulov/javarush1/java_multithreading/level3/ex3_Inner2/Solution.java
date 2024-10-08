package com.akkulov.javarush1.java_multithreading.level3.ex3_Inner2;

public class Solution {

    private String country;
    private String city;

    public Solution(String country, String city) {
        this.country = country;
        this.city = city;
    }

    /*
        Т.к. модификатор внутреннего класса private, то, чтобы вызвать метод getDescription из другого внешнего класса, нужно обернуть его
        вызов в какой-то public метод
     */
    public String getUserDescription(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        // Доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        public SuperUser(String name) {
            this.name = name;
        }

        // Доступ к этому методу возможен только внутри класса Solution, т.к. модификатор иннер класса private
        public String getDescription() {
            Solution solution = Solution.this;

            return String.format("My name is %s. I'm from %s in %s.",
                    this.name,
                    solution.city,
                    solution.country);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution("the United States", "Seattle");
        //внутри класса Solution (а сейчас мы внутри) к методу getDescription можно обращаться обоими способами
        System.out.println(solution.getTrickyUser("George").getDescription());
        //а из любого другого внешнего класса только так:
        System.out.println(solution.getUserDescription("George"));
    }
}
