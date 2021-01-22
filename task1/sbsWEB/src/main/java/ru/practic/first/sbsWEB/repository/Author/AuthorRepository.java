package ru.practic.first.sbsWEB.repository.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practic.first.sbsWEB.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>, AuthorCustomRepository {
}
