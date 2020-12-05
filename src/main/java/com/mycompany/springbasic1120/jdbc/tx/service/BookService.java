package com.mycompany.springbasic1120.jdbc.tx.service;

import com.mycompany.springbasic1120.jdbc.tx.exception.InsufficientAmountException;

public interface BookService {
    void buyOne(Integer wid, Integer bid) throws InsufficientAmountException;
    void buyMany(Integer wird, Integer... bids);
    
}
