package com.nuwan.model.javaDesignPatternSamples.prototype.prototypeV1;

public class ElfMage extends Mage {

	public ElfMage() {
	}

	public ElfMage(ElfMage mage) {
	}

	@Override
	public Mage clone() throws CloneNotSupportedException {
		return new ElfMage(this);
	}

	@Override
	public String toString() {
		return "Elven mage";
	}

}
