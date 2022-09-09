package io.javabrains.springsecurityjwt.Books;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

    private Long id;
    private String name;
    private String author;
    private String category;
    private LocalDate dateOfPublication;

    public Book() {
    }

    public Book(Long id, String name, String author, String category, LocalDate dateOfPublication) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.dateOfPublication = dateOfPublication;
    }

    public Book(String name, String author, String category, LocalDate dateOfPublication) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.dateOfPublication = dateOfPublication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", dateOfPublication=" + dateOfPublication +
                '}';
    }
}
