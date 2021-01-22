package ru.practic.first.sbsWEB.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practic.first.sbsWEB.dto.Author.AuthorDto;
import ru.practic.first.sbsWEB.dto.Book.*;
import ru.practic.first.sbsWEB.dto.Genre.GenreDto;
import ru.practic.first.sbsWEB.entity.Author;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;
import java.util.List;

@Mapper
public interface BookMapper {

    @Mapping(source = "author", target = "authorDto")
    BookDto toDto(Book book);
    @Mapping(target = "books", ignore = true)
    AuthorDto toDto(Author author);
    @Mapping(target = "books", ignore = true)
    GenreDto toDto(Genre genre);

    List<BookDto> toDtoList(List<Book> bookList);
    List<BookDtoIdName> toDtoListOnlyBooks(List<Book> bookList);
    List<BookDtoIdNameAuthorGenre> toDtoINAG(List<Book> bookList);
    List<BookDtoIdNameAuthorDates> toDtoIdNameAuthor(List<Book> bookList);

}