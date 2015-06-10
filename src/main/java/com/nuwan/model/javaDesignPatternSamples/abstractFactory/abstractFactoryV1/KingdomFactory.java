package com.nuwan.model.javaDesignPatternSamples.abstractFactory.abstractFactoryV1;

/**
 * 
 * The factory interface.
 * 
 */
public interface KingdomFactory {

	Castle createCastle();

	King createKing();

	Army createArmy();

}
