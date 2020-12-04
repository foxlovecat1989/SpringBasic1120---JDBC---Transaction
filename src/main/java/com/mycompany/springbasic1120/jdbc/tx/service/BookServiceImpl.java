package com.mycompany.springbasic1120.jdbc.tx.service;

import com.mycompany.springbasic1120.jdbc.tx.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService{
    
    @Autowired
    private BookDao bookDao;
    
    @Transactional
    @Override
    public void buyOne(Integer wid, Integer bid) {
        int price = bookDao.getPrice(bid);
        System.out.println("BookService Transaction START...");
        bookDao.updateStock(bid);
        bookDao.updateWallet(wid, price);
        System.out.println("BookService Transaction COMPLETE...");
    }

    @Override
    public void buyMany(Integer wird, Integer... bids) {
        
    }
    
}
