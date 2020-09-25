package com.challenge.mutant.service;

import com.challenge.mutant.domain.Person;

public interface MutantService {

	Boolean containAnyInvalidCharacters(Person person);
	Boolean isAMutant(Person person);
}