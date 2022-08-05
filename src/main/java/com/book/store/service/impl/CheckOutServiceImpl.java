package com.book.store.service.impl;

import com.book.store.dto.BillDTO;
import com.book.store.dto.CheckOutDTO;
import com.book.store.model.Book;
import com.book.store.repository.BookRepository;
import com.book.store.service.CheckOutService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckOutServiceImpl implements CheckOutService {

    private final BookRepository bookRepository;

    public CheckOutServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public BillDTO checkOut(CheckOutDTO checkOutDTO) {
        List<Book> lstBook = bookRepository.findAllById(checkOutDTO.getLstBookId());
        BillDTO billDTO = new BillDTO();

        for(Book book: lstBook){
            if(book.getBookType().getPromotion() != null){
                double discountedPrice = priceAfterDiscount(book);
                billDTO.setTotalPrice(billDTO.getTotalPrice() + discountedPrice);
                billDTO.setTotalDiscountPrice(billDTO.getTotalDiscountPrice() + (book.getPrice() - discountedPrice));
            }
            else {
                billDTO.setTotalPrice(billDTO.getTotalPrice() + book.getPrice());
            }
        }

        return billDTO;
    }

    private double priceAfterDiscount(Book book){
        return book.getPrice() * (1 - book.getBookType().getPromotion().getPercentage() / 100);
    }
}
