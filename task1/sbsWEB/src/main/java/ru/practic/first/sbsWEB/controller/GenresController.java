package ru.practic.first.sbsWEB.controller;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Genre;
import ru.practic.first.sbsWEB.service.api.GenreService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenresController {

    private final GenreService service;

    @GetMapping
    List<GenreDtoNoBooks> allGenres(){
        return service.allGenres();
    }

    @PutMapping("add")
    GenreDtoNoBooks addGenre(@RequestBody Genre genre){
        return service.addGenre(genre);
    }

    @GetMapping("/count")
    Map<String, Long> countBooksInGenre(){
        return service.countBooksInGenre();
    }
}