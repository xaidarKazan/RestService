package ru.practic.first.sbsWEB.controller;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practic.first.sbsWEB.dto.Book.BookDtoForPerson;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoBooksNoAuthorAndGenre;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Person;
import ru.practic.first.sbsWEB.service.api.PersonService;
import java.util.List;

@RestController
@RequestMapping(value = "/persons")
@RequiredArgsConstructor
public class PersonsController {

    private final PersonService service;

    @PostMapping(value = "/add")
    public PersonDtoNoBooks addPerson(@RequestBody Person newPerson) { return service.addPerson(newPerson); }

    @PostMapping("/update")
    public PersonDtoNoBooks updatePerson(@RequestBody Person updatePerson) { return service.updatePerson(updatePerson); }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removePersontoId(@PathVariable Long id) {
        if (service.removePerson(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("Person with this id does not exist",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/removeByFIO")
    public ResponseEntity removePersonToFullName(@RequestParam String firstName,
                                                 @RequestParam String lastName,
                                                 @RequestParam String middleName) {
        if (service.removePerson(firstName, lastName, middleName)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("Incorrect parameters. Person not found.",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/personId/{id}")
    public List<BookDtoForPerson> getAllTakenBooks(@PathVariable Long id) { return service.personHaveBooks(id); }

    @PostMapping(value = "person/takeBook")
    public PersonDtoBooksNoAuthorAndGenre takeBook(@RequestParam Long id, @RequestBody Book book) {
        return service.personTakeBook(id, book);
    }

    @PostMapping("person/backBook")
    public PersonDtoBooksNoAuthorAndGenre returnBook(@RequestParam Long idPerson, @RequestParam Long idBook) {
        return service.personBackBook(idPerson, idBook);
    }
}