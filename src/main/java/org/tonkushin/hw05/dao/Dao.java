package org.tonkushin.hw05.dao;

import java.util.List;

public interface Dao<T> {
    int count();

    int insert(T item);

    T getById(int id);

    List<T> getAll();

    void deleteById(int id);
}
