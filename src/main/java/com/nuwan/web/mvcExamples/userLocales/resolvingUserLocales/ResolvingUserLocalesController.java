package com.nuwan.web.mvcExamples.userLocales.resolvingUserLocales;

import com.nuwan.model.Greeting;
import com.nuwan.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "mvcExamples/userLocales/resovlingUserLocales")
public class ResolvingUserLocalesController {

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String showResolvingLocaleHomePage(){
        return "mvcExamples/userLocales/resolvingUserLocales/home";
    }

    @RequestMapping(value = "example", method = RequestMethod.GET)
    public String showResolvingLocaleExamplesPage(){
        return "mvcExamples/userLocales/resolvingUserLocales/localeExample";
    }
}
