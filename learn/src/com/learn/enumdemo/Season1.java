package com.learn.enumdemo;

/**
 * @author windyStreet
 * @codetime 2021-03-30 15:03
 * <p>
 * <p>
 * 1、values() 返回枚举类型的对象数组， 遍历所有的枚举值
 * 2、valueOf(String key) 返回key对应的枚举类对象，要求字符串必须是枚举类对象
 * 3、toString() 默认返回去当前枚举类对象常量的名称
 * <p>
 * 使用enum 关键字，定义的枚举类实现接口的情况
 * 1、实现接口
 * 2、枚举类的对象分别实现接口中的抽象方法
 */
interface  info{
    void show();
}
enum Season1 implements info {
    // 申明Season对象的属性
    SPRING("spring", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("summer", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");

        }
    },
    AUTUMN("autumn", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");

        }
    },
    WINTER("winter", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    private final String seasonName;
    private final String seasonDesc;
/**/
    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

//    @Override
//    public void show() {
//        System.out.println("四季如歌");
//    }

    //    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
//    public void show() {
//        System.out.println("四季如歌");
//    }
}