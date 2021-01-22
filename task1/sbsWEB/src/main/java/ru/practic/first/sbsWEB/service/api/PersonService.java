package ru.practic.first.sbsWEB.service.api;

import ru.practic.first.sbsWEB.dto.Book.BookDtoForPerson;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoBooksNoAuthorAndGenre;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Person;
import java.util.List;

public interface PersonService {

    PersonDtoNoBooks addPerson(Person newPerson);
    PersonDtoNoBooks updatePerson(Person updatePerson);
    boolean removePerson(Long id);
    boolean removePerson(String firstName, String lastName, String middleName);
    List<BookDtoForPerson> personHaveBooks(Long id);
    PersonDtoBooksNoAuthorAndGenre personTakeBook(Long id, Book book);
    PersonDtoBooksNoAuthorAndGenre personBackBook(Long idPerson, Long idBook);

}