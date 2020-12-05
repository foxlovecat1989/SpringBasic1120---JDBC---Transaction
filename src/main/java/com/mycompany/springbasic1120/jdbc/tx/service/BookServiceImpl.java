package com.mycompany.springbasic1120.jdbc.tx.service;

import com.mycompany.springbasic1120.jdbc.tx.dao.BookDao;
import com.mycompany.springbasic1120.jdbc.tx.exception.InsufficientAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookDao bookDao;
    
    @Transactional(propagation = Propagation.REQUIRED, 
            timeout = 2,
            rollbackFor = {InsufficientAmountException.class})
    @Override
    public void buyOne(Integer wid, Integer bid) throws InsufficientAmountException {
        int price = bookDao.getPrice(bid);
        System.out.println("BookService Transaction START...");
        bookDao.updateStock(bid);
//        try {
//            Thread.sleep(3);   
//        } catch (Exception e) {
//        }
        bookDao.updateWallet(wid, price);
        System.out.println("BookService Transaction COMPLETE...");
    }

    @Override
    public void buyMany(Integer wird, Integer... bids) {
        
    }
    
}
