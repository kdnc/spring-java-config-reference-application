package com.nuwan.web.restExamples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestHomeController {

    @RequestMapping(value = "rest/examples", method = RequestMethod.GET)
    public String home(){
        return "rest/examples/home";
    }

}
