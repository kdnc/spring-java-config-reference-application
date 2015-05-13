package com.nuwan.web.springCoreTasks.dependencies;

import com.nuwan.model.SequenceGeneratorV3;
import com.nuwan.model.SequenceGeneratorV4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/spring-core-tasks/dependencies/autowiring-collaborators")
public class AutowiringCollaboratorsController {

    @RequestMapping(value = "auto-wiring-with-primary-attribute", method = RequestMethod.GET)
    @ResponseBody
    public String setterBasedDependencyInjection() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGeneratorV4 generator = (SequenceGeneratorV4) context.getBean("sequenceGeneratorAutoWiringWithPrimaryAttribute");
        return generator.getSequence();
    }

}