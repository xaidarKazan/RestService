package ru.practic.first.sbsWEB.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import ru.practic.first.sbsWEB.dto.Book.*;
import ru.practic.first.sbsWEB.entity.Author;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.entity.Genre;
import ru.practic.first.sbsWEB.mappers.BookMapper;
import ru.practic.first.sbsWEB.repository.Book.BookRepository;
import ru.practic.first.sbsWEB.service.DateRange;
import ru.practic.first.sbsWEB.service.api.BookService;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public BookDto addBook(Book book) {
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    @Transactional
    public boolean removeBook(Long id) {
        if (bookRepository.existsById(id)) {
            Book book = bookRepository.findById(id).get();
            if (book.getPerson().isEmpty()) {
                bookRepository.deleteById(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public BookDto updateBook(Book newBook) {
        return bookMapper.toDto(bookRepository.saveAndFlush(newBook));
    }

    @Override
    public List<BookDtoIdName> getAllBooksByAuthor(String firstName, String lastName, String middleName) {
        Author authorBooks = new Author();
        authorBooks.setFirstName(firstName);
        authorBooks.setLastName(lastName);
        authorBooks.setMiddleName(middleName);
        Book book = new Book();
        book.setAuthor(authorBooks);
        Example<Book> example = Example.of(book, ExampleMatcher.matchingAny().withIgnoreNullValues());
        return bookMapper.toDtoListOnlyBooks(bookRepository.findAll(example));
    }

    @Override
    public List<BookDtoIdNameAuthorGenre> getAllBooksByGenre(Genre genre) {
        return bookMapper.toDtoINAG(bookRepository.findBookByGenre(genre));
    }

    @Override
    public List<BookDtoIdNameAuthorDates> listBooksWithGenreAndDate(Genre genre,
                                                                    LocalDate date,
                                                                    DateRange range) {
        List<Book> books = bookRepository.listBooksWithGenreAndDate(genre, date, range);
        return bookMapper.toDtoIdNameAuthor(books);
    }
}