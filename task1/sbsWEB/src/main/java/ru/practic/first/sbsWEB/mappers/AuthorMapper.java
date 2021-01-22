package ru.practic.first.sbsWEB.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.practic.first.sbsWEB.dto.Author.AuthorDto;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import ru.practic.first.sbsWEB.dto.Book.BookDto;
import ru.practic.first.sbsWEB.dto.Genre.GenreDto;
import ru.practic.first.sbsWEB.entity.Author;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;
import java.util.List;

@Mapper
public interface AuthorMapper {

    List<AuthorDtoNotBooks> toDtoAuthorNoBooks(List<Author> authorList);

    @IterableMapping(qualifiedByName = "mappingWithOutBooks")
    List<AuthorDto> toDtoAuthorLists(List<Author> authorList);

    @Named("mappingWithOutBooks")
    @Mapping(target = "books", ignore = true)
    AuthorDto toDto(Author author);
    AuthorDto toDtoAuthorBooks( Author author);

    @Mapping(target = "authorDto", ignore = true )
    BookDto toDtoBook(Book book);

    @Mapping(target = "books", ignore = true)
    GenreDto toDtoGenre(Genre genre);
}