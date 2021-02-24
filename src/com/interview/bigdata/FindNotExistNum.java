package com.interview.bigdata;

import sun.security.util.BitArray;

import java.io.*;

public class FindNotExistNum {


    public static void main(String[] args) {
        int countArrLen = 64;
//        Integer MAX_VALUE = Integer.valueOf(String.valueOf(Math.pow(2,32))) ;
        long MAX_VALUE = 1L << 32;
        System.out.println("最大值为：" + MAX_VALUE);
        int numIndex = -1;
        Long perNum = MAX_VALUE / countArrLen;
        int[] countArr = new int[countArrLen];
        String s = null;
        int area_index = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("10w.txt")))) {
            while ((s = br.readLine()) != null) {
                numIndex = Integer.parseInt(String.valueOf(Long.parseLong(s) / perNum));
                countArr[numIndex]++;
            }

            for (; area_index < countArr.length; area_index++) {
                if (countArr[area_index] < perNum)
                    break;
            }

        } catch (Exception e) {
            System.out.println("当前错误值为：" + s);
            System.out.println("当前错误：" + e.toString());
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("10w.txt")))) {
            BitArray ba = new BitArray(Integer.parseInt(String.valueOf(perNum)));
            while ((s = br.readLine()) != null) {
                if (s.equals("0")) {
                    System.out.println("111");
                }
                long data = Long.parseLong(String.valueOf(Long.parseLong(s)));
                if (perNum * area_index <= data && data <= perNum * (area_index + 1)) {
                    ba.set(Integer.parseInt(Long.toString(data - (area_index * perNum))), true);
                }
            }
            int int_index = 0;
            for (; int_index < ba.length(); int_index++) {
                if (!ba.get(int_index)) {
                    break;
                }
            }
            System.out.println("不存在的数据有：" + (int_index + area_index * perNum));
        } catch (Exception e) {
            System.out.println("错误值为：" + s);
            System.out.println("当前错误：" + e.toString());
        }

    }
}
