package com.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class Info {
    public static void main(String[] args) {

        MemoryMXBean mmb = ManagementFactory.getMemoryMXBean();
        MemoryUsage mu = mmb.getHeapMemoryUsage();
        System.out.println("INI HEAP：" + mu.getInit());
        System.out.println("MAX HEAP:" + mu.getMax());
        System.out.println("USE HEAP:" + mu.getUsed());
        System.out.println("Heap Memory Usage:" + mmb.getHeapMemoryUsage());
        System.out.println("None-Heap Memory Usage:" + mmb.getNonHeapMemoryUsage());

        System.out.println("当前堆内存大小 totalMemory:" + (int) Runtime.getRuntime().totalMemory() / 2014 / 1024 + "mb");
        System.out.println("空闲堆内存大小 freeMemory:" + (int) Runtime.getRuntime().freeMemory() / 2014 / 1024 + "mb");
        System.out.println("最大可用堆内存大小 maxMemory:" + (int) Runtime.getRuntime().maxMemory() / 2014 / 1024 + "mb");

    }
}
