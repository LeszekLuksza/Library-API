package pl.coderslab.library.Model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private BigInteger id;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="publisher")
    private String publisher;

    @Column(name="isbn")
    @Length(min=13, max=13)
    private BigInteger isbn;

    public Book() {
    }

    public Book(String title, String author, String publisher, BigInteger isbn) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

}


