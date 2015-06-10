package com.nuwan.model.javaDesignPatternSamples.prototype.prototypeV1;

public abstract class Beast extends Prototype {

	@Override
	public abstract Beast clone() throws CloneNotSupportedException;

}
