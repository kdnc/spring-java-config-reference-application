package com.nuwan.web.javaDesignPatternSamples.builder;

import com.nuwan.model.javaDesignPatternSamples.abstractFactory.abstractFactoryV1.*;
import com.nuwan.model.javaDesignPatternSamples.builder.builderV1.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/javaDesignPatternSamples/builder/")
public class BuilderController {

    List<String> outputArray;

    /**
     *
     * This is the Builder pattern variation as described by Joshua Bloch in
     * Effective Java 2nd Edition.
     *
     * We want to build Hero objects, but its construction is complex because of the
     * many parameters needed. To aid the user we introduce HeroBuilder class.
     * HeroBuilder takes the minimum parameters to build Hero object in its
     * constructor. After that additional configuration for the Hero object can be
     * done using the fluent HeroBuilder interface. When configuration is ready the
     * build method is called to receive the final Hero object.
     *
     */
    @RequestMapping(value = "builderV1", method = RequestMethod.GET)
    @ResponseBody
    public List<String> builderV1() {
        outputArray = new ArrayList<>();

        Hero mage = new Hero.HeroBuilder(Profession.MAGE, "Riobard")
                .withHairColor(HairColor.BLACK).withWeapon(Weapon.DAGGER)
                .build();
        System.out.println(mage);
        outputArray.add(mage.toString());

        Hero warrior = new Hero.HeroBuilder(Profession.WARRIOR, "Amberjill")
                .withHairColor(HairColor.BLOND)
                .withHairType(HairType.LONG_CURLY).withArmor(Armor.CHAIN_MAIL)
                .withWeapon(Weapon.SWORD).build();
        System.out.println(warrior);
        outputArray.add(warrior.toString());

        Hero thief = new Hero.HeroBuilder(Profession.THIEF, "Desmond")
                .withHairType(HairType.BALD).withWeapon(Weapon.BOW).build();
        System.out.println(thief);
        outputArray.add(thief.toString());

        return outputArray;
    }

}