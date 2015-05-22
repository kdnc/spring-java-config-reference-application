package com.nuwan.dao.mysqlSamples.sqlStatementSyntax.dataDefinitionStatements;

import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.sql.DataSource;
import java.io.*;
import java.util.List;
import java.util.Map;

public class UsingViewsToSimplifyTableAccessDao extends JdbcDaoSupport {

    public void prepareDatabaseTables(Resource resource) throws IOException{
//        BufferedReader in = new BufferedReader(new InputStreamReader(resource.getInputStream()));
//        LineNumberReader fileReader = new LineNumberReader(in);
//        String query = JdbcTestUtils.readScript(fileReader);
//        System.out.println(query);
//        getJdbcTemplate().execute(query);
        JdbcTestUtils.executeSqlScript(getJdbcTemplate(), resource, true);
    }

    public List<Map<String,Object>> selectWithoutViews() throws IOException{
        String sql = "SELECT\n" +
                "DATE_FORMAT(t,'%M %e, %Y') AS date_sent,\n" +
                "CONCAT(srcuser,'@',srchost) AS sender,\n" +
                "CONCAT(dstuser,'@',dsthost) AS recipient,\n" +
                "size FROM mail;";
        return getJdbcTemplate().queryForList(sql);
    }

    public void createView() {
        String sql = "DROP VIEW IF EXISTS mail_view";
        getJdbcTemplate().execute(sql);

        sql = "CREATE VIEW mail_view AS\n" +
                "SELECT\n" +
                "DATE_FORMAT(t,'%M %e, %Y') AS date_sent,\n" +
                "CONCAT(srcuser,'@',srchost) AS sender,\n" +
                "CONCAT(dstuser,'@',dsthost) AS recipient,\n" +
                "size FROM mail;";
        getJdbcTemplate().execute(sql);
    }

    public List<Map<String, Object>> selectWithViews() {
        String sql = "SELECT date_sent, sender, size FROM mail_view\n" +
                "WHERE size > 100000 ORDER BY size;";
        return getJdbcTemplate().queryForList(sql);
    }
}
