package ru.practic.first.sbsWEB.controller;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practic.first.sbsWEB.dto.Author.AuthorDto;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import ru.practic.first.sbsWEB.entity.Author;
import ru.practic.first.sbsWEB.service.api.AuthorServise;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AutorsController {

    private final AuthorServise service;

    @GetMapping
    public List<AuthorDto> allAuthors() {
        return service.allAuthors();
    }

    @GetMapping("/books")
    public AuthorDto getAuthorBooks(@RequestParam Long id){
        return service.getAuthorBooks(id);
    }

    @PutMapping("/add")
    public AuthorDto addAuthor(@RequestBody Author newAuthor){
        return service.addAuthor(newAuthor);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeAuthor(@PathVariable Long id) {
        if (service.removeAuthor(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("Author have books ", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getByParams")
    public List<AuthorDtoNotBooks> getByParams(@RequestParam String firstName,
                                         @RequestParam String lastName,
                                         @RequestParam String middleName,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {

        return service.getByParams(firstName, lastName, middleName, from, to);

    }
}