package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@RequestParam("id") String id) {
        Book findBook=bookService.findBookById(String.valueOf(Integer.parseInt(id)));
        return new ResponseEntity<>(findBook, HttpStatus.FOUND);
    }
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> findAllBooks() {
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.FOUND);
    }

    @GetMapping("/get-books-by-author/{author}")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam("author") String name) {
        List<Book> list=bookService.findBooksByAuthor(name);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @GetMapping("/get-books-by-genre/{genre}")
    public ResponseEntity<List<Book>> findBooksByGenre(@PathVariable("genre") String genre) {
        return new ResponseEntity<>(bookService.findBooksByGenre(genre), HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookById(@RequestParam("id") String id) {
        bookService.deleteBookById(String.valueOf(Integer.parseInt(id)));
    }
    @DeleteMapping("/delete-all-books")
    public void deleteAllBooks() {
        bookService.deleteAllBooks();
    }

}
