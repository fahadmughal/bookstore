package com.book.store.service;

import com.book.store.dto.BillDTO;
import com.book.store.dto.CheckOutDTO;
import com.book.store.model.Book;
import com.book.store.model.BookType;
import com.book.store.model.Promotion;
import com.book.store.repository.BookRepository;
import com.book.store.service.impl.CheckOutServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutServiceTest {
    @InjectMocks
    private CheckOutServiceImpl checkOutService;
    @Mock
    private BookRepository bookRepository;

    @Test
    public void testCheckOut(){
        Book book = new Book();
        book.setAuthor("Author");
        book.setId(1L);
        book.setIsbn(2L);
        book.setName("Comic Book 1");
        book.setPrice(100L);
        BookType bookType = new BookType();
        bookType.setId(2L);
        bookType.setBookTypeEng("Fiction");
        Promotion promotion = new Promotion();
        promotion.setPercentage(10);
        promotion.setName("Monthly sale");
        bookType.setPromotion(promotion);
        book.setBookType(bookType);

        Book book1 = new Book();
        book1.setAuthor("Author");
        book1.setId(1L);
        book1.setIsbn(2L);
        book1.setName("Comic Book 1");
        book1.setPrice(50L);
        BookType bookType1 = new BookType();
        bookType1.setId(2L);
        bookType1.setBookTypeEng("Comic");
        book1.setBookType(bookType1);

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        when(bookRepository.findAllById(Mockito.any())).thenReturn(books);

        BillDTO billDTO = checkOutService.checkOut(new CheckOutDTO());
        assertNotNull(billDTO);
        assertEquals(140.0, billDTO.getTotalPrice());
        assertEquals(10.0, billDTO.getTotalDiscountPrice());

    }
}
