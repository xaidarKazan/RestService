package ru.practic.first.sbsWEB.repository.Author;

import ru.practic.first.sbsWEB.entity.Author;
import java.time.LocalDate;
import java.util.List;

public interface AuthorCustomRepository {

    List<Author> getByParams(String firstName, String lastName, String middleName,
                             LocalDate from, LocalDate to);

}
