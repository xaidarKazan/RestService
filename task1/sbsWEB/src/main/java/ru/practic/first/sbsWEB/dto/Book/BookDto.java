package ru.practic.first.sbsWEB.dto.Book;

import lombok.Data;
import ru.practic.first.sbsWEB.dto.Author.AuthorDto;
import ru.practic.first.sbsWEB.dto.Genre.GenreDto;
import java.time.LocalDate;
import java.util.Set;

@Data
public class BookDto {

    private Long id;
    private String name;
    private AuthorDto authorDto;
    private LocalDate dateOfPublication;
    private LocalDate dateOfReceiptInLib;
    private Set<GenreDto> genre;

}