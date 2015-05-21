package com.nuwan.web.mysqlSamples.sqlStatementSyntax.dataDefinitionStatements;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/mysqlSamples/sqlStatementSyntax/dataDefinitionStatements/usingViewsToSimplifyTableAccess")
public class UsingViewsToSimplifyTableAccessController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<String> usingViewsToSimplifyTableAccess() {
        return null;
    }

}