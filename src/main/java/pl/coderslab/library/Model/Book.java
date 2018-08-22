package pl.coderslab.library.Model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private BigInteger id;

    @NotNull
    @Column(name="title")
    private String title;

    @NotNull
    @Column(name="author")
    private String author;

    @NotNull
    @Column(name="publisher")
    private String publisher;

    @NotNull
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


