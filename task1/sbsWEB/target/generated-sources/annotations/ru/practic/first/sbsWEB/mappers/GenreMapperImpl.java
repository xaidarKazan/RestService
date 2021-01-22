package ru.practic.first.sbsWEB.mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ru.practic.first.sbsWEB.dto.Book.BookDto;
import ru.practic.first.sbsWEB.dto.Genre.GenreDto;
import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-25T19:07:58+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDto toDto(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDto genreDto = new GenreDto();

        genreDto.setId( genre.getId() );
        genreDto.setName( genre.getName() );
        genreDto.setBooks( bookListToBookDtoList( genre.getBooks() ) );

        return genreDto;
    }

    @Override
    public GenreDtoNoBooks toDtoOnlyName(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDtoNoBooks genreDtoNoBooks = new GenreDtoNoBooks();

        genreDtoNoBooks.setId( genre.getId() );
        genreDtoNoBooks.setName( genre.getName() );

        return genreDtoNoBooks;
    }

    @Override
    public List<GenreDtoNoBooks> toDtoListOnlyName(List<Genre> genres) {
        if ( genres == null ) {
            return null;
        }

        List<GenreDtoNoBooks> list = new ArrayList<GenreDtoNoBooks>( genres.size() );
        for ( Genre genre : genres ) {
            list.add( toDtoOnlyName( genre ) );
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

    protected BookDto bookToBookDto(Book book) {
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

    protected List<BookDto> bookListToBookDtoList(List<Book> list) {
        if ( list == null ) {
            return null;
        }

        List<BookDto> list1 = new ArrayList<BookDto>( list.size() );
        for ( Book book : list ) {
            list1.add( bookToBookDto( book ) );
        }

        return list1;
    }
}
