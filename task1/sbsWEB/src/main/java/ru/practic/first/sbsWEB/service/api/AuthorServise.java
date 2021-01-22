package ru.practic.first.sbsWEB.service.api;

import ru.practic.first.sbsWEB.dto.Author.AuthorDto;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import ru.practic.first.sbsWEB.entity.Author;
import java.time.LocalDate;
import java.util.List;

public interface AuthorServise {

    List<AuthorDto> allAuthors();
    AuthorDto getAuthorBooks(Long id);
    AuthorDto addAuthor(Author newAuthor);
    boolean removeAuthor(Long id);
    List<AuthorDtoNotBooks> getByParams(String firstName, String lastName, String middleName,
                                        LocalDate from, LocalDate to);
}
