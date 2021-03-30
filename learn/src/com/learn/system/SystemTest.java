package com.learn.system;

import org.junit.Test;

/**
 * @author windyStreet
 * @codetime 2021-03-30 9:56
 */
public class SystemTest {

    @Test
    public void test() {
        String java_version = System.getProperty("java.version");
        String java_home = System.getProperty("java.home");
        String os_name = System.getProperty("os.name");
        String os_version = System.getProperty("os.version");
        String user_name = System.getProperty("user.name");
        String user_home = System.getProperty("user.home");
        String user_dir = System.getProperty("user.dir");
        System.out.println(java_version);
        System.out.println(java_home);
        System.out.println(os_name);
        System.out.println(os_version);
        System.out.println(user_name);
        System.out.println(user_home);
        System.out.println(user_dir);
    }
}
