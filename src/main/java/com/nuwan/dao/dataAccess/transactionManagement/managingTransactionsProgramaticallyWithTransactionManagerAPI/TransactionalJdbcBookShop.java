package com.nuwan.dao.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI;

import com.nuwan.model.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI.BookShop;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


public class TransactionalJdbcBookShop extends JdbcDaoSupport implements BookShop {

    private PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void purchase(String isbn, String username) {
//        Before you start a new transaction, you have to specify the transaction attributes in a transaction
//        definition object of type TransactionDefinition.
        TransactionDefinition def = new DefaultTransactionDefinition();
//        Spring’s transaction manager provides a technology-independent API that allows you to start a new transaction
//        (or obtain the currently active transaction) by calling the getTransaction() method and manage it by calling the
//        commit() and rollback() methods. it will return a TransactionStatus object to keep
//        track of the transaction status.
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            int price = getJdbcTemplate().queryForInt(
                    "SELECT PRICE FROM BOOK WHERE ISBN = ?",
                    new Object[] { isbn });

            getJdbcTemplate().update(
                    "UPDATE BOOK_STOCK SET STOCK = STOCK - 1 "+
                            "WHERE ISBN = ?", new Object[] { isbn });

            getJdbcTemplate().update(
                    "UPDATE ACCOUNT SET BALANCE = BALANCE - ? "+
                            "WHERE USERNAME = ?",
                    new Object[] { price, username });

            transactionManager.commit(status);
//            all exceptions thrown by the Spring JDBC template are
//            subclasses of DataAccessException,
        } catch (DataAccessException e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

}
