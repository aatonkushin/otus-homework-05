package org.tonkushin.hw05.service;

import java.util.List;

public interface Service<T> {
    long count();

    T insert(T item);

    T getById(long id);

    List<T> getAll();

    void deleteById(long id);
}
