package com.file;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class RandomNumFile {

    public void createFile(String fileName, Long[] data) {
        try {

            Path path = Paths.get(String.valueOf(fileName));

            // 使用newBufferedWriter创建文件并写文件
            // 这里使用了try-with-resources方法来关闭流，不用手动关闭
            StringBuffer sb = new StringBuffer();
            for (Long num : data) {
                sb.append(num);
                sb.append("\r\n");
            }
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                writer.write(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Long[] randomNum(int count) {
        Long[] arr = new Long[count];
        Random r = new Random();
        for (int i = 0; i < count; i++) {
//            arr[i] = (int) (Math.random() * (max - min) + min);
//            arr[i] = r.nextLong(); /*long 会将32位钱使用掉，导致首尾为1，变成负数*/
            arr[i] = (long) r.nextInt() + (1L << 31);
        }
        return arr;
    }

    public static void main(String[] args) {
        RandomNumFile rnf = new RandomNumFile();
        int count = 10000;
        int total = 10000 * 10000;

        for (int i = 0; i < total / count; i++) {
            rnf.createFile("1e.txt", rnf.randomNum(10000));
            System.out.println("create num " + count * (i + 1));
        }
//        for (int i = 0; i <1000 ;i++) {
//            rnf.randomNum(10);
//        }
    }
}
