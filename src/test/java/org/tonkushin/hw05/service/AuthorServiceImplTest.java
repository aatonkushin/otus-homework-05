package org.tonkushin.hw05.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.tonkushin.hw05.dao.author.AuthorDao;
import org.tonkushin.hw05.domain.Author;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
public class AuthorServiceImplTest {

    @Test
    public void count() {
        AuthorDao dao = Mockito.mock(AuthorDao.class);
        Mockito.when(dao.count()).thenReturn(3);

        AuthorService service = new AuthorServiceImpl(dao);
        Assertions.assertThat(service.count()).isGreaterThan(0);
    }

    @Test
    public void insert() {
        Author author = new Author(1, "Test Author");

        AuthorDao dao = Mockito.mock(AuthorDao.class);
        Mockito.when(dao.insert(author)).thenReturn(1);

        AuthorService service = new AuthorServiceImpl(dao);
        Assertions.assertThat(service.insert(author)).isEqualTo(author);
    }

    @Test
    public void getById() {
        Author author = new Author(1, "Test Author");

        AuthorDao dao = Mockito.mock(AuthorDao.class);
        Mockito.when(dao.getById(1)).thenReturn(author);

        AuthorService service = new AuthorServiceImpl(dao);
        Assertions.assertThat(service.getById(1)).isEqualTo(author);
    }

    @Test
    public void getAll() {
        List<Author> authors = new ArrayList<Author>(3);
        for (int i=1; i<=3; i++){
            authors.add(new Author(1, "Test Author"));
        }

        AuthorDao dao = Mockito.mock(AuthorDao.class);
        Mockito.when(dao.getAll()).thenReturn(authors);

        AuthorService service = new AuthorServiceImpl(dao);

        Assertions.assertThat(service.getAll().size()).isEqualTo(3);
    }
}
