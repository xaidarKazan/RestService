package ru.practic.first.sbsWEB.dto.Book;

import lombok.Data;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import java.time.LocalDate;

@Data
public class BookDtoIdNameAuthorDates {

    private Long id;
    private String name;
    private AuthorDtoNotBooks author;
    private LocalDate dateOfPublication;
    private LocalDate dateOfReceiptInLib;

}