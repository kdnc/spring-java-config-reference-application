package com.nuwan.dao.mysqlSamples.sqlStatementSyntax.dataDefinitionStatements;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class UsingViewsToSimplifyTableAccessDao extends JdbcDaoSupport {

    public void runSampleUsingViewsToSimplifyTableAccess() throws IOException{
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);

        BufferedReader in = new BufferedReader(new FileReader("/springCoreTasks/dependencies/autoWiringCollaborators/autoWiringWithNameAttribute/beans.xml"));
        LineNumberReader fileReader = new LineNumberReader(in);
        String query = JdbcTestUtils.readScript(fileReader);
        System.out.println(query);
    }
}
