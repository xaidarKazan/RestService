package ru.practic.first.sbsWEB.mappers;

import org.mapstruct.Mapper;
import ru.practic.first.sbsWEB.dto.Genre.GenreDto;
import ru.practic.first.sbsWEB.dto.Genre.GenreDtoNoBooks;
import ru.practic.first.sbsWEB.entity.Genre;
import java.util.List;

@Mapper
public interface GenreMapper {

    GenreDto toDto(Genre genre);
    GenreDtoNoBooks toDtoOnlyName(Genre genre);
    List<GenreDtoNoBooks> toDtoListOnlyName(List<Genre> genres);

}
