package com.learn.reflect;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author windyStreet
 * @codetime 2021-04-12 14:53
 */
public class ClassLoaderTest {

    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // 加载位置相对于src
//        FileInputStream is = new FileInputStream(new File("src/jdbc.properties"));
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("password"));


    }
}
