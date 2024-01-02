package org.example.service;



import org.example.models.Book;
import org.example.repository.BookRepo;

import java.util.ArrayList;

public class BookService {
    BookRepo bookRepo = new BookRepo();
    public ArrayList<Book> getAllBooks() {
        return (ArrayList<Book>) bookRepo.getAll();
    }

    public void add(Book book) {
        bookRepo.save(book);
    }

    public ArrayList<Book> getByName(String title) {
        ArrayList <Book> allBooks= getAllBooks();
        if(allBooks.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Book> books = new ArrayList<>();
        for (Book allBook : allBooks) {
            if(allBook.getTitle().contains(title)){
                books.add(allBook);
            }
        }
        return books;
    }

    public ArrayList<Book> getByAuthor(String author) {
        ArrayList <Book> allBooks= getAllBooks();
        if(allBooks.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Book> books = new ArrayList<>();
        for (Book allBook : allBooks) {
            if(allBook.getAuthor().contains(author)){
                books.add(allBook);
            }
        }
        return books;
    }

    public ArrayList<Book> getByPublisher(String publisher) {
        ArrayList <Book> allBooks= getAllBooks();
        if(allBooks.isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<Book> books = new ArrayList<>();
        for (Book allBook : allBooks) {
            if(allBook.getPublisher().contains(publisher)){
                books.add(allBook);
            }
        }
        return books;
    }
}
// davay