package com.nuwan.model;
import java.util.Random; 


public class NumberPrefixGeneratorV2 implements PrefixGeneratorV2 {

    public String getPrefix() {
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(100);
        return String.format("%03d", randomInt);
    }
}
