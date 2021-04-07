package com.learn.generic.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author windyStreet
 * @codetime 2021-04-07 17:53
 */
public class DAO<T> {
    private Map<String, T> map;


    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {

        T t = map.get(id);
        return t;
    }

    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }
    }

    public List<T> list() {

        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t : values) {
            list.add(t);
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }


    public void setMap(Map<String, T> map) {
        this.map = map;
    }
}
