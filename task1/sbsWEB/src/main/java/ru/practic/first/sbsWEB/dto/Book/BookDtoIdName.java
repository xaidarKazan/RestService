package ru.practic.first.sbsWEB.dto.Book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDtoIdName {

    private Long id;
    private String name;
    private LocalDate dateOfPublication;
    private LocalDate dateOfReceiptInLib;

}