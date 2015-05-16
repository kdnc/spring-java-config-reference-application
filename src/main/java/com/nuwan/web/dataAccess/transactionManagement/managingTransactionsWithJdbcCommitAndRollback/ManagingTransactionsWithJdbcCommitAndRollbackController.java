package com.nuwan.web.dataAccess.transactionManagement.managingTransactionsWithJdbcCommitAndRollback;

import com.nuwan.config.dataAccess.transactionManagement.managingTransactionsWithJdbcCommitAndRollback.BookstoreConfiguration2;
import com.nuwan.model.dataAccess.transactionManagement.managingTransactionsWithJdbcCommitAndRollback.BookShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/dataAccess/transactionManagement/managingTransactionsWithJdbcCommitAndRollback")
public class ManagingTransactionsWithJdbcCommitAndRollbackController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String managingTransactionsWithJdbcCommitAndRollback() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BookstoreConfiguration2.class);

        BookShop bookShop = context.getBean(BookShop.class);
        bookShop.purchase("0001", "user1");
        return "";
    }

}