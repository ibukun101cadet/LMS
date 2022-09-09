package io.javabrains.springsecurityjwt.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/library/")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Get all books
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/title/{bookName}")
    public Optional<Book> getBookByName(@PathVariable("bookName")String bookName) {
        return bookService.getBookByName(bookName);
    }
    //Get book by Id
    @GetMapping("/book/id/{bookId}")
    public Optional<Book> getBookById(@PathVariable("bookId") Long bookId) {
        return bookService.getBookById(bookId);
    }

    //Get book by Category
    @GetMapping("/book/category/{bookCategory}")
    public Optional<Book> getBookByCategory(@PathVariable("bookCategory") String bookCategory) {
        return bookService.getBookByCategory(bookCategory);
    }


    //Get book by Author
    @GetMapping("/book/author/{bookAuthor}")
    public Optional<Book> getBookByAuthor(@PathVariable("bookAuthor") String bookAuthor) {
        return bookService.getBookByAuthor(bookAuthor);
    }

    //Get book by Publication Date
    @GetMapping("/book/dateOfPublication/{bookPubDate}")
    public Optional<Book> getBookByPubDate(@PathVariable("bookPubDate") String bookPubDate) {
        return bookService.getBookByPubDate(bookPubDate);
    }

    @PostMapping("/addBook")
    public void addNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "book/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping("/update/{bookId}")
    public void updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String author) {
        bookService.updateBook(bookId, name, author);
    }





}




