package com.challenge.mutant.controller;

import com.challenge.mutant.exception.entity.NotMutantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.mutant.adapter.PersonAdapter;
import com.challenge.mutant.service.MutantService;
import com.challenge.mutant.view.PersonView;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/mutant", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class MutantController {
	
	@Autowired
	private MutantService mutantService;
	
	@PostMapping
    public void isAMutant(@Valid @RequestBody PersonView personaView) throws NotMutantException {
		if (!this.mutantService.isAMutant(PersonAdapter.adaptToDomain(personaView))) {
			throw new NotMutantException();
		}
    }
}