package org.tonkushin.hw05.dao.author;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tonkushin.hw05.domain.Author;

@RunWith(SpringRunner.class)
@JdbcTest
@Import(AuthorDaoJdbc.class)
@TestPropertySource("/test.properties")
public class AuthorDaoJdbcTest {

    @Autowired
    private AuthorDao dao;

    @Test
    public void count() {
        dao.insert(new Author(-1L, "Test Author"));
        Assertions.assertThat(dao.count()).isGreaterThan(0);
    }

    @Test
    public void insert() {

        Assertions.assertThat(dao.insert(new Author(-1L, "Test Author"))).isGreaterThan(0);
    }

    @Test
    public void getById() {
        long id = dao.insert(new Author("Test Author"));
        Assertions.assertThat(dao.getById(id).getName()).isEqualTo("Test Author");
    }

    @Test
    public void getAll() {
        dao.insert(new Author("Test Author"));
        Assertions.assertThat(dao.getAll().isEmpty()).isFalse();
    }

    @Test
    public void deleteById() {
        long id = dao.insert(new Author( "Test Author"));
        dao.deleteById(id);
        Assertions.assertThatExceptionOfType(EmptyResultDataAccessException.class).isThrownBy(() -> {
            dao.getById(id);
        });
    }
}
