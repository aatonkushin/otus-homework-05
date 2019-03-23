package org.tonkushin.hw05.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import org.tonkushin.hw05.dao.author.AuthorDao;
import org.tonkushin.hw05.dao.book.BookDao;
import org.tonkushin.hw05.dao.genre.GenreDao;
import org.tonkushin.hw05.domain.Author;
import org.tonkushin.hw05.domain.Book;
import org.tonkushin.hw05.domain.Genre;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImplTest {

    @Test
    public void count() {
        BookDao dao = Mockito.mock(BookDao.class);
        AuthorDao authorDao = Mockito.mock(AuthorDao.class);
        GenreDao genreDao = Mockito.mock(GenreDao.class);

        Mockito.when(dao.count()).thenReturn(3);

        BookService service = new BookServiceImpl(dao, authorDao, genreDao);
        Assertions.assertThat(service.count()).isGreaterThan(0);
    }

    @Test
    public void insert() {
        BookDao dao = Mockito.mock(BookDao.class);
        AuthorDao authorDao = Mockito.mock(AuthorDao.class);
        GenreDao genreDao = Mockito.mock(GenreDao.class);

        Book book = getBook();

        Mockito.when(dao.insert(book)).thenReturn(1);

        BookService service = new BookServiceImpl(dao, authorDao, genreDao);
        Assertions.assertThat(service.insert(book)).isEqualTo(book);
    }

    @Test
    public void getById() {
        Book book = getBook();

        BookDao dao = Mockito.mock(BookDao.class);
        AuthorDao authorDao = Mockito.mock(AuthorDao.class);
        GenreDao genreDao = Mockito.mock(GenreDao.class);
        Mockito.when(dao.getById(1)).thenReturn(book);

        BookService service = new BookServiceImpl(dao, authorDao, genreDao);
        Assertions.assertThat(service.getById(1)).isEqualTo(book);
    }

    @Test
    public void getAll() {
        List<Book> Books = new ArrayList<Book>(3);
        for (int i = 1; i <= 3; i++) {
            Book b = getBook();
            b.setId(1);
            Books.add(b);
        }

        BookDao dao = Mockito.mock(BookDao.class);
        AuthorDao authorDao = Mockito.mock(AuthorDao.class);
        GenreDao genreDao = Mockito.mock(GenreDao.class);

        Mockito.when(dao.getAll()).thenReturn(Books);

        BookService service = new BookServiceImpl(dao, authorDao, genreDao);

        Assertions.assertThat(service.getAll().size()).isEqualTo(3);
    }


    private Book getBook() {
        Book book = new Book();
        book.setName("Test Book");
        book.setGenre(new Genre(1, "Test Genre"));
        book.setAuthor(new Author(1, "Test Author"));

        return book;
    }
}
