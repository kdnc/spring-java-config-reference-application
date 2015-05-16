package com.nuwan.config.dataAccess.transactionManagement.problemsWithTransactionManagement;

import com.mysql.jdbc.Driver;
import com.nuwan.dao.dataAccess.transactionManagement.problemsWithTransactionManagement.JdbcBookShop;
import com.nuwan.model.dataAccess.transactionManagement.problemsWithTransactionManagement.BookShop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BookstoreConfiguration {

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
    public BookShop bookShop() {
        JdbcBookShop bookShop = new JdbcBookShop();
        bookShop.setDataSource(dataSource());
        return bookShop;
    }
}
