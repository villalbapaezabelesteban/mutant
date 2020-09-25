package com.challenge.mutant.adapter;

import com.challenge.mutant.domain.Dna;
import com.challenge.mutant.view.PersonView;

public class DnaAdapter {

    public static Dna adaptToDomain(PersonView personaView) {
        return new Dna(personaView.getDna());
    }
}