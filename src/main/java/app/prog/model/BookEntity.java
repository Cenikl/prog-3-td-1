package app.prog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    //TODO-6: join BookEntity with AuthorEntity and make the correct change so that the API does not change
    // Must know : a book can have only one author but an author can have many books

    @OneToOne(fetch = FetchType.LAZY)
    private AuthorEntity authorEntity;
    private String author = authorEntity.getName();

    @OneToMany
    private List<Category> categories;

    private Integer pageNumber;
    private LocalDate releaseDate;

    public boolean hasAuthor() {
        return author != null;
    }





}
