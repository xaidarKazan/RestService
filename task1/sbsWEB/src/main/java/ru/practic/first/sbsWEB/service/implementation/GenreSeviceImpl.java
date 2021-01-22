package ru.practic.first.sbsWEB.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Genre;
import ru.practic.first.sbsWEB.mappers.GenreMapper;
import ru.practic.first.sbsWEB.repository.GenreRepository;
import ru.practic.first.sbsWEB.service.api.GenreService;
import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class GenreSeviceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDtoNoBooks> allGenres() {
        return genreMapper.toDtoListOnlyName(genreRepository.findAll());
    }

    @Override
    @Transactional
    public GenreDtoNoBooks addGenre(Genre genre) {
        return genreMapper.toDtoOnlyName(genreRepository.save(genre));
    }

    @Override
    public Map<String, Long> countBooksInGenre() {
        List<Genre> genres = genreRepository.findAll();
        Map<String, Long> result = new HashMap<>();
        for (Genre genre : genres) {
            result.put(genre.getName(), (long) genre.getBooks().size());
        }
        return result;
    }
}