package org.tonkushin.hw05.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.tonkushin.hw05.dao.genre.GenreDao;
import org.tonkushin.hw05.domain.Genre;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@TestPropertySource("/test.properties")
public class GenreServiceImplTest {

    @Test
    public void count() {
        GenreDao dao = Mockito.mock(GenreDao.class);
        Mockito.when(dao.count()).thenReturn(3);

        GenreService service = new GenreServiceImpl(dao);
        Assertions.assertThat(service.count()).isGreaterThan(0);
    }

    @Test
    public void insert() {
        Genre genre = new Genre(1, "Test Genre");

        GenreDao dao = Mockito.mock(GenreDao.class);
        Mockito.when(dao.insert(genre)).thenReturn(1);

        GenreService service = new GenreServiceImpl(dao);
        Assertions.assertThat(service.insert(genre)).isEqualTo(genre);
    }

    @Test
    public void getById() {
        Genre genre = new Genre(1, "Test Genre");

        GenreDao dao = Mockito.mock(GenreDao.class);
        Mockito.when(dao.getById(1)).thenReturn(genre);

        GenreService service = new GenreServiceImpl(dao);
        Assertions.assertThat(service.getById(1)).isEqualTo(genre);
    }

    @Test
    public void getAll() {
        List<Genre> Genres = new ArrayList<Genre>(3);
        for (int i=1; i<=3; i++){
            Genres.add(new Genre(1, "Test Genre"));
        }

        GenreDao dao = Mockito.mock(GenreDao.class);
        Mockito.when(dao.getAll()).thenReturn(Genres);

        GenreService service = new GenreServiceImpl(dao);

        Assertions.assertThat(service.getAll().size()).isEqualTo(3);
    }
}
