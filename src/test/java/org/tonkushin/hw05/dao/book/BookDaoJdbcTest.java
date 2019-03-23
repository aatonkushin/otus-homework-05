package org.tonkushin.hw05.dao.book;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tonkushin.hw05.domain.Author;
import org.tonkushin.hw05.domain.Book;
import org.tonkushin.hw05.domain.Genre;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@JdbcTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@ComponentScan
@TestPropertySource("/test.properties")
public class BookDaoJdbcTest {

    @Autowired
    private BookDao dao;

    @Test
    @Rollback
    @Transactional
    public void count() {
        dao.insert(getBook());
        Assertions.assertThat(dao.count()).isGreaterThan(0);
    }

    @Test
    public void insert() {
        Assertions.assertThat(dao.insert(getBook())).isGreaterThan(0);
    }

    @Test
    public void getById() {
        int id = dao.insert(getBook());
        Assertions.assertThat(dao.getById(id).getName()).isEqualTo("Test Book");
    }

    @Test
    public void getAll() {
        dao.insert(getBook());
        Assertions.assertThat(dao.getAll().isEmpty()).isFalse();
    }

    @Test
    public void deleteById() {
        int id = dao.insert(getBook());
        dao.deleteById(id);
        Assertions.assertThatExceptionOfType(EmptyResultDataAccessException.class).isThrownBy(() -> {
            dao.getById(id);
        });
    }

    private Book getBook(){
        Book book = new Book();
        book.setName("Test Book");
        book.setGenre(new Genre(1, "Test Genre"));
        book.setAuthor(new Author(1, "Test Author"));

        return book;
    }
}
