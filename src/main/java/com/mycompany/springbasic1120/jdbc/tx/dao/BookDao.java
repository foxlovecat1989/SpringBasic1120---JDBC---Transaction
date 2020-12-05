package com.mycompany.springbasic1120.jdbc.tx.dao;

import com.mycompany.springbasic1120.jdbc.tx.exception.InsufficientAmountException;

public interface BookDao {
    Integer getPrice(Integer bid);
    void updateStock(Integer bid);  // 更新庫存
    void updateWallet(Integer wid, Integer money) throws InsufficientAmountException; // 更新錢包
}