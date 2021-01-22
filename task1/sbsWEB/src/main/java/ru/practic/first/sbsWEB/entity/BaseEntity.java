package ru.practic.first.sbsWEB.entity;

import lombok.Data;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class BaseEntity {
    private LocalDate postTime;   // Дата вставки записи.
    private LocalDate putTime;    // Дата изменения записи.
    private Long version = 0L;

    public BaseEntity() {
        this.postTime = LocalDate.now();
    }
}
