package org.tonkushin.hw05.service;

import java.util.List;

public interface Service<T> {
    int count();

    T insert(T item);

    T getById(int id);

    List<T> getAll();

    void deleteById(int id);
}
