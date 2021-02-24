package com.base;

class HalfSearch {
    public static int halfSearch_2(int[] arr, int key) {
        int min, max, mid;
        min = 0;
        max = arr.length - 1;
        mid = (max + min) >> 1; //(max+min)/2;
        while (arr[mid] != key) {
            if (key > arr[mid]) {
                min = mid + 1;
            } else if (key < arr[mid])
                max = mid - 1;
            if (max < min)
                return -1;
            mid = (max + min) >> 1;
        }
        return mid;
    }
}

public class HalfSearch_2 {
    public static void main(String[] args) {
        int[] x_arr = {12, 32, 35, 45, 67, 87, 344, 566, 733, 1234, 6333, 7011, 7021, 56665, 66666};
        int x = HalfSearch.halfSearch_2(x_arr, 344);
        System.out.println(x);
    }
}
