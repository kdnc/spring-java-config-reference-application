package com.nuwan.web.springCoreTasks.manageAndConfigurePOJOsWithSpringIOC;

import com.nuwan.model.SequenceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/spring-core-tasks/use-pojo-references-auto-wiring-and-imports-to-interact-with-other-pojos")
public class UsePOJOReferencesAutoWiringAndImportsToInteractWithOtherPOJOsController {

//    @RequestMapping(value = "property-setting-method-1", method = RequestMethod.GET)
//    @ResponseBody
//    public String propertySettingMethod1() {
//        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
//        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");
//        return generator.getSequence();
//    }

}