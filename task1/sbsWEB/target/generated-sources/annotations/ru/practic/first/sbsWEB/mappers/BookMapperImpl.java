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
import ru.practic.first.sbsWEB.dto.Book.BookDtoIdName;
import ru.practic.first.sbsWEB.dto.Book.BookDtoIdNameAuthorDates;
import ru.practic.first.sbsWEB.dto.Book.BookDtoIdNameAuthorGenre;
import ru.practic.first.sbsWEB.dto.Genre.GenreDto;
import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Author;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T19:07:58+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setAuthorDto( toDto( book.getAuthor() ) );
        bookDto.setId( book.getId() );
        bookDto.setName( book.getName() );
        bookDto.setDateOfPublication( book.getDateOfPublication() );
        bookDto.setInLibDate( book.getInLibDate() );
        bookDto.setGenre( genreSetToGenreDtoSet( book.getGenre() ) );

        return bookDto;
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
    public GenreDto toDto(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        genreDto.setId( genre.getId() );
        genreDto.setName( genre.getName() );

        return genreDto;
    }

    @Override
    public List<BookDto> toDtoList(List<Book> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( bookList.size() );
        for ( Book book : bookList ) {
            list.add( toDto( book ) );
        }

        return list;
    }

    @Override
    public List<BookDtoIdName> toDtoListOnlyBooks(List<Book> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookDtoIdName> list = new ArrayList<BookDtoIdName>( bookList.size() );
        for ( Book book : bookList ) {
            list.add( bookToBookDtoIdName( book ) );
        }

        return list;
    }

    @Override
    public List<BookDtoIdNameAuthorGenre> toDtoINAG(List<Book> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookDtoIdNameAuthorGenre> list = new ArrayList<BookDtoIdNameAuthorGenre>( bookList.size() );
        for ( Book book : bookList ) {
            list.add( bookToBookDtoIdNameAuthorGenre( book ) );
        }

        return list;
    }

    @Override
    public List<BookDtoIdNameAuthorDates> toDtoIdNameAuthor(List<Book> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookDtoIdNameAuthorDates> list = new ArrayList<BookDtoIdNameAuthorDates>( bookList.size() );
        for ( Book book : bookList ) {
            list.add( bookToBookDtoIdNameAuthorDates( book ) );
        }

        return list;
    }

    protected Set<GenreDto> genreSetToGenreDtoSet(Set<Genre> set) {
        if ( set == null ) {
            return null;
        }

        Set<GenreDto> set1 = new HashSet<GenreDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Genre genre : set ) {
            set1.add( toDto( genre ) );
        }

        return set1;
    }

    protected BookDtoIdName bookToBookDtoIdName(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDtoIdName bookDtoIdName = new BookDtoIdName();

        bookDtoIdName.setId( book.getId() );
        bookDtoIdName.setName( book.getName() );
        bookDtoIdName.setDateOfPublication( book.getDateOfPublication() );
        bookDtoIdName.setInLibDate( book.getInLibDate() );

        return bookDtoIdName;
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

    protected GenreDtoNoBooks genreToGenreDtoNoBooks(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDtoNoBooks genreDtoNoBooks = new GenreDtoNoBooks();

        genreDtoNoBooks.setId( genre.getId() );
        genreDtoNoBooks.setName( genre.getName() );

        return genreDtoNoBooks;
    }

    protected Set<GenreDtoNoBooks> genreSetToGenreDtoNoBooksSet(Set<Genre> set) {
        if ( set == null ) {
            return null;
        }

        Set<GenreDtoNoBooks> set1 = new HashSet<GenreDtoNoBooks>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Genre genre : set ) {
            set1.add( genreToGenreDtoNoBooks( genre ) );
        }

        return set1;
    }

    protected BookDtoIdNameAuthorGenre bookToBookDtoIdNameAuthorGenre(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDtoIdNameAuthorGenre bookDtoIdNameAuthorGenre = new BookDtoIdNameAuthorGenre();

        bookDtoIdNameAuthorGenre.setId( book.getId() );
        bookDtoIdNameAuthorGenre.setName( book.getName() );
        bookDtoIdNameAuthorGenre.setAuthor( authorToAuthorDtoNotBooks( book.getAuthor() ) );
        bookDtoIdNameAuthorGenre.setDateOfPublication( book.getDateOfPublication() );
        bookDtoIdNameAuthorGenre.setInLibDate( book.getInLibDate() );
        bookDtoIdNameAuthorGenre.setGenre( genreSetToGenreDtoNoBooksSet( book.getGenre() ) );

        return bookDtoIdNameAuthorGenre;
    }

    protected BookDtoIdNameAuthorDates bookToBookDtoIdNameAuthorDates(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDtoIdNameAuthorDates bookDtoIdNameAuthorDates = new BookDtoIdNameAuthorDates();

        bookDtoIdNameAuthorDates.setId( book.getId() );
        bookDtoIdNameAuthorDates.setName( book.getName() );
        bookDtoIdNameAuthorDates.setAuthor( authorToAuthorDtoNotBooks( book.getAuthor() ) );
        bookDtoIdNameAuthorDates.setDateOfPublication( book.getDateOfPublication() );
        bookDtoIdNameAuthorDates.setInLibDate( book.getInLibDate() );

        return bookDtoIdNameAuthorDates;
    }
}
