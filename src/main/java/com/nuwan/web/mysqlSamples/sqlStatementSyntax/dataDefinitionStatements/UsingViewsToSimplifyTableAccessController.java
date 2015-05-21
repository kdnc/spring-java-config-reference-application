package com.nuwan.web.mysqlSamples.sqlStatementSyntax.dataDefinitionStatements;

import com.nuwan.config.mysqlSamples.MySQLSamplesConfiguration;
import com.nuwan.dao.mysqlSamples.sqlStatementSyntax.dataDefinitionStatements.UsingViewsToSimplifyTableAccessDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/mysqlSamples/sqlStatementSyntax/dataDefinitionStatements/usingViewsToSimplifyTableAccess")
public class UsingViewsToSimplifyTableAccessController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<String> usingViewsToSimplifyTableAccess() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MySQLSamplesConfiguration.class);

        DataSource dataSource = context.getBean(DataSource.class);
        UsingViewsToSimplifyTableAccessDao dao = new UsingViewsToSimplifyTableAccessDao();
        dao.setDataSource(dataSource);
        try{
            dao.runSampleUsingViewsToSimplifyTableAccess();
        } catch(Exception ex){
            System.out.println("error");
        }
        return null;
    }

}