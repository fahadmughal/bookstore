package com.book.store.dto;

import com.book.store.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CheckOutDTO {
    private List<Long> lstBookId;
    private String promotionCode;
}
