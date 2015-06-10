package com.nuwan.model.javaDesignPatternSamples.prototype.prototypeV1;

public abstract class Prototype implements Cloneable {

	@Override
	public abstract Object clone() throws CloneNotSupportedException;

}
