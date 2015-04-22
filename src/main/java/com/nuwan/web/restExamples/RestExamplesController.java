package com.nuwan.web.restExamples;

import com.nuwan.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "rest/examples/greetings")
public class RestExamplesController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Greeting> findAllGreetings(){
        List<Greeting> greetings = new ArrayList<>();
        greetings.add(new Greeting("Greeting 1"));
        greetings.add(new Greeting("Greeting 2"));
        greetings.add(new Greeting("Greeting 3"));

        return greetings;
    }

}
