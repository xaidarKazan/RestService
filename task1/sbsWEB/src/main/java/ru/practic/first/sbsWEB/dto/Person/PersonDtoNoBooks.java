package ru.practic.first.sbsWEB.dto.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDtoNoBooks {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;

}