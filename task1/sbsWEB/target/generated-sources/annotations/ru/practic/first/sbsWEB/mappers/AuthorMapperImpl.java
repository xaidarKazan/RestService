package ru.practic.first.sbsWEB.mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ru.practic.first.sbsWEB.dto.Author.AuthorDto;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import ru.practic.first.sbsWEB.dto.Book.BookDto;
import ru.practic.first.sbsWEB.dto.Genre.GenreDto;
import ru.practic.first.sbsWEB.entity.Author;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T19:07:58+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public List<AuthorDtoNotBooks> toDtoAuthorNoBooks(List<Author> authorList) {
        if ( authorList == null ) {
            return null;
        }

        List<AuthorDtoNotBooks> list = new ArrayList<AuthorDtoNotBooks>( authorList.size() );
        for ( Author author : authorList ) {
            list.add( authorToAuthorDtoNotBooks( author ) );
        }

        return list;
    }

    @Override
    public List<AuthorDto> toDtoAuthorLists(List<Author> authorList) {
        if ( authorList == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( authorList.size() );
        for ( Author author : authorList ) {
            list.add( toDto( author ) );
        }

        return list;
    }

    @Override
    public AuthorDto toDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setFirstName( author.getFirstName() );
        authorDto.setLastName( author.getLastName() );
        authorDto.setMiddleName( author.getMiddleName() );

        return authorDto;
    }

    @Override
    public AuthorDto toDtoAuthorBooks(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setFirstName( author.getFirstName() );
        authorDto.setLastName( author.getLastName() );
        authorDto.setMiddleName( author.getMiddleName() );
        authorDto.setBooks( bookListToBookDtoList( author.getBooks() ) );

        return authorDto;
    }

    @Override
    public BookDto toDtoBook(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setName( book.getName() );
        bookDto.setDateOfPublication( book.getDateOfPublication() );
        bookDto.setInLibDate( book.getInLibDate() );
        bookDto.setGenre( genreSetToGenreDtoSet( book.getGenre() ) );

        return bookDto;
    }

    @Override
    public GenreDto toDtoGenre(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        genreDto.setId( genre.getId() );
        genreDto.setName( genre.getName() );

        return genreDto;
    }

    protected AuthorDtoNotBooks authorToAuthorDtoNotBooks(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDtoNotBooks authorDtoNotBooks = new AuthorDtoNotBooks();

        authorDtoNotBooks.setFirstName( author.getFirstName() );
        authorDtoNotBooks.setLastName( author.getLastName() );
        authorDtoNotBooks.setMiddleName( author.getMiddleName() );
        authorDtoNotBooks.setBirthDate( author.getBirthDate() );

        return authorDtoNotBooks;
    }

    protected List<BookDto> bookListToBookDtoList(List<Book> list) {
        if ( list == null ) {
            return null;
        }

        List<BookDto> list1 = new ArrayList<BookDto>( list.size() );
        for ( Book book : list ) {
            list1.add( toDtoBook( book ) );
        }

        return list1;
    }

    protected Set<GenreDto> genreSetToGenreDtoSet(Set<Genre> set) {
        if ( set == null ) {
            return null;
        }

        Set<GenreDto> set1 = new HashSet<GenreDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Genre genre : set ) {
            set1.add( toDtoGenre( genre ) );
        }

        return set1;
    }
}
