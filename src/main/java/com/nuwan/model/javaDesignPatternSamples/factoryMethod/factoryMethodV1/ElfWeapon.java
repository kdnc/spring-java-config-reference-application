package com.nuwan.model.javaDesignPatternSamples.factoryMethod.factoryMethodV1;

public class ElfWeapon implements Weapon {

	private WeaponType weaponType;

	public ElfWeapon(WeaponType weaponType) {
		this.weaponType = weaponType;
	}

	@Override
	public String toString() {
		return "Elven " + weaponType;
	}

}
