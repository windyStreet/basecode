package com.interview.stack;

import java.util.Stack;

public class SortStackByStack {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(32);
        s.push(5);
        s.push(12);
        s.push(10);
        s.push(9);

        SortStackByStack.sortStackByStack(s);
        for (Integer i : s) {
            System.out.println(i);
        }
    }




    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}