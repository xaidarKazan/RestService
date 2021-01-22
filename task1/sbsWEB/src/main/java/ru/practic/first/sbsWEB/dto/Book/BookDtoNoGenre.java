package ru.practic.first.sbsWEB.dto.Book;

import lombok.Data;
import ru.practic.first.sbsWEB.entity.Author;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BookDtoNoGenre implements Serializable {

    private Long id;
    private String name;
    private Author authorDto;
    private LocalDate dateOfPublication;
    private LocalDate dateOfReceiptInLib;

}