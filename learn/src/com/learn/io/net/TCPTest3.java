package com.learn.io.net;

/**
 * @author windyStreet
 * @codetime 2021-04-10 14:09
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 文件发送
 */
public class TCPTest3 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;

        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8889);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("code.png"));
            byte[] buff = new byte[1024];
            int len;
            while ((len = fis.read(buff)) != -1) {
                os.write(buff, 0, len);
            }

            socket.shutdownOutput(); // 显示的通知服务端 文件传输完毕

            // 接收来自服务端的数据，并显示到控制台

            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            while ((len = is.read(buff)) != -1) {
                baos.write(buff, 0, len);
            }
            System.out.println(baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != fis)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void server() {

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(8889);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("code_net_3.png"));

//        ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len;
            byte[] buff = new byte[1024];
            while ((len = is.read(buff)) != -1) {
                //            baos.write(buff,0,len);
                fos.write(buff, 0, len);
            }
            // 服务器端给客户端反馈
            os = socket.getOutputStream();
            os.write("文件已经收到".getBytes(StandardCharsets.UTF_8));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}
