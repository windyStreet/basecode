package com.interview.stack;

import java.util.Stack;

/**
 【题目】
 给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i]
 小的位置。返回所有位置相应的信息。
 【举例】
 arr = {3,4,1,5,6,2,7}
 第 1 章 栈和队列
 21
 返回如下二维数组作为结果：
 {
 {-1, 2},
 { 0, 2},
 {-1,-1},
 { 2, 5},
 { 3, 5},
 { 2,-1},
 { 5,-1}
 }
 -1 表示不存在。所以上面的结果表示在 arr 中，0 位置左边和右边离 0 位置最近且值比 arr[0]
 小的位置是-1 和 2；1 位置左边和右边离 1 位置最近且值比 arr[1]小的位置是 0 和 2；2 位置左
 边和右边离 2 位置最近且值比 arr[2]小的位置是-1 和-1……
 进阶问题：给定一个可能含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最
 近且值比 arr[i]小的位置。返回所有位置相应的信息。
 【要求】
 如果 arr 长度为 N，实现原问题和进阶问题的解法，时间复杂度都达到 O(N)。
 */

public class NearLessNoRepeat {
    public int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        NearLessNoRepeat nlnr = new NearLessNoRepeat();
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
//        int[] arr = {1,2,3,4,5,6,7};
//        int[] arr = {7,6,5,4,3,2,1};
//                int[] arr ={3,1,3,4,3,5,3,2,2}; # err
//        int[] arr = {2,2,2,2,2,3,3,3,3,1,1,1,1,1};# err
        int[][] res = nlnr.getNearLessNoRepeat(arr);
        for (int[] re : res) {
            for (int y = 0; y < re.length; y = y + 2) {
                System.out.println("{" + re[y] + "," + re[y + 1] + "}");
            }
        }
    }

}