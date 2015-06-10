package com.nuwan.model.javaDesignPatternSamples.prototype.prototypeV1;

/**
 * 
 * Interface for the factory class.
 * 
 */
public interface HeroFactory {

	Mage createMage();

	Warlord createWarlord();

	Beast createBeast();

}
