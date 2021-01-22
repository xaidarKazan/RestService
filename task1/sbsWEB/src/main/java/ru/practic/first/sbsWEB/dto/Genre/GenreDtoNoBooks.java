package ru.practic.first.sbsWEB.dto.Genre;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDtoNoBooks implements Serializable {

    private Long id;
    private String name;

}
