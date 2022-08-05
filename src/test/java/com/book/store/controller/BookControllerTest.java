package com.book.store.controller;

import com.book.store.model.Book;
import com.book.store.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
    @InjectMocks
    private BookController bookController;
    @Mock
    private BookService bookService;

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
    public void testFindBookByIdShouldReturnBookWithStatusOk(){
        when(bookService.findBookById(Mockito.any())).thenReturn(book);

        ResponseEntity<Book> responseEntity = bookController.findBookById(1L);
        Book result = Objects.requireNonNull(responseEntity.getBody());

        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(book.getAuthor(), result.getAuthor());
        assertEquals(book.getId(), result.getId());
        assertEquals(book.getName(), result.getName());
    }

    @Test
    public void testFindBookByIdShouldReturnNullWithStatusNoContent(){
        when(bookService.findBookById(Mockito.any())).thenReturn(null);
        ResponseEntity<Book> responseEntity = bookController.findBookById(1L);
        assertNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NO_CONTENT);
    }
    @Test
    public void testFindAllBooksShouldReturnAllBooksWithStatusOk(){
        when(bookService.findAllBooks()).thenReturn(Collections.singletonList(book));

        ResponseEntity<List<Book>> lstResponseEntity = bookController.findAllBooks();
        Book result = Objects.requireNonNull(lstResponseEntity.getBody()).get(0);

        assertEquals(lstResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(book.getAuthor(), result.getAuthor());
        assertEquals(book.getId(), result.getId());
        assertEquals(book.getName(), result.getName());
    }
    @Test
    public void testFindAllBooksShouldReturnEmptyListWithStatusNoContent(){
        when(bookService.findAllBooks()).thenReturn(null);
        ResponseEntity<List<Book>> lstResponseEntity = bookController.findAllBooks();
        assertEquals(lstResponseEntity.getStatusCode(), HttpStatus.NO_CONTENT);
        assertNull(lstResponseEntity.getBody());
    }
    @Test
    public void testShouldInsertBookWithStatusOk(){
        when(bookService.insertBook(Mockito.any())).thenReturn(book);
        ResponseEntity<Book> responseEntity = bookController.insertBook(new Book());
        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(book.getAuthor(), responseEntity.getBody().getAuthor());
        assertEquals(book.getId(), responseEntity.getBody().getId());
        assertEquals(book.getName(), responseEntity.getBody().getName());
    }
    @Test
    public void testShouldUpdateBookWithStatusOk(){
        book.setName("Fiction Book");
        when(bookService.insertBook(Mockito.any())).thenReturn(book);
        ResponseEntity<Book> responseEntity = bookController.updateBook(new Book());
        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(book.getAuthor(), responseEntity.getBody().getAuthor());
        assertEquals(book.getId(), responseEntity.getBody().getId());
        assertEquals(book.getName(), responseEntity.getBody().getName());
    }
    @Test
    public void testShouldDeleteBookWithStatusOk(){
        when(bookService.deleteBook(Mockito.any())).thenReturn(true);
        ResponseEntity<Object> responseEntity = bookController.deleteBook(1L);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        assertTrue((Boolean) responseEntity.getBody());
    }
}
