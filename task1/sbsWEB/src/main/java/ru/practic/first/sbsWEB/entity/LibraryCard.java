package ru.practic.first.sbsWEB.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "library_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibraryCard {

    @Id
    @Column(name = "library_card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "person_person_id")
    private Person person;

    @Column(name = "when_take")
    private LocalDate whenTake;

    @Column(name = "when_return")
    private LocalDate whenreturn;
}