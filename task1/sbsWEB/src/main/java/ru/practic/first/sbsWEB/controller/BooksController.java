package ru.practic.first.sbsWEB.controller;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practic.first.sbsWEB.dto.Book.*;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;
import ru.practic.first.sbsWEB.service.DateRange;
import ru.practic.first.sbsWEB.service.api.BookService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService service;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDto addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeBook(@PathVariable Long id) {
        if (service.removeBook(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("this book is taken by a person",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public BookDto updateBook(@RequestBody Book updateBook){
        return service.updateBook(updateBook);
    }

    @GetMapping("/byAuthor")
    public List<BookDtoIdName> getBooksByAuthor(@RequestParam String firstName,
                                                @RequestParam String lastName,
                                                @RequestParam String middleName) {
        return service.getAllBooksByAuthor(firstName, lastName, middleName);
    }

    @GetMapping(value = "/byGenre")
    public List<BookDtoIdNameAuthorGenre> allBooksByGenre(@RequestBody Genre genre){
        return service.getAllBooksByGenre(genre);
    }

    @GetMapping("/findByGenreAndDate")
    public ResponseEntity getBooksByGenreAndDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datePub,
                                                 @RequestParam String range,
                                                 @RequestBody Genre genre) {
        if (datePub != null && range.isEmpty()) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        DateRange dateRange = (range!= null) ? DateRange.valueOf(range) : null;
        List<BookDtoIdNameAuthorDates> result = service.listBooksWithGenreAndDate(genre, datePub, dateRange);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}