package com.book.store.service;

import com.book.store.dto.BillDTO;
import com.book.store.dto.CheckOutDTO;

public interface CheckOutService {
    BillDTO checkOut(CheckOutDTO checkOutDTO);
}
