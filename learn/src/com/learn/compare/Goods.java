package com.learn.compare;

/**
 * @author windyStreet
 * @codetime 2021-03-29 17:33
 */
public class Goods implements Comparable {

    private String name;
    private double price = 0.00;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else
                return 0;
//            return  Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入对象不一致");
    }

    @Override
    public String toString() {
        return "Goods{name = " + name + ", price=" + price + "}";
    }
}
