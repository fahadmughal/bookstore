package com.book.store.controller;

import com.book.store.dto.BillDTO;
import com.book.store.dto.CheckOutDTO;
import com.book.store.model.Book;
import com.book.store.service.CheckOutService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/checkout")
public class CheckOutController {

    private final CheckOutService checkOutService;

    public CheckOutController(CheckOutService checkOutService) {
        this.checkOutService = checkOutService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST,  produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list", content = @Content(schema = @Schema(implementation = BillDTO.class))),
            @ApiResponse(responseCode = "204", description = "No account found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<BillDTO> checkOut(@RequestBody CheckOutDTO checkOutDTO) {
        return new ResponseEntity<>(checkOutService.checkOut(checkOutDTO), HttpStatus.OK);
    }
}
