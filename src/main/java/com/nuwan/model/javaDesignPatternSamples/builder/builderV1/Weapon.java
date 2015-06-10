package com.nuwan.model.javaDesignPatternSamples.builder.builderV1;

public enum Weapon {

	DAGGER, SWORD, AXE, WARHAMMER, BOW;

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
