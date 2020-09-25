package com.challenge.mutant.domain;

import java.util.List;

public class Dna {
	
	private List<String> secuences;
	
	public Dna(List<String> secuences) {
		this.secuences = secuences;
	}
	
	public List<String> getSecuences() {
		return secuences;
	}
	
	public void setSecuences(List<String> secuences) {
		this.secuences = secuences;
	}
}