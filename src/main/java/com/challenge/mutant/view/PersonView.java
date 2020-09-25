package com.challenge.mutant.view;

import com.challenge.mutant.domain.Person;

import java.util.List;

public class PersonView {
	
	List<String> dna;
	
	public PersonView() {
		super();
	}

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}
}