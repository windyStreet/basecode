package com.interview.stack;

import java.util.LinkedList;

public class MaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxWindow mw = new MaxWindow();
        int[] arr = {4, 3, 5, 4,3, 3, 3, 6, 7};
        int[] res = mw.getMaxWindow(arr, 3);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
