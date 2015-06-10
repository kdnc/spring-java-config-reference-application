package com.nuwan.model.javaDesignPatternSamples.prototype.prototypeV1;

public abstract class Mage extends Prototype {

	@Override
	public abstract Mage clone() throws CloneNotSupportedException;

}
