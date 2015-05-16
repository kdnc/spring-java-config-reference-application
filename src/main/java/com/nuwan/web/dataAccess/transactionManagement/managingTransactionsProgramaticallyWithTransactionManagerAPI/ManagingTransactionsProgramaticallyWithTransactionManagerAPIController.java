package com.nuwan.web.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI;

import com.nuwan.config.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI.BookstoreConfiguration3;
import com.nuwan.model.dataAccess.transactionManagement.managingTransactionsProgramaticallyWithTransactionManagerAPI.BookShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/dataAccess/transactionManagement/managingTransactionsProgramaticallyWithTransactionManagerAPI")
public class ManagingTransactionsProgramaticallyWithTransactionManagerAPIController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String managingTransactionsProgramaticallyWithTransactionManagerAPI() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookstoreConfiguration3.class);

        BookShop bookShop = context.getBean(BookShop.class);
        bookShop.purchase("0001", "user1");
        return "";
    }

}