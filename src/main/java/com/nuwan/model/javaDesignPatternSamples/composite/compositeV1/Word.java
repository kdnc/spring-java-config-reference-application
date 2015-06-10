package com.nuwan.model.javaDesignPatternSamples.composite.compositeV1;

import java.util.List;

public class Word extends LetterComposite {

	public Word(List<Letter> letters) {
		for (Letter l : letters) {
			this.add(l);
		}
	}

	@Override
	protected void printThisBefore() {
		System.out.print(" ");
	}

	@Override
	protected void printThisAfter() {
		// nop
	}

}
