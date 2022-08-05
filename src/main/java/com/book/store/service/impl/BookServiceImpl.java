package com.book.store.service.impl;

import com.book.store.model.Book;
import com.book.store.repository.BookRepository;
import com.book.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    @Override
    public Book insertBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
