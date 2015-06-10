package com.nuwan.web.javaDesignPatternSamples.factoryMethod;

import com.nuwan.model.javaDesignPatternSamples.factoryMethod.factoryMethodV1.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/javaDesignPatternSamples/factoryMethod/")
public class FactoryMethodController {

    List<String> outputArray;

    /**
     *
     * In Factory Method we have an interface (Blacksmith) with a method for
     * creating objects (manufactureWeapon). The concrete subclasses (OrcBlacksmith,
     * ElfBlacksmith) then override the method to produce objects of their liking.
     *
     */
    @RequestMapping(value = "factoryMethodV1", method = RequestMethod.GET)
    @ResponseBody
    public List<String> factoryMethodV1() {
        outputArray = new ArrayList<>();

        Blacksmith blacksmith;
        Weapon weapon;

        blacksmith = new OrcBlacksmith();
        weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        System.out.println(weapon);
        outputArray.add(weapon.toString());
        weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
        System.out.println(weapon);
        outputArray.add(weapon.toString());

        blacksmith = new ElfBlacksmith();
        weapon = blacksmith.manufactureWeapon(WeaponType.SHORT_SWORD);
        System.out.println(weapon);
        outputArray.add(weapon.toString());
        weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        System.out.println(weapon);
        outputArray.add(weapon.toString());

        return outputArray;
    }

}