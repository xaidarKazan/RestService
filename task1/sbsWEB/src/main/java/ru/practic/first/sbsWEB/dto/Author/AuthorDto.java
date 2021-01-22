package ru.practic.first.sbsWEB.dto.Author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practic.first.sbsWEB.dto.Book.BookDto;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {

    private String firstName;
    private String lastName;
    private String middleName;
    private List<BookDto> books;

}
