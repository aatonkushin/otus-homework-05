package org.tonkushin.hw05.dao.genre;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tonkushin.hw05.domain.Genre;

@RunWith(SpringRunner.class)
@JdbcTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@Import(GenreDaoJdbc.class)
@TestPropertySource("/test.properties")
public class GenreDaoJdbcTest {

    @Autowired
    private GenreDao dao;

    @Test
    @Rollback
    @Transactional
    public void count() {
        dao.insert(new Genre(-1, "Test Genre"));
        Assertions.assertThat(dao.count()).isGreaterThan(0);
    }

    @Test
    @Rollback
    @Transactional
    public void insert() {
        Assertions.assertThat(dao.insert(new Genre(-1, "Test Genre"))).isGreaterThan(0);
    }

    @Test
    @Rollback
    @Transactional
    public void getById() {
        int id = dao.insert(new Genre(-1, "Test Genre"));
        Assertions.assertThat(dao.getById(id).getName()).isEqualTo("Test Genre");
    }

    @Test
    @Rollback
    @Transactional
    public void getAll() {
        dao.insert(new Genre(-1, "Test Genre"));
        Assertions.assertThat(dao.getAll().isEmpty()).isFalse();
    }

    @Test
    @Rollback
    @Transactional
    public void deleteById() {
        int id = dao.insert(new Genre(-1, "Test Genre"));
        dao.deleteById(id);
        Assertions.assertThatExceptionOfType(EmptyResultDataAccessException.class).isThrownBy(() -> {
            dao.getById(id);
        });
    }
}
