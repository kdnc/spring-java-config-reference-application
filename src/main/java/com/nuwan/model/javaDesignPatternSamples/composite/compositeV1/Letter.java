package com.nuwan.model.javaDesignPatternSamples.composite.compositeV1;

public class Letter extends LetterComposite {

	private char c;

	public Letter(char c) {
		this.c = c;
	}

	@Override
	protected void printThisBefore() {
		System.out.print(c);
	}

	@Override
	protected void printThisAfter() {
		// nop
	}

}
