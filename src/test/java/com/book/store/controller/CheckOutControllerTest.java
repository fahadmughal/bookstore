package com.book.store.controller;

import com.book.store.dto.BillDTO;
import com.book.store.dto.CheckOutDTO;
import com.book.store.model.Book;
import com.book.store.service.CheckOutService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckOutControllerTest {
    @InjectMocks
    private CheckOutController checkOutController;
    @Mock
    private CheckOutService  checkOutService;

    @Test
    public void testCheckoutWithStatusOk(){
        BillDTO billDTO = new BillDTO();
        billDTO.setTotalDiscountPrice(20);
        billDTO.setTotalPrice(100);
        when(checkOutService.checkOut(Mockito.any())).thenReturn(billDTO);

        ResponseEntity<BillDTO> responseEntity = checkOutController.checkOut(new CheckOutDTO());

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(responseEntity.getBody());
        assertEquals(billDTO.getTotalPrice(), responseEntity.getBody().getTotalPrice());
        assertEquals(billDTO.getTotalDiscountPrice(), responseEntity.getBody().getTotalDiscountPrice());
    }
}
