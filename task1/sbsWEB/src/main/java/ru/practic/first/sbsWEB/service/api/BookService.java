package ru.practic.first.sbsWEB.service.api;

import ru.practic.first.sbsWEB.dto.Book.*;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;
import ru.practic.first.sbsWEB.service.DateRange;
import java.time.LocalDate;
import java.util.List;

public interface BookService {

    BookDto addBook(Book book);
    boolean removeBook(Long id);
    BookDto updateBook(Book newBook);
    List<BookDtoIdName> getAllBooksByAuthor(String firstName, String lastName, String middleName);
    List<BookDtoIdNameAuthorGenre> getAllBooksByGenre(Genre genre);
    List<BookDtoIdNameAuthorDates> listBooksWithGenreAndDate (Genre genre, LocalDate dateOfPublication, DateRange range);

}