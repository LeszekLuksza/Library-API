package pl.coderslab.library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.library.Model.Book;
import pl.coderslab.library.Service.BookRepository;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final
    BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value={"","/","all"})
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(value="/{isbn}")
    public Book getBookByIsbn(@PathVariable BigInteger isbn){
        return bookRepository.findBookByIsbn(isbn);
    }
}
