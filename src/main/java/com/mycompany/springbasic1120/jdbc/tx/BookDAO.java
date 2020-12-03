package com.mycompany.springbasic1120.jdbc.tx;

public interface BookDAO {
    Integer getPrice(Integer bid);
    void updateStock(Integer bid);  // 更新庫存
    void updateWallet(Integer wid, Integer money); // 更新錢包
}
