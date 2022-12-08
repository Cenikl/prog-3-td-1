package app.prog.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookRequestPost {
    private String author;
    private String title;
    private Integer pageNumber = 0;
    private boolean hasAuthor;
}
