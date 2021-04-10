package com.learn.io.net;

/**
 * @author windyStreet
 * @codetime 2021-04-10 13:48
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 实现TCP的网络编程
 */
public class TCPTest {

    @Test
    public void client() {
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            Socket socket = new Socket(inet, 8888);
            os = socket.getOutputStream();
            os.write("你好啊，我是xxxx".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8888);
            socket = ss.accept();
            inputStream = socket.getInputStream();
//        byte[] buff = new byte[20];
//        int len;
//        while (len = (inputStream.read(buff) != -1)) {
//            String str = new String(buff, 0, len);
//            System.out.println(str);
//        }

            baos = new ByteArrayOutputStream();

            int len;
            byte[] buff = new byte[20];
            while ((len = inputStream.read(buff)) != -1) {
                baos.write(buff, 0, len);
            }
            System.out.println(baos.toString());

            String hostAddress = socket.getInetAddress().getHostAddress();
            System.out.println("收到" + hostAddress + "的消息");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != baos)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != inputStream)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != socket)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (null != ss)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
