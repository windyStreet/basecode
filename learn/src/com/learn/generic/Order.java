package com.learn.generic;

/**
 * @author windyStreet
 * @codetime 2021-04-07 15:06
 */
public class Order<T> {
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {
    }

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public void createTArr(){
        // 编译不通过
//        T[] arr = new T[10];
        // 编译通过
        T[] arr = (T[]) new Object[10];
    }
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
}
