package ru.practic.first.sbsWEB.dto.Genre;

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
public class GenreDto {

    private Long id;
    private String name;
    private List<BookDto> books;

}
