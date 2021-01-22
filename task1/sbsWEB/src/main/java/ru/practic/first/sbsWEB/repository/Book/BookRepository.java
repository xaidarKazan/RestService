package ru.practic.first.sbsWEB.repository.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, BookCustomRepository {

    List<Book> findBookByGenre(Genre genre);

}