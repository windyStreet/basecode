package com.learn.io.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author windyStreet
 * @codetime 2021-04-08 9:26
 */
public class FileTest {

    @Test
    public void test() {
        File file = new File("E:\\projects\\basecode\\learn\\src\\com\\learn\\io\\file\\test.f");
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(file.lastModified());
        System.out.println(file.length());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());

        System.out.println(file.getParentFile());
        System.out.println("$$$$$$$$$$$$$$$$$");
        File file1 = file.getParentFile();
        for (String f : file1.list()) {
            System.out.println(f);

        }

        System.out.println("--------------------");
        File[] files = file1.listFiles();
        for (File f : files) {

            System.out.println(f.getAbsoluteFile());
        }

        System.out.println("!!!!!!!!!!!!");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isAbsolute());
        System.out.println(file.getParentFile().isAbsolute());
        System.out.println(file.isHidden());


        System.out.println("000000000000000000000000");
        File file2 = new File("gogo.txt");
        System.out.println(file2.exists());
        System.out.println(file2.isFile());
        System.out.println(file2.isDirectory());
        System.out.println(file2.isAbsolute());
        System.out.println(file2.getParentFile());
        System.out.println(file2.isHidden());

        System.out.println("111111111111111111");
        File file3 = new File("./gogo1/");
        System.out.println(file3.exists());
        System.out.println(file3.isFile());
        System.out.println(file3.isDirectory());
        System.out.println(file3.isAbsolute());
        System.out.println(file3.getParentFile());
        System.out.println(file3.isHidden());


        if (!file2.exists()) {
            try {
                boolean newFile = file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean mk = file3.mkdirs();
        System.out.println(mk);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        file2.deleteOnExit();

        if (file3.exists()) {
            file3.delete(); // 只能删除空目录
        }


    }
}
