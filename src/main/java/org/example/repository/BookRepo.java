package org.example.repository;

import org.example.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepo  implements BaseRepo<Book>{
    String path = "src\\main\\resources\\book.json";

    @Override
    public Optional<Book> save(Book book) {
         ArrayList<Book> books = (ArrayList<Book>) readFromFile(path, Book.class);
         books.add(book);
         writeToFile(books,path);
        return Optional.of(book);
    }



    @Override
    public List<Book> getAll() {
        return readFromFile(path,Book.class);
    }
}
