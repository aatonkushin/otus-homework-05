package org.tonkushin.hw05.service;

import org.tonkushin.hw05.domain.Book;

public interface BookService extends Service<Book> {
    /**
     * Добавляет книгу в БД
     * @param name название книги
     * @param authorId код автора
     * @param genreId код жанра
     */
    void insert(String name, long authorId, long genreId);
}
