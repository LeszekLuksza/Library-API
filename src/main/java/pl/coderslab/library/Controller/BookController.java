package pl.coderslab.library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.library.Model.Book;
import pl.coderslab.library.Service.BookRepository;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "/Book")
public class BookController {

    private final
    BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value={"","/","All"})
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(value="/FindByIsbn/")
    public Book getBookByIsbn(@RequestParam() long isbn){
        BigInteger resultIsbn;
        System.out.println(isbn);
        resultIsbn = BigInteger.valueOf(isbn);
        System.out.println(resultIsbn);
        return bookRepository.findBookByIsbn(resultIsbn);
    }

    @GetMapping(value="/FindById/")
    public Book getBookById(@RequestParam() long id){
        BigInteger resultId;
            resultId = BigInteger.valueOf(id);
        return bookRepository.findBookById(resultId);
    }

    @PostMapping("/Add")
    public String addBook(@RequestBody Book book){
        bookRepository.save(book);
        return "A book has been added";
    }

    @PutMapping("/Edit/{isbn}")
    public String editBook(@RequestBody Book bookFromRequest, @PathVariable long isbn){
        Book bookToSave = bookRepository.findBookByIsbn(BigInteger.valueOf(isbn));
        bookToSave.setTitle(bookFromRequest.getTitle());
        bookToSave.setAuthor(bookFromRequest.getAuthor());
        bookToSave.setPublisher(bookFromRequest.getPublisher());
        bookRepository.save(bookToSave);
        return "A book has been updated";
    }


}
