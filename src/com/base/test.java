package com.base;

public class test {
        public static void main(String[] args) {
            System.out.println(Tools.addGoodMorningBefore("Tom"));
        }

        abstract static class Tools {
            public static String addGoodMorningBefore(String name) {
                return String.format("Good Morning ,%s", name);
            }
            abstract void process();
        }
}
