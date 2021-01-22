package ru.practic.first.sbsWEB.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practic.first.sbsWEB.dto.Author.AuthorDto;
import ru.practic.first.sbsWEB.dto.Author.AuthorDtoNotBooks;
import ru.practic.first.sbsWEB.entity.Author;
import ru.practic.first.sbsWEB.entity.Book;
import ru.practic.first.sbsWEB.mappers.AuthorMapper;
import ru.practic.first.sbsWEB.repository.Author.AuthorRepository;
import ru.practic.first.sbsWEB.service.api.AuthorServise;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorServise{

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorDto> allAuthors() {return authorMapper.toDtoAuthorLists(authorRepository.findAll()); }

    @Override
    public AuthorDto getAuthorBooks(Long id) {
        return authorMapper.toDtoAuthorBooks(authorRepository.findById(id).get()); }

    @Override
    @Transactional
    public AuthorDto addAuthor(Author newAuthor) {
        for (Book book : newAuthor.getBooks()) {
            book.setAuthor(newAuthor);
        }
        return authorMapper.toDtoAuthorBooks(authorRepository.save(newAuthor));
    }

    @Override
    @Transactional
    public boolean removeAuthor(Long id) {
        Author author = authorRepository.getOne(id);
        if (author.getBooks().isEmpty()) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<AuthorDtoNotBooks> getByParams(String firstName, String lastName, String middleName, LocalDate from, LocalDate to) {
        List<Author> authorList = authorRepository.getByParams(firstName, lastName, middleName, from, to);
        return authorMapper.toDtoAuthorNoBooks(authorList);
    }
}