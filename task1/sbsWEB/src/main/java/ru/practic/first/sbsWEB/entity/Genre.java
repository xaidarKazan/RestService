package ru.practic.first.sbsWEB.entity;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "dim_genre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;

    @Column(name = "genre_name", nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "book_genre_lnk",
               joinColumns = @JoinColumn(name = "genre_id"),
               inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books =new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre = (Genre) o;
        return Objects.equals(getName(), genre.getName());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
