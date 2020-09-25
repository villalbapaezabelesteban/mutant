package com.challenge.mutant.adapter;

import java.util.ArrayList;
import java.util.List;

import com.challenge.mutant.domain.Dna;
import com.challenge.mutant.domain.Person;
import com.challenge.mutant.view.PersonView;

public class PersonAdapter {

	public static PersonView adaptToView(Person person) {
        PersonView personView = new PersonView();
        personView.setDna(person.getDna().getSecuences());
        return personView;
    }

    public static Person adaptToDomain(PersonView personaView) {
    	Dna dna = DnaAdapter.adaptToDomain(personaView);
        Person person = new Person(dna);
        return person;
    }

    public static List<PersonView> adaptToView(List<Person> personas) {
        List<PersonView> views = new ArrayList<>();
        personas.stream().forEach((p) ->
        {
            views.add(PersonAdapter.adaptToView(p));
        });
        return views;
    }
}