package com.learn.string;

import org.junit.Test;

/**
 * @author windyStreet
 * @codetime 2021-03-29 11:43
 */
public class RepeatStr {
    public int getCount(String mainStr, String subStr) {
        if (null == mainStr || null == subStr) {
            return 0;
        }
        int mainLen = mainStr.length();
        int subLen = subStr.length();
        int count = 0;
        char[] mainChar = mainStr.toCharArray();
        char[] subChar = mainStr.toCharArray();
        for (int i = 0; i <= mainLen - subLen; i++) {
            int k = i;
            for (int j = 0; j < subLen; ) {
                if (mainChar[k++] == subChar[j]) {
                    j++;
                } else {
                    break;
                }
                if (j == subLen) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getCount1(String mainStr, String subStr) {
        if (null == mainStr || null == subStr) {
            return 0;
        }
        int index = 0;
        int count = 0;
        int subLen = subStr.length();
        while (mainStr.indexOf(mainStr, index) != -1) {
            count++;
            index += subLen;
        }
        return count;
    }

    @Test
    public void test() {
        String m = "asdfgeweasdfaaafawe";
        String s = "aa";
        System.out.println(getCount(m, s));


    }
    @Test
    public void test1() {
        String m = "asdfgeweasdfaaafawe";
        String s = "aa";
        System.out.println(getCount1(m, s));

    }
}
