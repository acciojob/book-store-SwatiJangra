package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    ArrayList<Book> bookArrayList;
    HashMap<Integer, Book> bookHashMap;
    // <id, book>
    private int id;

    public BookRepository(){
        bookArrayList=new ArrayList<>();
        bookHashMap=new HashMap<>();
        id=1;
    }

    public Book save(Book book){
        book.setId(id);
        bookHashMap.put(id,book);
        bookArrayList.add(book);
        id++;
        return book;
    }

    public Book findBookById(int id){
        for(int i : bookHashMap.keySet()) {
            if(bookHashMap.containsKey(id)) {
                return bookHashMap.get(id);
            }
        }
        return null;
    }

    public List<Book> findAll(){
        List<Book> list=new ArrayList<>();
        for(int i : bookHashMap.keySet()) {
            list.add(bookHashMap.get(i));
        }
        return list;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> list=new ArrayList<>();
        for(int i=0;i<bookArrayList.size();i++) {
            Book b=bookArrayList.get(i);
            if(b.getAuthor().equals(author)) {
                list.add(b);
            }
        }
        return list;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list=new ArrayList<>();
        for(int i=0;i<bookArrayList.size();i++) {
            Book b=bookArrayList.get(i);
            if(b.getGenre().equals(genre)) {
                list.add(b);
            }
        }
        return list;
    }

    public void deleteBookById(int id){
        for(int i=0;i<bookArrayList.size();i++) {
            if(bookArrayList.get(i).getId()==id) {
                bookArrayList.remove(i);
            }
        }
        for(int i : bookHashMap.keySet()) {
            if(i==id) {
                bookHashMap.remove(i);
            }
        }
        return;
    }
    public void deleteAll(){
        for(int i=0;i<bookArrayList.size();i++) {
            bookArrayList.remove(i);
        }
        for(int i : bookHashMap.keySet()) {
            bookHashMap.remove(i);
        }
        return;
    }
}
