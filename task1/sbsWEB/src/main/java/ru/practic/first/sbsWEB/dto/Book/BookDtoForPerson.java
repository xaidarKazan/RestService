package ru.practic.first.sbsWEB.dto.Book;

import lombok.Data;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import java.util.Set;

@Data
public class BookDtoForPerson {

    private Long id;
    private String name;
    private AuthorDtoNotBooks author;
    private Set<GenreDtoNoBooks> genre;

}