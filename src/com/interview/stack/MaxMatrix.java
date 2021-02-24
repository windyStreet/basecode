package com.interview.stack;

/**
 求最大子矩阵的大小
 【题目】
 给定一个整型矩阵 map，其中的值只有 0 和 1 两种，求其中全是 1 的所有矩形区域中，最
 大的矩形区域为 1 的数量。
 例如：
 1 1 1 0
 其中，最大的矩形区域有 3 个 1，所以返回 3。
 再如：
 1 0 1 1 1 1 1 1 1 1 1 0
 其中，最大的矩形区域有 6 个 1，所以返回 6。
 */

import java.util.Stack;

public class MaxMatrix {
    public int maxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }
    public int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[][] map={
                {1,1,0,1},
                {1,1,1,1},
                {1,1,1,0},
                {1,1,1,0},
                {0,1,1,1},
                {0,1,1,1}
        };
        System.out.println(new MaxMatrix().maxRecSize(map));
    }
}
