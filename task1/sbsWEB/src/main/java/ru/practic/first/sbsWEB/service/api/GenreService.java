package ru.practic.first.sbsWEB.service.api;

import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Genre;
import java.util.List;
import java.util.Map;

public interface GenreService {

    List<GenreDtoNoBooks> allGenres();
    GenreDtoNoBooks addGenre(Genre genre);
    Map<String, Long> countBooksInGenre();

}