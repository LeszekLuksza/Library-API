package pl.coderslab.library.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.library.Model.Book;

import java.math.BigInteger;

public interface BookRepository extends JpaRepository<Book, BigInteger> {
    public Book findBookByIsbn(BigInteger isbn);
}
