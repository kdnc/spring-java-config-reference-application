package com.nuwan.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

  /**
   * Serve the main page
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
    return "home";
  }

    @RequestMapping(value = "spring-rest/spring-rest", method = RequestMethod.GET)
    public String restExamples(){
        return "rest/examples/home";
    }

    @RequestMapping(value = "data-persistence-orm-transactions/orm/hibernate-xml-mapping", method = RequestMethod.GET)
    public String hibernateXmlExamples(){
        return "hibernate/xml/home";
    }


    @RequestMapping(value = "data-persistence-orm-transactions/orm/hibernate-annotation", method = RequestMethod.GET)
    public String hibernateAnnotationExamples(){
        return "hibernate/annotation/home";
    }

}
