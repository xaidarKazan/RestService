package ru.practic.first.sbsWEB.dto.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practic.first.sbsWEB.dto.Book.BookDtoIdName;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDtoBooksNoAuthorAndGenre {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private List<BookDtoIdName> personBooks;

}