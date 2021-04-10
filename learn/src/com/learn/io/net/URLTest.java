package com.learn.io.net;

/**
 * @author windyStreet
 * @codetime 2021-04-10 15:27
 */

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL 统一资源定位符，对相应互联网的某一资源地址
 */
public class URLTest {

    @Test
    public void test() {

        try {
            URL url = new URL("http://localhost:8888/exapmles/inex.html?aa=11");
            System.out.println(url.getProtocol()); //获取协议名称
            System.out.println(url.getHost());// 获取主机号
            System.out.println(url.getPort()); // 获取端口号
            System.out.println(url.getPath()); // 获取URL的文件路径
            System.out.println(url.getFile()); // 获取URL的文件名
            System.out.println(url.getQuery()); // 获取URL 查询名
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test1() {

        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://pics5.baidu.com/feed/c8ea15ce36d3d539b493d38627fcbb58342ab048.jpeg?token=28e6d6815f8780f90f82ed9eeccf9416");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            String file = "c8ea15ce36d3d539b493d38627fcbb58342ab048.png";

            fos = new FileOutputStream(new File("./" + file));
            byte[] buff = new byte[1024];
            int len;
            while ((len = is.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
