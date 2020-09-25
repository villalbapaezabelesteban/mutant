package com.challenge.mutant.service.impl;

import org.springframework.stereotype.Service;

import com.challenge.mutant.domain.Person;
import com.challenge.mutant.filter.MutantFilter;
import com.challenge.mutant.service.MutantService;

@Service("mutantService")
public class MutantServiceImpl implements MutantService {
	
	@Override
	public Boolean isAMutant(Person person) {
		String[] secuences = person.getDna().getSecuences().toArray(String[]::new);
		return MutantFilter.isMutant(secuences);
	}
}