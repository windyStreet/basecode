package com.learn.string;

import org.junit.Test;

/**
 * @author windyStreet
 * @codetime 2021-03-29 11:08
 */


public class SwapString {

    public String reverse(String str, int startIndex, int endIndex) {
        if (null == str || "".equals(str) || startIndex < 0 || endIndex < 0 || startIndex - endIndex > 0) {
            return null;
        }
        char[] arr = str.toCharArray();
        for (; startIndex < endIndex; startIndex++, endIndex--) {
            char tmp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = tmp;
        }
        return new String(arr);
    }

    public String reverse1(String str, int startIndex, int endIndex) {
        if (null == str || "".equals(str) || startIndex < 0 || endIndex < 0 || startIndex - endIndex > 0) {
            return null;
        }
        String reverseStr = str.substring(0, startIndex);
        for (int i = endIndex; i >= startIndex; i--) {
            reverseStr += str.charAt(i);
        }
        reverseStr += str.substring(endIndex + 1, str.length());
        return reverseStr;
    }


    public String reverse2(String str, int startIndex, int endIndex) {
        if (null == str || "".equals(str) || startIndex < 0 || endIndex < 0 || startIndex - endIndex > 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(str.substring(0, startIndex));
        for (int i = endIndex; i >= startIndex; i--) {
            sb.append(str.charAt(i));
        }
        sb.append(str.substring(endIndex + 1, str.length()));
        return sb.toString();
    }

    @Test
    public void Test() {
        String str = "wersdafsresaaasdfasd";
        String reverseStr = reverse(str, 3, 6);
        System.out.println(reverseStr);
    }

    @Test
    public void Test1() {
        String str = "wersdafsresaaasdfasd";
        String reverseStr = reverse1(str, 3, 6);
        System.out.println(reverseStr);
    }

    @Test
    public void Test2() {
        String str = "1234567890";
        String reverseStr = reverse2(str, 3, 6);
        System.out.println(reverseStr);
    }
}
