package jdbc.tx;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mycompany.springbasic1120.jdbc.tx.dao.BookDao;

public class Tx1 {

    @Test
    public void t1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
        BookDao bookDao = ctx.getBean("bookDaoImpl", BookDao.class);
        
        System.out.println(bookDao);
        
        // wid = 1 顧客錢包
        Integer wid = 1;
        
        // bid = 1 書籍編號
        Integer bid = 1;
        
        Integer price = bookDao.getPrice(bid);
        
        // 進行交易
        System.out.println("Transaction START...");
        bookDao.updateStock(bid);
        bookDao.updateWallet(wid, price);
        System.out.println("Transaction COMPLETE...");
    }
}
