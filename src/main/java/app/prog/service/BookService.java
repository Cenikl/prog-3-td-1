package app.prog.service;

import app.prog.model.Book;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }


    public List<Book> createBooks(List<Book> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Book> updateBooks(List<Book> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Book deleteBook(Integer bookId)  {
        /*
        TIPS: From the API, the Class Optional<T> is :
        A container object which may or may not contain a non-null value.
        If a value is present, isPresent() returns true.
        If no value is present, the object is considered empty and isPresent() returns false.

        T is the type of the value, for example : here the class type is Book
         */
        Optional<Book> optional = repository.findById(String.valueOf(bookId));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
        /*
        TODO-5 : The exception appears as an internal server error, status 500.
        We all know that the appropriate error status is the 404 Not Found.
        Any solution to do this ?
        These links may help you :
        Link 1 : https://www.baeldung.com/spring-response-entity
        Link 2 : https://www.baeldung.com/exception-handling-for-rest-with-spring
         */
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Book "+bookId+" not found");
        }
    }
}
