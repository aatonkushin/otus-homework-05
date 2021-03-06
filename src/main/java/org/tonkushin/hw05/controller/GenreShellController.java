package org.tonkushin.hw05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.tonkushin.hw05.domain.Genre;
import org.tonkushin.hw05.service.GenreService;

import java.util.List;

@ShellComponent
public class GenreShellController {
    private final GenreService service;

    @Autowired
    public GenreShellController(GenreService service) {
        this.service = service;
    }

    @ShellMethod(value = "Выводит список всех жанров.", key = {"get-genres", "gg"})
    public String getGenres(){
        List<Genre> items = service.getAll();

        StringBuilder sb = new StringBuilder();
        sb.append("Код\tИмя жанра\n");
        for (Genre item : items) {
            sb.append(item.getId()).append("\t")
                    .append(item.getName()).append("\n");
        }

        return sb.toString();
    }

    @ShellMethod(value = "Добавляет жанр с именем name.", key = {"add-genre", "ag"})
    public String addGenre(String name) {
        service.insert(new Genre(-1, name));
        return "Жанр '"+name+"' добавлен";
    }

    @ShellMethod(value = "Удаляет жанр с указанным кодом.", key={"delete-genre", "dg"})
    public String deleteGenre(long id){
        service.deleteById(id);
        return "Жанр удалён";
    }
}
