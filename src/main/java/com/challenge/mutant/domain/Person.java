package com.challenge.mutant.domain;

public class Person {
	
	private Dna dna;
	
	public Person(Dna dna) {
		this.dna = dna;
	}

	public Dna getDna() {
		return dna;
	}

	public void setDna(Dna dna) {
		this.dna = dna;
	}
}