package io.javabrains.springsecurityjwt.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookByName(String bookName) {
        Optional<Book> bookOptional = bookRepository.findByName(bookName);
        if (!bookOptional.isPresent()){
            throw new IllegalStateException(bookName + " does not exist");
        }
        return bookOptional;
    }

    public Optional<Book> getBookById(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) {
            throw new IllegalStateException(
                    "book with id " + bookId + " does not exist");
        }
        return bookRepository.findById(bookId);
    }
    public Optional<Book> getBookByCategory(String bookCategory) {
        Optional<Book> bookOptional = bookRepository.findByCategory(bookCategory);
        if (!bookOptional.isPresent()){
            throw new IllegalStateException(bookCategory + " does not exist");
        }
        return bookOptional;
    }

    public Optional<Book> getBookByAuthor(String bookAuthor) {
        Optional<Book> bookOptional = bookRepository.findByAuthor(bookAuthor);
        if (!bookOptional.isPresent()){
            throw new IllegalStateException(bookAuthor + " does not exist");
        }
        return bookOptional;
    }

    public Optional<Book> getBookByPubDate(String bookPubDate) {
        Optional<Book> bookOptional = bookRepository.findByDateOfPub(bookPubDate);
        if (!bookOptional.isPresent()){
            throw new IllegalStateException(bookPubDate + " does not exist");
        }
        return bookOptional;
    }

    public void addNewBook(Book book) {
       Optional<Book> bookOptional = bookRepository.findByName(book.getName());
       if (bookOptional.isPresent()){
           throw new IllegalStateException("Book already exists");
       }
        bookRepository.save(book);


    }
    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) {
            throw new IllegalStateException(
                    "book with id " + bookId + " does not exist");
        }
            bookRepository.deleteById(bookId);
        }
    @Transactional
    public void updateBook(Long bookId,
                           String name,
                           String author) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException(
                        "book with id " + bookId + " does not exist"
                ));
        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(book.getName(), name)) { //what is this?
            book.setName(name);
        }

        if (author != null &&
                author.length() > 0 &&
                !Objects.equals(book.getAuthor(), author)) {
            book.setAuthor(author);
            {

            }
        }
    }

}

