package com.interview.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearLess {
    public int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那个
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(
                        stack.peek().size() - 1);
                for (Integer popi : popIs) {
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            // 取位于下面位置的列表中，最晚加入的那个
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(
                    stack.peek().size() - 1);
            for (Integer popi : popIs) {
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NearLess nl = new NearLess();
//        int[] arr ={3,1,3,4,3,5,3,2,2};
//        int[] arr = {1,2,3,4,5,6,7};
//        int[] arr = {7,6,5,4,3,2,1};
        int[] arr = {2,2,2,2,2,3,3,3,3,1,1,1,1,1,2,2,2,0,0,0,0};
        int[][] res = nl.getNearLess(arr);
        for (int[] re : res) {
            for (int y = 0; y < re.length; y = y + 2) {
                System.out.println("{" + re[y] + "," + re[y + 1] + "}");
            }
        }
    }
}
