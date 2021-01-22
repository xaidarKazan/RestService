package ru.practic.first.sbsWEB.repository.Book;

import org.springframework.stereotype.Repository;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;
import ru.practic.first.sbsWEB.service.DateRange;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Book> listBooksWithGenreAndDate(Genre genre, LocalDate dateOfPublication, DateRange dateRange) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = cb.createQuery(Book.class);
        Root<Book> book = criteriaQuery.from(Book.class);

        ArrayList<Predicate> predicates = new ArrayList<>();
        if (genre != null) {
            predicates.add(cb.isMember(genre, book.get("genre")));
        }
        if (dateOfPublication != null ) {
            switch (dateRange) {
                case OVER: predicates.add(cb.greaterThan(book.get("dateOfPublication"), dateOfPublication));
                    break;
                case EQUAL: predicates.add(cb.equal(book.get("dateOfPublication"), dateOfPublication));
                    break;
                case UNDER: predicates.add(cb.lessThan(book.get("dateOfPublication"), dateOfPublication));
                    break;
            }
        }
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        TypedQuery<Book> tq = entityManager.createQuery(criteriaQuery);
        return tq.getResultList();
    }
}