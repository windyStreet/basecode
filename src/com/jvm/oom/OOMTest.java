package com.jvm.oom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class OOMTest {
    public static void main(String[] args) {
        System.out.println("啟".hashCode());
        System.out.println("啓".hashCode());
        System.out.println("啟");
        System.out.println("啓");
        HashSet<String> hs = new HashSet<>();
        ArrayList<House> list = new ArrayList<>();
        while (true) {
            Random random = new Random();
            int h = random.nextInt(10);
            double x = random.nextDouble();
            double y = random.nextDouble();
            double z = random.nextDouble();
            list.add(new House(h, new LocationArea(x, y, z)));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class House {
    int height;
    LocationArea la;

    public House(int h, LocationArea la) {
        this.height = h;
        this.la = la;
    }
}

class LocationArea {
    double x;
    double y;
    double z;
    final byte[] b = new byte[1024 * 10];

    public LocationArea(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


}
