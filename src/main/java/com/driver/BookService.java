package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(String id){
        return bookRepository.findBookById(Integer.parseInt(id));
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> findBooksByAuthor(String author){
        return bookRepository.findBooksByAuthor(author);
    }

    public List<Book> findBooksByGenre(String genre){
        return bookRepository.findBooksByGenre(genre);
    }

    public void deleteBookById(String id){
        bookRepository.deleteBookById(Integer.parseInt(id));
    }

    public void deleteAllBooks(){
        bookRepository.deleteAll();
    }




}
