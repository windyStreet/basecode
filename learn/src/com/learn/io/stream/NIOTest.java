package com.learn.io.stream;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author windyStreet
 * @codetime 2021-04-10 9:51
 */
public class NIOTest {
    @Test
    public void test(){
//        File file1 = new File("FileReaderWriterTest.java");
//        file1.toPath();

        // E:\projects\basecode\learn\src\com\learn\io\FileReaderWriterTest.java
        Path path = Paths.get("FileReaderWriterTest.java");
        System.out.println(path.toString());
        System.out.println(path.startsWith("E:\\projects\\basecode\\learn\\src\\com\\learn\\io\\"));
        System.out.println(path.endsWith(".java"));
        System.out.println(path.isAbsolute());
        System.out.println(path.getParent());
        System.out.println(path.getRoot());
        System.out.println(path.getFileName());
        System.out.println(path.getNameCount());
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toFile());

    }
}
