package com.learn.io.net;

/**
 * @author windyStreet
 * @codetime 2021-04-10 10:14
 */

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *参考模型
 * osi    应 表 会    传    网    数 物
 * tcp/ip 应          传    网    物理+数据链路
 *        http        TCP   IP      Link
 *        ftp         UDP   IMCP
 *        telenet           ARP
 *        dns
 *
 *
 * 通信要素一 IP + 端口
 * IP 唯一的标识 Internet 上的计算机（通信实体）
 * 在Java 中使用InetAddress 类代表IP
 * 域名： www.baidu.com www.mi.com
 * 本地回路地址：127.0.0.01 localhost
 *
 * 实例化 InetAddress
 * getHostAddress()
 * getHostName()
 *
 *
 * 端口号：正在计算机上运行的进程
 * 要求：不同的进程有不同的端口号
 * 范围：被规定为一个16位的整数 0~65535
 *
 * 端口号与IP地址的组合得出一个网络套接字：Socket
 */


public class NetTest {

    @Test
    public void test(){

        try {
            InetAddress inte1 = InetAddress.getByName("192.168.5.110");
            System.out.println(inte1);
            InetAddress inte2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inte2);
            InetAddress inte3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inte3);
            InetAddress inte4 = InetAddress.getByName("localhost");
            System.out.println(inte4);
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);

            System.out.println("XXXXXXXXXXXXXXXX");
            System.out.println(inte2.getAddress());
            System.out.println(inte2.getHostAddress());
            System.out.println(inte2.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
