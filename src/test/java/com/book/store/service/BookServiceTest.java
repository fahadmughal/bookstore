package com.book.store.service;

import com.book.store.model.Book;
import com.book.store.repository.BookRepository;
import com.book.store.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @InjectMocks
    private BookServiceImpl bookService;
    @Mock
    private BookRepository bookRepository;

    private Book book;

    @Before
    public void init(){
        book = new Book();
        book.setAuthor("Author");
        book.setId(1L);
        book.setIsbn(2L);
        book.setName("Comic Book 1");
    }

    @Test
    public void testShouldReturnListOfBooks(){
        when(bookRepository.findAll()).thenReturn(Collections.singletonList(book));
        List<Book> books = bookService.findAllBooks();
        assertNotNull(books);
        Assert.assertEquals(book.getAuthor(), books.get(0).getAuthor());
        Assert.assertEquals(book.getId(), books.get(0).getId());
        Assert.assertEquals(book.getName(), books.get(0).getName());
    }
    @Test
    public void testShouldReturnBookById(){
        Optional<Book> optionalBook = Optional.of(book);
        when(bookRepository.findById(Mockito.any())).thenReturn(optionalBook);
        Book book  = bookService.findBookById(1L);
        Assert.assertNotNull(book);
        Assert.assertEquals(book.getAuthor(), book.getAuthor());
        Assert.assertEquals(book.getId(), book.getId());
        Assert.assertEquals(book.getName(), book.getName());
    }
    @Test
    public void testShouldInsertBook(){
        when(bookRepository.save(Mockito.any())).thenReturn(book);
        Book book = bookService.insertBook(new Book());
        Assert.assertNotNull(book);
        Assert.assertEquals(book.getAuthor(), book.getAuthor());
        Assert.assertEquals(book.getId(), book.getId());
        Assert.assertEquals(book.getName(), book.getName());
    }
    @Test
    public void testShouldDeleteBook(){
        boolean isDeleted = bookService.deleteBook(1L);
        assertTrue(isDeleted);
    }
}
