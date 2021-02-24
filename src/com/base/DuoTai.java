package com.base;


class 毕姥爷 {
    void 讲课() {
        System.out.println("企业管理");
    }

    void 钓鱼() {
        System.out.println("钓鱼");
    }
}

class 毕老师 extends 毕姥爷 {
    void 讲课() {
        System.out.println("JAVA");
    }

    void 看电影() {
        System.out.println("看电影");
    }
}

class DuoTai {
    public static void main(String[] args) {
        毕姥爷 x = new 毕老师();//毕老师对象被提升为了毕姥爷类型。
        x.讲课();
//        x.钓鱼();
        //x.看电影();//错误.
        毕老师 y = (毕老师) x;//将毕姥爷类型强制转换成毕老师类型。
        y.看电影();//在多态中，自始自终都是子类对象在做着类型的变化。
//        y.钓鱼();
    }
}
