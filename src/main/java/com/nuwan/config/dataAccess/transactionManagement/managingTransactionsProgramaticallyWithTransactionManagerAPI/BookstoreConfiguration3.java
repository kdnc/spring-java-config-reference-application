package com.nuwan.config.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI;

import com.mysql.jdbc.Driver;
import com.nuwan.dao.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI.TransactionalJdbcBookShop;
import com.nuwan.model.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI.BookShop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BookstoreConfiguration3 {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://localhost:3306/bookstore");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
//        Because you are dealing with only a single data source and accessing it with JDBC, you should choose
//        DataSourceTransactionManager.
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public BookShop bookShop() {
        TransactionalJdbcBookShop bookShop = new TransactionalJdbcBookShop();
        bookShop.setDataSource(dataSource());
        bookShop.setTransactionManager(transactionManager());
        return bookShop;
    }
}
