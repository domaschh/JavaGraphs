package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("something");
        greaterNumber(1, 2);
    }

    public static int greaterNumber(int num1, int num2) {
        return Math.max(num1, num2);
    }
}