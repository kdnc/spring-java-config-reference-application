package com.nuwan.model.javaDesignPatternSamples.factoryMethod.factoryMethodV1;

/**
 * 
 * The interface containing method for producing objects.
 * 
 */
public interface Blacksmith {

	Weapon manufactureWeapon(WeaponType weaponType);

}
