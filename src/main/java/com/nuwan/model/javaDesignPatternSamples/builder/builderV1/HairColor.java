package com.nuwan.model.javaDesignPatternSamples.builder.builderV1;

public enum HairColor {

	WHITE, BLOND, RED, BROWN, BLACK;

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
