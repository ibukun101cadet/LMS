package io.javabrains.springsecurityjwt.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.name=?1")
    Optional<Book> findByName(String name);

    @Query("SELECT b FROM Book b WHERE b.category=?1")
    Optional<Book> findByCategory(String category);

    @Query("SELECT b FROM Book b WHERE b.author=?1")
    Optional<Book> findByAuthor(String author);

    @Query("SELECT b FROM Book b WHERE b.dateOfPublication=?1")
    Optional<Book> findByDateOfPub(String dateOfPub);



}
