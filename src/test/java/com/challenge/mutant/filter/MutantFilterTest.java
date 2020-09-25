package com.challenge.mutant.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MutantFilterTest {
	
	private static final int NUMBER_OF_MATCHING_SEQUENCES_REQUIRED_FOR_MUTANT_DNA = 3;

	public static final String[] MUTANT_DNA = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	public static final String[] NOT_MUTANT_DNA = {"ATGCAA","TAGTGC","TTGTGT","AGAAGG","CACTTA","TCACAG"};
	public static final String[] MUTANT_DNA_WITH_ONLY_HORIZONTAL_MATCHES = {"ATGGGG","CAGTGC","TTTTGT","AGAAAA","CCCTTA","TCACTG"};
	public static final String[] MUTANT_DNA_WITH_ONLY_VERTICAL_MATCHES = {"ATGGAG","CAGTGC","CGTTGA","CGATAA","CCCTTA","TCACTA"};
	public static final String[] MUTANT_DNA_WITH_ONLY_DIAGONAL_MATCHES = {"ATGGAG","CAGTGC","CGATGG","TGTAAA","CCCATA","TCACTA"};
		
	private String[] mutantDNA;
	
	@BeforeAll
	public void before() {
		this.resetMutantDna();
	}
	
	@Test
	public void testIsMutantDNAWithOnlyHorizontalMatches() {
		this.giveToMeAMutantDNAWithOnlyHorizontalMatches();
		
		int cantVertically = MutantFilter.getNumberOfSequencesVertically(this.mutantDNA);
		int cantDiagonally = MutantFilter.getNumberOfSequencesDiagonally(this.mutantDNA);
		
		assertTrue(MutantFilter.isMutant(this.mutantDNA));
		assertTrue(cantVertically < NUMBER_OF_MATCHING_SEQUENCES_REQUIRED_FOR_MUTANT_DNA);
		assertTrue(cantDiagonally < NUMBER_OF_MATCHING_SEQUENCES_REQUIRED_FOR_MUTANT_DNA);
	}
	
	@Test
	public void testIsMutantDNAWithVerticalMatchesOnly() {
		this.giveToMeAMutantDNAWithOnlyVerticalMatches();
		
		int cantHorizontally = MutantFilter.getNumberOfSequencesHorizontally(this.mutantDNA);
		int cantDiagonally = MutantFilter.getNumberOfSequencesDiagonally(this.mutantDNA);
		
		assertTrue(MutantFilter.isMutant(this.mutantDNA));		
		assertTrue(cantHorizontally < NUMBER_OF_MATCHING_SEQUENCES_REQUIRED_FOR_MUTANT_DNA);
		assertTrue(cantDiagonally < NUMBER_OF_MATCHING_SEQUENCES_REQUIRED_FOR_MUTANT_DNA);
	}
	
	@Test
	public void testIsMutantDNAWithDiagonalMatchesOnly() {
		this.giveToMeAMutantDNAWithOnlyDiagonalMatches();
		
		int cantHorizontally = MutantFilter.getNumberOfSequencesHorizontally(this.mutantDNA);
		int cantVertically = MutantFilter.getNumberOfSequencesVertically(this.mutantDNA);
		int cantDiagonally = MutantFilter.getNumberOfSequencesDiagonally(this.mutantDNA);
		
		assertEquals(1, cantDiagonally);
		
		assertTrue(cantHorizontally < NUMBER_OF_MATCHING_SEQUENCES_REQUIRED_FOR_MUTANT_DNA);
		assertTrue(cantVertically < NUMBER_OF_MATCHING_SEQUENCES_REQUIRED_FOR_MUTANT_DNA);
	}
	
	@Test
	public void testIsNotMutant() {
		this.giveToMeANotMutantDNA();
		
		assertFalse(MutantFilter.isMutant(this.mutantDNA));
	}
	
	@Test
	public void testIsMutant() {
		this.giveToMeAMutantDNA();
		
		assertTrue(MutantFilter.isMutant(this.mutantDNA));
	}
	
	private void resetMutantDna() {
		this.mutantDNA = null;
	}
	
	private void giveToMeAMutantDNA() {
		this.mutantDNA = MUTANT_DNA;
	}
	
	private void giveToMeANotMutantDNA() {
		this.mutantDNA = NOT_MUTANT_DNA;
	}
	
	private void giveToMeAMutantDNAWithOnlyHorizontalMatches() {
		this.mutantDNA = MUTANT_DNA_WITH_ONLY_HORIZONTAL_MATCHES;
	}
	
	private void giveToMeAMutantDNAWithOnlyVerticalMatches() {
		this.mutantDNA = MUTANT_DNA_WITH_ONLY_VERTICAL_MATCHES;
	}
	
	private void giveToMeAMutantDNAWithOnlyDiagonalMatches() {
		this.mutantDNA = MUTANT_DNA_WITH_ONLY_DIAGONAL_MATCHES;
	}
}