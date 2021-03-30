package com.learn.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author windyStreet
 * @codetime 2021-03-29 14:10
 * <p>
 * 获取两个字符串中最大相同子串
 */
public class MaxSubStr {


    public String getMaxSubStr(String str1, String str2) {

        if (str1 != null && str2 != null) {
            String maxString = str1.length() >= str2.length() ? str1 : str2;
            String minString = str1.length() < str2.length() ? str1 : str2;
            int minLen = minString.length();
            for (int i = 0; i < minLen; i++) {
                for (int x = 0, y = minLen - i; y <= minLen; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        return subString;
                    }
                }
            }
        }

        return null;
    }


    public String[] getMaxSubStrs(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuilder sb = new StringBuilder();
            String maxString = str1.length() >= str2.length() ? str1 : str2;
            String minString = str1.length() < str2.length() ? str1 : str2;
            int minLen = minString.length();
            for (int i = 0; i < minLen; i++) {
                for (int x = 0, y = minLen - i; y <= minLen; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sb.append(subString + ',');
                    }
                }
                if (sb.length() != 0)
                    break;
            }
            return sb.toString().split(",");
        }
        return null;
    }

    @Test
    public void test() {
        String str1 = "aabbccdd";
        String str2 = "aaccbb";
        System.out.println(getMaxSubStr(str1, str2));
    }

    @Test
    public void test1() {
        String str1 = "aabbccdd";
        String str2 = "aaccbb";
        System.out.println(Arrays.toString(getMaxSubStrs(str1, str2)));
        for (String s : getMaxSubStrs(str1, str2)) {
            System.out.println(s);
        }
    }
}
