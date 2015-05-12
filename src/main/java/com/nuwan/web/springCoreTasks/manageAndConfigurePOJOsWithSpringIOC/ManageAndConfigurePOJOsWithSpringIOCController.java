package com.nuwan.web.springCoreTasks.manageAndConfigurePOJOsWithSpringIOC;

import com.nuwan.model.CourseV1;
import com.nuwan.model.SequenceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/spring-core-tasks/manage-and-configure-pojos-with-spring-ioc")
public class ManageAndConfigurePOJOsWithSpringIOCController {

    @RequestMapping(value = "property-setting-method-1", method = RequestMethod.GET)
    @ResponseBody
    public String propertySettingMethod1() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");
        return generator.getSequence();
    }

    @RequestMapping(value = "property-setting-method-2", method = RequestMethod.GET)
    @ResponseBody
    public String propertySettingMethod2() {
        ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
        SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator2");
        return generator.getSequence();
    }
}