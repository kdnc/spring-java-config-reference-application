package com.nuwan.web.springCoreTasks.dependencies;

import com.nuwan.model.SequenceGenerator;
import com.nuwan.model.SequenceGeneratorV2;
import com.nuwan.model.SequenceGeneratorV3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/spring-core-tasks/dependencies/dependency-injection")
public class DependencyInjectionController {

    @RequestMapping(value = "setter-based-dependency-injection", method = RequestMethod.GET)
    @ResponseBody
    public String setterBasedDependencyInjection() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGeneratorV3 generator = (SequenceGeneratorV3) context.getBean("sequenceGeneratorSetterBasedDependencyInjection");
        return generator.getSequence();
    }

    @RequestMapping(value = "setter-based-anonymous-dependency-injection", method = RequestMethod.GET)
    @ResponseBody
    public String setterBasedAnonymousDependencyInjection() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGeneratorV3 generator = (SequenceGeneratorV3) context.getBean("sequenceGeneratorSetterBasedAnonymousDependencyInjection");
        return generator.getSequence();
    }

    @RequestMapping(value = "constructor-based-dependency-injection", method = RequestMethod.GET)
    @ResponseBody
    public String constructorBasedDependencyInjection() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGeneratorV3 generator = (SequenceGeneratorV3) context.getBean("sequenceGeneratorConstructorBasedDependencyInjection");
        return generator.getSequence();
    }

    @RequestMapping(value = "constructor-based-dependency-injection-2", method = RequestMethod.GET)
    @ResponseBody
    public String constructorBasedDependencyInjection2() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGeneratorV3 generator = (SequenceGeneratorV3) context.getBean("sequenceGeneratorConstructorBasedDependencyInjection2");
        return generator.getSequence();
    }

    @RequestMapping(value = "constructor-based-anonymous-dependency-injection", method = RequestMethod.GET)
    @ResponseBody
    public String constructorBasedAnonymousDependencyInjection() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGeneratorV3 generator = (SequenceGeneratorV3) context.getBean("sequenceGeneratorConstructorBasedAnonymousDependencyInjection");
        return generator.getSequence();
    }
}