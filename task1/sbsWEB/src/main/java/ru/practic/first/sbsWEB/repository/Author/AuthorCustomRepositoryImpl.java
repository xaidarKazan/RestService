package ru.practic.first.sbsWEB.repository.Author;

import org.springframework.stereotype.Repository;
import ru.practic.first.sbsWEB.entity.Author;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorCustomRepositoryImpl implements AuthorCustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> getByParams(String firstName, String lastName, String middleName, LocalDate from, LocalDate to) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQ = cb.createQuery(Author.class);
        Root<Author> author = criteriaQ.from(Author.class);
        ArrayList<Predicate> predicates = new ArrayList<>();
        if (firstName != null && !firstName.isEmpty()) {
            predicates.add(cb.equal(author.get("firstName"), firstName));
        }
        if (lastName != null && !lastName.isEmpty()) {
            predicates.add(cb.equal(author.get("lastName"), lastName));
        }
        if (middleName != null &&!middleName.isEmpty()) {
            predicates.add(cb.equal(author.get("middleName"), middleName));
        }
        if (from != null && to != null) {
            predicates.add(cb.between(author.get("postTime"),from, to));
        }
        else {
            if (from != null) {
                predicates.add(cb.greaterThanOrEqualTo(author.get("postTime"), from));
            }
            if (to != null) {
                predicates.add(cb.lessThanOrEqualTo(author.get("postTime"), to));
            }
        }
        criteriaQ.where(predicates.toArray(new Predicate[predicates.size()]));
        TypedQuery<Author> typedQuery = entityManager.createQuery(criteriaQ);
        return typedQuery.getResultList();
    }
}