package ru.practic.first.sbsWEB.dto.Book;

import lombok.Data;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import java.time.LocalDate;
import java.util.Set;

@Data
public class BookDtoIdNameAuthorGenre {

    private Long id;
    private String name;
    private AuthorDtoNotBooks author;
    private LocalDate dateOfPublication;
    private LocalDate dateOfReceiptInLib;
    private Set<GenreDtoNoBooks> genre;

}