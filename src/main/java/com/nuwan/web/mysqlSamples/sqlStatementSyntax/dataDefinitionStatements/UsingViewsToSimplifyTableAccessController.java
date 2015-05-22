package com.nuwan.web.mysqlSamples.sqlStatementSyntax.dataDefinitionStatements;

import com.nuwan.config.mysqlSamples.MySQLSamplesConfiguration;
import com.nuwan.dao.mysqlSamples.sqlStatementSyntax.dataDefinitionStatements.UsingViewsToSimplifyTableAccessDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/mysqlSamples/sqlStatementSyntax/dataDefinitionStatements/usingViewsToSimplifyTableAccess")
public class UsingViewsToSimplifyTableAccessController {

    @RequestMapping(value = "prepareDatabaseTables", method = RequestMethod.GET)
    @ResponseBody
    public String prepareDatabase() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MySQLSamplesConfiguration.class);
        Resource resource = context.getResource("classpath:mysqlSamples/sqlStatementSyntax/dataDefinitionStatements/mail.sql");
        DataSource dataSource = context.getBean(DataSource.class);
        UsingViewsToSimplifyTableAccessDao dao = new UsingViewsToSimplifyTableAccessDao();
        dao.setDataSource(dataSource);
        try{
            dao.prepareDatabaseTables(resource);
        } catch(Exception ex){
            return ex.getMessage();
        }
        return "Prepared database tables";
    }

    @RequestMapping(value = "selectWithoutViews", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> selectWithoutViews() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MySQLSamplesConfiguration.class);
        DataSource dataSource = context.getBean(DataSource.class);
        UsingViewsToSimplifyTableAccessDao dao = new UsingViewsToSimplifyTableAccessDao();
        dao.setDataSource(dataSource);
        try{
            return dao.selectWithoutViews();
        } catch(Exception ex){
            return null;
        }
    }

    @RequestMapping(value = "createView", method = RequestMethod.GET)
    @ResponseBody
    public String createView() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MySQLSamplesConfiguration.class);
        DataSource dataSource = context.getBean(DataSource.class);
        UsingViewsToSimplifyTableAccessDao dao = new UsingViewsToSimplifyTableAccessDao();
        dao.setDataSource(dataSource);
        try{
            dao.createView();
        } catch(Exception ex){
            return ex.getMessage();
        }
        return "Successfully created view";
    }

    @RequestMapping(value = "selectWithViews", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> selectWithViews() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MySQLSamplesConfiguration.class);
        DataSource dataSource = context.getBean(DataSource.class);
        UsingViewsToSimplifyTableAccessDao dao = new UsingViewsToSimplifyTableAccessDao();
        dao.setDataSource(dataSource);
        try{
            return dao.selectWithViews();
        } catch(Exception ex){
            return null;
        }
    }
}