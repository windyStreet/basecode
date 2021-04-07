package com.learn.generic.demo;

import java.util.HashMap;
import java.util.List;

/**
 * @author windyStreet
 * @codetime 2021-04-07 18:09
 */
public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.setMap(new HashMap<>());
        dao.save("1002",new User("1002","小黄",15));
        dao.save("1003",new User("1003","小蓝",26));
        dao.save("1004",new User("1004","小红",6));
        dao.save("1005",new User("1005","小绿",11));
        dao.save("1006",new User("1006","小紫",18));

        dao.update("1005",new User("1005","小白",1));
        dao.delete("1002");
        List<User> list = dao.list();

        list.forEach(System.out::println);
    }
}
