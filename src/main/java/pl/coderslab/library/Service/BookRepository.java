package pl.coderslab.library.Service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    public Book findBookByIsbn(Long isbn);
}
