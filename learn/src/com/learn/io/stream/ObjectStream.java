package com.learn.io.stream;

/**
 * @author windyStreet
 * @codetime 2021-04-09 15:53
 */

import org.junit.Test;

import java.io.*;

/**
 * 对象流
 * ObjectInputStream
 * ObjectOutputStream
 * 用于存储和读取基本数据类型数据或对象的处理流
 * 序列化：用 ObjectOutputStream 类保存基本类型数据或对象的机制
 * 反序列化：用 ObjectOutputStream 类读取基本类型数据或对象的机制
 * 不能序列化 static 和 transient 修饰的成员变量
 *
 * Person类需要满足如下要求
 * 1、实现接口 Serializable
 * 2、提供一个全局常量 serialVersionUID
 * 3、好必须保证其颞部所有属性也必须可以序列化(基本数据类型都是可以序列化的)
 */
public class ObjectStream {

    /**
     * 序列化过程：
     * 将内存中的java对象保存到磁盘中或者通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("ObjectStream.txt"));
            oos.writeObject(new String("这是什么玩意？"));
            Person p = new Person("小李", 12,1,new Account(5000.00));
            oos.writeObject(p);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("ObjectStream.txt"));
            String s = (String) ois.readObject();
            System.out.println(s);
            Person p = (Person) ois.readObject();
            System.out.println(p.getName());
            System.out.println(p.toString());
            System.out.println(p.getAcc().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
