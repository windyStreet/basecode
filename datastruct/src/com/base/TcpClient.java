package com.base;

import java.io.OutputStream;
import java.net.Socket;


//需求：客户端给服务器端发送一个数据。
class TcpClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 10002);
        OutputStream out = s.getOutputStream();//获取了socket流中的输出流对象。
        out.write("tcp演示，哥们又来了!".getBytes());
        s.close();
    }
}