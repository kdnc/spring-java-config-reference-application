package com.nuwan.model.javaDesignPatternSamples.adapter.adapterV1;

/**
 * 
 * Device class (adaptee in the pattern).
 * 
 */
public class GoblinGlider {

	public void attachGlider() {
		System.out.println("Glider attached.");
	}

	public void gainSpeed() {
		System.out.println("Gaining speed.");
	}

	public void takeOff() {
		System.out.println("Lift-off!");
	}
}
