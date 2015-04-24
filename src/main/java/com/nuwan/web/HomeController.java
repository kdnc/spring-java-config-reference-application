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

    @RequestMapping(value = "rest/examples", method = RequestMethod.GET)
    public String restExamples(){
        return "rest/examples/home";
    }

    @RequestMapping(value = "hibernate/xml/examples", method = RequestMethod.GET)
    public String hibernateXmlExamples(){
        return "hibernate/xml/home";
    }


    @RequestMapping(value = "hibernate/annotation/examples", method = RequestMethod.GET)
    public String hibernateAnnotationExamples(){
        return "hibernate/annotation/home";
    }

}
