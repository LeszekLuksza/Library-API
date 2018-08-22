package pl.coderslab.library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.library.Model.Book;
import pl.coderslab.library.Service.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/all")
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }


}
