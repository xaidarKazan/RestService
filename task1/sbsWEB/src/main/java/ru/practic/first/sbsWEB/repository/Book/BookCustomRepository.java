package ru.practic.first.sbsWEB.repository.Book;

import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;
import ru.practic.first.sbsWEB.service.DateRange;
import java.time.LocalDate;
import java.util.List;

public interface BookCustomRepository {

    List<Book> listBooksWithGenreAndDate(Genre genre, LocalDate dateOfPublication, DateRange dateRange);

}
