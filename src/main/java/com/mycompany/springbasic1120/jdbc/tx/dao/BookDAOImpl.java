package com.mycompany.springbasic1120.jdbc.tx.dao;

import com.mycompany.springbasic1120.jdbc.tx.exception.InsufficientAmountException;
import javax.naming.spi.DirStateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Integer getPrice(Integer bid) {
        String sql =   "SELECT price "
                    + "FROM Book "
                    + "WHERE bid=?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bid);
        return price;
    }

    @Override
    public void updateStock(Integer bid) {
        String sql =   "UPDATE Stock "
                    + "SET amount=amount-1 "
                    + "WHERE bid=?";
       jdbcTemplate.update(sql, bid);
    }

    @Override
    public void updateWallet(Integer wid, Integer cost) throws InsufficientAmountException {
        // 先判斷 Wallet 的 money 是否足夠 ?
        String sql =  "SELECT money "
                    + "FROM Wallet "
                    + "WHERE wid=?";
        int walletMoney = jdbcTemplate.queryForObject(sql, Integer.class, wid);
        
        if(walletMoney < cost){
            throw new InsufficientAmountException();
        }
        
        // 進行錢包餘額更新
        sql =   "UPDATE Wallet "
                    + "SET money=money-? "
                    + "WHERE wid=?";
        
        jdbcTemplate.update(sql, cost, wid);
    }
}
