package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.BookRequestPost;
import app.prog.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    public BookResponse toRest(Book domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .hasAuthor(domain.hasAuthor())
                .build();
    }
    public BookRequestPost toPost(Book domain) {
        return BookRequestPost.builder()
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .hasAuthor(domain.hasAuthor())
                .build();
    }
}
