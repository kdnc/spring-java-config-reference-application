package com.nuwan.model.javaDesignPatternSamples.prototype.prototypeV1;

public abstract class Warlord extends Prototype {

	@Override
	public abstract Warlord clone() throws CloneNotSupportedException;

}
