package ru.practic.first.sbsWEB.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practic.first.sbsWEB.dto.Book.BookDtoForPerson;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoBooksNoAuthorAndGenre;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.LibraryCard;
import ru.practic.first.sbsWEB.entity.Person;
import ru.practic.first.sbsWEB.mappers.PersonMapper;
import ru.practic.first.sbsWEB.repository.PersonRepository;
import ru.practic.first.sbsWEB.service.api.PersonService;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    @Transactional
    public PersonDtoNoBooks addPerson(Person newPerson) {
        Person person = personRepository.save(newPerson);
        return personMapper.toDtoNoBooks(person);
    }

    @Override
    @Transactional
    public PersonDtoNoBooks updatePerson(Person updatePerson) {
        Person person = personRepository.save(updatePerson);
        return personMapper.toDtoNoBooks(person);
    }

    @Override
    @Transactional
    public boolean removePerson(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean removePerson(String firstName, String lastName, String middleName) {
        try {
            personRepository.deleteAllByFirstNameAndLastNameAndMiddleName(firstName, lastName, middleName);
        }
        catch (EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public List<BookDtoForPerson> personHaveBooks(Long id) {
        Person person = personRepository.getOne(id);
        List<Book> booksList = new ArrayList<>();
        for (LibraryCard libCard : person.getPersonBooks()) {
            booksList.add(libCard.getBook());
        }
        List<BookDtoForPerson> booksListDto = personMapper.toDtoBookList(booksList);
        return booksListDto;
    }

    @Override
    @Transactional
    public PersonDtoBooksNoAuthorAndGenre personTakeBook(Long id, Book book) {
        Person person = personRepository.getOne(id);
        LibraryCard lc = LibraryCard.builder()
                                    .book(book)
                                    .person(person)
                                    .whenTake(LocalDate.now())
                                    .build();
        person.getPersonBooks().add(lc);
        return personMapper.toDto(personRepository.save(person));
    }

    @Override
    @Transactional
    public PersonDtoBooksNoAuthorAndGenre personBackBook(Long idPerson, Long idBook) {
        Person person = personRepository.getOne(idPerson);
        for (LibraryCard libCard : person.getPersonBooks()) {
            if (libCard.getBook().getId().equals(idBook)) {
                libCard.setWhenreturn(LocalDate.now());
                libCard.setBook(null);
                libCard.setPerson(null);

            }
        }
        person.getPersonBooks().removeIf(libraryCard -> (libraryCard.getBook() == null) &&(
                                                         libraryCard.getPerson() == null));
        person = personRepository.save(person);
        return personMapper.toDto(person);
    }
}