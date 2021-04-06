package com.learn.coll.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author windyStreet
 * @codetime 2021-04-06 18:03
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties pro  = new Properties();
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("E:\\projects\\basecode\\learn\\src\\com\\learn\\coll\\map\\jdbc.properties");
            pro.load(fi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(pro.getProperty("user"));
        System.out.println(pro.getProperty("host"));
        System.out.println(pro.getProperty("name"));
    }
}
