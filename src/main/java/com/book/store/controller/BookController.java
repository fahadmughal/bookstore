package com.book.store.controller;

import com.book.store.model.Book;
import com.book.store.service.BookService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/bookstore")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET,  produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list", content = @Content(schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "204", description = "No book found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        return book != null ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(book, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET,  produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Book.class)))),
            @ApiResponse(responseCode = "204", description = "No book found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<List<Book>> findAllBooks() {
        List<Book> bookList = bookService.findAllBooks();
        return bookList != null ? new ResponseEntity<>(bookList, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.POST,  produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list", content = @Content(schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "204", description = "No account found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<Book> insertBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.insertBook(book), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT,  produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list", content = @Content(schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "204", description = "No account found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.insertBook(book), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,  produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list", content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "204", description = "No account found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<Object> deleteBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }
}
