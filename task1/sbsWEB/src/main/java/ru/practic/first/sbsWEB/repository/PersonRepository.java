package ru.practic.first.sbsWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practic.first.sbsWEB.entity.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long> {

    void deleteAllByFirstNameAndLastNameAndMiddleName(String firstName, String lastName, String middleName);

}