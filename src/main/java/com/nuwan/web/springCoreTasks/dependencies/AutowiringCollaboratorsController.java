package com.nuwan.web.springCoreTasks.dependencies;

import com.nuwan.model.springCoreTasks.dependencies.autoWiringCollaborators.autoWiringWithPrimaryAttribute.SequenceGenerator;
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
    public String autoWiringWithPrimaryAttribute() {
        ApplicationContext context = new GenericXmlApplicationContext("/springCoreTasks/dependencies/autoWiringCollaborators/autoWiringWithPrimaryAttribute/beans.xml");
        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGeneratorAutoWiringWithPrimaryAttribute");
        return generator.getSequence();
    }

    @RequestMapping(value = "auto-wiring-with-name-attribute", method = RequestMethod.GET)
    @ResponseBody
    public String autoWiringWithNameAttribute() {
        ApplicationContext context = new GenericXmlApplicationContext("/springCoreTasks/dependencies/autoWiringCollaborators/autoWiringWithNameAttribute/beans.xml");
        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGeneratorAutoWiringWithNameAttribute");
        return generator.getSequence();
    }

}