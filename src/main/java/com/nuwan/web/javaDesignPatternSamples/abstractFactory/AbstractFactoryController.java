package com.nuwan.web.javaDesignPatternSamples.abstractFactory;

import com.nuwan.config.mysqlSamples.MySQLSamplesConfiguration;
import com.nuwan.dao.mysqlSamples.sqlStatementSyntax.dataDefinitionStatements.UsingViewsToSimplifyTableAccessDao;
import com.nuwan.model.javaDesignPatternSamples.abstractFactory.abstractFactoryV1.*;
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
@RequestMapping(value = "/javaDesignPatternSamples/abstractFactory/")
public class AbstractFactoryController {

    List<String> outputArray;

    @RequestMapping(value = "abstractFactoryV1", method = RequestMethod.GET)
    @ResponseBody
    public List<String> abstractFactoryV1() {
        outputArray = new ArrayList<>();
        createKingdom(new ElfKingdomFactory());
        createKingdom(new OrcKingdomFactory());
        return outputArray;
    }

    public void createKingdom(KingdomFactory factory) {
        King king = factory.createKing();
        Castle castle = factory.createCastle();
        Army army = factory.createArmy();
        outputArray.add("The kingdom was created.");
        System.out.println("The kingdom was created.");
        outputArray.add(king.toString());
        System.out.println(king);
        outputArray.add(castle.toString());
        System.out.println(castle);
        outputArray.add(army.toString());
        System.out.println(army);
    }

}