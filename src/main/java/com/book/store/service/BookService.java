package com.book.store.service;

import com.book.store.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    Book findBookById(Long id);
    Book insertBook(Book book);
    boolean deleteBook(Long id);

}
