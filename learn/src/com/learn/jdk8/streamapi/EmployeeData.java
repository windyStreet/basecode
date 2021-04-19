package com.learn.jdk8.streamapi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windyStreet
 * @codetime 2021-04-19 10:02
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "小黄", 27, 12222.36));
        list.add(new Employee(1002, "小蓝", 27, 12366.36));
        list.add(new Employee(1003, "大壮", 37, 36222.36));
        list.add(new Employee(1004, "小张", 62, 62122.36));
        list.add(new Employee(1005, "abc", 36, 18222.36));
        list.add(new Employee(1006, "小王", 24, 7222.36));
        list.add(new Employee(1007, "小李", 19, 4222.36));
        list.add(new Employee(1008, "小钱", 23, 5222.36));
        list.add(new Employee(1009, "小天", 23, 5228.36));
        return list;
    }
}
