package com.nuwan.model.javaDesignPatternSamples.builder.builderV1;

public enum Profession {

	WARRIOR, THIEF, MAGE, PRIEST;

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
