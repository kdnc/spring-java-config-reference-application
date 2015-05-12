package com.nuwan.web.springCoreTasks.manageAndConfigurePOJOsWithSpringIOC;

import com.nuwan.model.SequenceGenerator;
import com.nuwan.model.SequenceGeneratorV2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/spring-core-tasks/create-pojos-by-invoking-a-constructor")
public class CreatePOJOsByInvokingAConstructorController {

    @RequestMapping(value = "constructor-setting-no-ambiguity", method = RequestMethod.GET)
    @ResponseBody
    public String constructorSettingNoAmbiguity() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGeneratorUsingConstructor1");
        return generator.getSequence();
    }

    @RequestMapping(value = "constructor-setting-ambiguity-resolving", method = RequestMethod.GET)
    @ResponseBody
    public String constructorSettingAmbiguityResolving() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGeneratorUsingConstructor2");
        return generator.getSequence();
    }

    @RequestMapping(value = "constructor-setting-ambiguity-resolving-2", method = RequestMethod.GET)
    @ResponseBody
    public String constructorSettingAmbiguityResolving2() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGeneratorV2 generator = (SequenceGeneratorV2) context.getBean("sequenceGeneratorUsingConstructor3");
        return generator.getSequence();
    }
}