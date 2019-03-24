package org.tonkushin.hw05.dao;

import java.util.List;

public interface Dao<T> {
    long count();

    long insert(T item);

    T getById(long id);

    List<T> getAll();

    void deleteById(long id);
}
