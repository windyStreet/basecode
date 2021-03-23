package com.base;

// 懒汉式 延迟加载
class Single2 {
    private Single2() {
    } //构造函数私有化

    private static Single2 s = null;

    public static Single2 getInstance() {
        if (s == null) {
            s = new Single2();
            System.out.format("the construction address is %s",s.toString());
            System.out.println();
        }
        return s;
    }

}

class clazz{

}

class Start{
    public static void main (String[] args){
        Single2 single2 = Single2.getInstance();
        System.out.println(single2);
        Single2 single3 = Single2.getInstance();
        System.out.println(single3);
        clazz clz1 = new clazz();
        System.out.println(clz1);
        clazz clz2 = new clazz();
        System.out.println(clz2);
    }

}
