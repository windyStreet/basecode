package com.learn.set;

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

    @Override
    public boolean equals(Object o) {
        System.out.println("Goods equals————————");

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (Double.compare(goods.price, price) != 0) return false;
        return name != null ? name.equals(goods.name) : goods.name == null;
    }

//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = name != null ? name.hashCode() : 0;
//        temp = Double.doubleToLongBits(price);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        return result;
//    }
}
