package ru.practic.first.sbsWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practic.first.sbsWEB.entity.LibraryCard;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Long> {
}