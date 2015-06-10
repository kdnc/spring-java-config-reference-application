package com.nuwan.web.javaDesignPatternSamples.composite;

import com.nuwan.model.javaDesignPatternSamples.composite.compositeV1.LetterComposite;
import com.nuwan.model.javaDesignPatternSamples.composite.compositeV1.Messenger;
import com.nuwan.model.javaDesignPatternSamples.composite.compositeV1.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/javaDesignPatternSamples/composite/")
public class CompositeController {

    List<String> outputArray;

    /**
     *
     * With Composite we can treat tree hierarchies of objects with uniform
     * interface (LetterComposite). In this example we have sentences composed of
     * words composed of letters.
     *
     */
    @RequestMapping(value = "compositeV1", method = RequestMethod.GET)
    @ResponseBody
    public List<String> compositeV1() {
        outputArray = new ArrayList<>();

        System.out.println("Message from the orcs: ");
        outputArray.add("Message from the orcs: ");

        LetterComposite orcMessage = new Messenger().messageFromOrcs();
        orcMessage.print();

        System.out.println("\n");

        System.out.println("Message from the elves: ");
        outputArray.add("Message from the elves: ");

        LetterComposite elfMessage = new Messenger().messageFromElves();
        elfMessage.print();

        return outputArray;
    }

}