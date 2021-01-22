package ru.practic.first.sbsWEB.mappers;

import org.mapstruct.Mapper;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import ru.practic.first.sbsWEB.dto.Book.BookDtoForPerson;
import ru.practic.first.sbsWEB.dto.Book.BookDtoIdName;
import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoBooksNoAuthorAndGenre;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoNoBooks;
import ru.practic.first.sbsWEB.entity.*;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface PersonMapper {

    PersonDtoNoBooks toDtoNoBooks(Person person);
    List<BookDtoForPerson> toDtoBookList(List<Book> books);
    BookDtoForPerson toDto(Book book);
    AuthorDtoNotBooks toDto(Author author);
    GenreDtoNoBooks toDto(Genre genre);

    PersonDtoBooksNoAuthorAndGenre toDto(Person person);

    default List<BookDtoIdName> toDtoListBookDtoIdName(List<LibraryCard> libCard) {
        List<BookDtoIdName> result = new ArrayList<>();
        for (LibraryCard lc : libCard) {
            BookDtoIdName bookDtoIdName = BookDtoIdName.builder()
                                                       .id(lc.getBook().getId())
                                                       .name(lc.getBook().getName())
                                                       .dateOfPublication(lc.getBook().getDateOfPublication())
                                                       .dateOfReceiptInLib(lc.getBook().getDateOfReceiptInLib())
                                                       .build();
            result.add(bookDtoIdName);
        }
        return result;
    }
}