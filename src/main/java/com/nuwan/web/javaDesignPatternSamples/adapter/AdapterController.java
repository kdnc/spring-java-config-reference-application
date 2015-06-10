package com.nuwan.web.javaDesignPatternSamples.adapter;

import com.nuwan.model.javaDesignPatternSamples.adapter.adapterV1.Engineer;
import com.nuwan.model.javaDesignPatternSamples.adapter.adapterV1.GnomeEngineeringManager;
import com.nuwan.model.javaDesignPatternSamples.factoryMethod.factoryMethodV1.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/javaDesignPatternSamples/adapter/")
public class AdapterController {

    /**
     *
     * There are two variations of the Adapter pattern: The class adapter implements
     * the adaptee's interface whereas the object adapter uses composition to
     * contain the adaptee in the adapter object. This example uses the object
     * adapter approach.
     *
     * The Adapter (GnomeEngineer) converts the interface of the target class
     * (GoblinGlider) into a suitable one expected by the client
     * (GnomeEngineeringManager).
     *
     */
    @RequestMapping(value = "adapterV1", method = RequestMethod.GET)
    @ResponseBody
    public String factoryMethodV1() {
        Engineer manager = new GnomeEngineeringManager();
        manager.operateDevice();
        return "success";
    }

}