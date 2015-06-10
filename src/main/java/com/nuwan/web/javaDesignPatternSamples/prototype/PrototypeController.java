package com.nuwan.web.javaDesignPatternSamples.prototype;

import com.nuwan.model.javaDesignPatternSamples.builder.builderV1.*;
import com.nuwan.model.javaDesignPatternSamples.prototype.prototypeV1.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/javaDesignPatternSamples/prototype/")
public class PrototypeController {

    List<String> outputArray;

    /**
     *
     * In Prototype we have a factory class (HeroFactoryImpl) producing objects by
     * cloning existing ones. In this example the factory's prototype objects are
     * given as constructor parameters.
     *
     */
    @RequestMapping(value = "prototypeV1", method = RequestMethod.GET)
    @ResponseBody
    public List<String> prototypeV1() {
        outputArray = new ArrayList<>();

        HeroFactory factory;
        Mage mage;
        Warlord warlord;
        Beast beast;

        factory = new HeroFactoryImpl(new ElfMage(), new ElfWarlord(),
                new ElfBeast());
        mage = factory.createMage();
        warlord = factory.createWarlord();
        beast = factory.createBeast();
        System.out.println(mage);
        outputArray.add(mage.toString());
        System.out.println(warlord);
        outputArray.add(warlord.toString());
        System.out.println(beast);
        outputArray.add(beast.toString());

        factory = new HeroFactoryImpl(new OrcMage(), new OrcWarlord(),
                new OrcBeast());
        mage = factory.createMage();
        warlord = factory.createWarlord();
        beast = factory.createBeast();
        System.out.println(mage);
        outputArray.add(mage.toString());
        System.out.println(warlord);
        outputArray.add(warlord.toString());
        System.out.println(beast);
        outputArray.add(beast.toString());

        return outputArray;
    }

}