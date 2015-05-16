package com.nuwan.web.dataAccess.transactionManagement.problemsWithTransactionManagement;

import com.nuwan.config.dataAccess.transactionManagement.problemsWithTransactionManagement.BookstoreConfiguration;
import com.nuwan.model.dataAccess.transactionManagement.problemsWithTransactionManagement.BookShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/dataAccess/transactionManagement/problemsWithTransactionManagement")
public class ProblemsWithTransactionManagementController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String problemsWithTransactionManagement() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookstoreConfiguration.class);

        BookShop bookShop = context.getBean(BookShop.class);
        bookShop.purchase("0001", "user1");
        return "";
    }

}