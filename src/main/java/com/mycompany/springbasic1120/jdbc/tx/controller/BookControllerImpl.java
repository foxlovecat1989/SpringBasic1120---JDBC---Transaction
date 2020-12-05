package com.mycompany.springbasic1120.jdbc.tx.controller;

import com.mycompany.springbasic1120.jdbc.tx.exception.InsufficientAmountException;
import com.mycompany.springbasic1120.jdbc.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookControllerImpl implements BookController {
    @Autowired
    private BookService bookService;
    @Override
    public void buyBook(Integer wid, Integer bid) {
        try {
            bookService.buyOne(wid, bid);
        } catch (InsufficientAmountException ex) {
            System.out.println("交易失敗~");
            System.out.println(ex);
        }
    }

    @Override
    public void buyBooks(Integer wid, Integer... bids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
