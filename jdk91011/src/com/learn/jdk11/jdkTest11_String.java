package com.learn.jdk11;

/**
 * @author windyStreet
 * @codetime 2021-04-21 16:50
 */
public class jdkTest11_String {

    public static void main(String[] args) {
        System.out.println("   ".isBlank());
        System.out.println("********************");
        System.out.println("A---------  \t \n abc \n \t  ".strip() + "-------------D");
        System.out.println("********************");
        System.out.println("A---------  \t \n abc \n \t  ".stripTrailing() + "-------------D");
        System.out.println("********************");
        System.out.println("A---------  \t \n abc \n \t  ".stripLeading() + "-------------D");
        System.out.println("********************");
        System.out.println("abcc".repeat(5));
        System.out.println("********************");

        String str = "aasvsdsdfb";
        System.out.println(str.lines().count());
        System.out.println("********************");
        str = "aasvsdsdfb \t \n ddd \tdddd";
        System.out.println(str.lines().count());
        System.out.println("********************");
        str = "\n\n\n";
        System.out.println(str.lines().count());







    }
}
