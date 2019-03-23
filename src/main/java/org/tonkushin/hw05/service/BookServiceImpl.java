package org.tonkushin.hw05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonkushin.hw05.dao.author.AuthorDao;
import org.tonkushin.hw05.dao.book.BookDao;
import org.tonkushin.hw05.dao.genre.GenreDao;
import org.tonkushin.hw05.domain.Author;
import org.tonkushin.hw05.domain.Book;
import org.tonkushin.hw05.domain.Genre;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao dao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;

    @Autowired
    public BookServiceImpl(BookDao dao, AuthorDao authorDao, GenreDao genreDao) {
        this.dao = dao;
        this.authorDao = authorDao;
        this.genreDao = genreDao;
    }

    @Override
    public long count() {
        return dao.count();
    }

    @Override
    public Book insert(Book item) {
        long id = dao.insert(item);
        item.setId(id);

        return item;
    }

    @Override
    public Book getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return dao.getAll();
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }

    @Override
    public void insert(String name, long authorId, long genreId) {
        Author author = authorDao.getById(authorId);
        Genre genre = genreDao.getById(authorId);
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);

        insert(book);
    }
}
