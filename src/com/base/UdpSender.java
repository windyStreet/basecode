package com.base;

import java.net.*;

class UdpSender {
    public static void main(String[] args) throws Exception {
// 1，建立udp的socket服务。
        DatagramSocket ds = new DatagramSocket(8888);//指定发送端口，不指定系统会随机分配。
// 2，明确要发送的具体数据。
        String text = "udp传输演示 哥们来了";
        byte[] buf = text.getBytes();
// 3，将数据封装成了数据包。
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 10000);
// 4，用socket服务的send方法将数据包发送出去。
        ds.send(dp);
// 5，关闭资源。
        ds.close();
    }
}