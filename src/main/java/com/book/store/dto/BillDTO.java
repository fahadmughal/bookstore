package com.book.store.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BillDTO {
    private double totalPrice;
    private double totalDiscountPrice;
}
