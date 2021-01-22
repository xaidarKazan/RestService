package ru.practic.first.sbsWEB.mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import ru.practic.first.sbsWEB.dto.Book.BookDtoForPerson;
import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoBooksNoAuthorAndGenre;
import ru.practic.first.sbsWEB.dto.Person.PersonDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Author;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;
import ru.practic.first.sbsWEB.entity.Person;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T20:05:45+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDtoNoBooks toDtoNoBooks(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDtoNoBooks personDtoNoBooks = new PersonDtoNoBooks();

        personDtoNoBooks.setId( person.getId() );
        personDtoNoBooks.setFirstName( person.getFirstName() );
        personDtoNoBooks.setLastName( person.getLastName() );
        personDtoNoBooks.setMiddleName( person.getMiddleName() );
        personDtoNoBooks.setBirthDate( person.getBirthDate() );

        return personDtoNoBooks;
    }

    @Override
    public List<BookDtoForPerson> toDtoBookList(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDtoForPerson> list = new ArrayList<BookDtoForPerson>( books.size() );
        for ( Book book : books ) {
            list.add( toDto( book ) );
        }

        return list;
    }

    @Override
    public BookDtoForPerson toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDtoForPerson bookDtoForPerson = new BookDtoForPerson();

        bookDtoForPerson.setId( book.getId() );
        bookDtoForPerson.setName( book.getName() );
        bookDtoForPerson.setAuthor( toDto( book.getAuthor() ) );
        bookDtoForPerson.setGenre( genreSetToGenreDtoNoBooksSet( book.getGenre() ) );

        return bookDtoForPerson;
    }

    @Override
    public AuthorDtoNotBooks toDto(Author author) {
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

    @Override
    public GenreDtoNoBooks toDto(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDtoNoBooks genreDtoNoBooks = new GenreDtoNoBooks();

        genreDtoNoBooks.setId( genre.getId() );
        genreDtoNoBooks.setName( genre.getName() );

        return genreDtoNoBooks;
    }

    @Override
    public PersonDtoBooksNoAuthorAndGenre toDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDtoBooksNoAuthorAndGenre personDtoBooksNoAuthorAndGenre = new PersonDtoBooksNoAuthorAndGenre();

        personDtoBooksNoAuthorAndGenre.setId( person.getId() );
        personDtoBooksNoAuthorAndGenre.setFirstName( person.getFirstName() );
        personDtoBooksNoAuthorAndGenre.setLastName( person.getLastName() );
        personDtoBooksNoAuthorAndGenre.setMiddleName( person.getMiddleName() );
        personDtoBooksNoAuthorAndGenre.setBirthDate( person.getBirthDate() );
        personDtoBooksNoAuthorAndGenre.setPersonBooks( toDtoListBookDtoIdName( person.getPersonBooks() ) );

        return personDtoBooksNoAuthorAndGenre;
    }

    protected Set<GenreDtoNoBooks> genreSetToGenreDtoNoBooksSet(Set<Genre> set) {
        if ( set == null ) {
            return null;
        }

        Set<GenreDtoNoBooks> set1 = new HashSet<GenreDtoNoBooks>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Genre genre : set ) {
            set1.add( toDto( genre ) );
        }

        return set1;
    }
}
