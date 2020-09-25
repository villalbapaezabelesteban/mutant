package com.challenge.mutant.filter;

public class MutantFilter {
	
	public static final boolean isMutant(String[] mutanDNA) {
		return isMutant(mutanDNA, 2);
	}
	
	private static final boolean isMutant(String[] mutanDNA, int minMatchesRequired) {		
		int cantHorizontally = getNumberOfSequencesHorizontally(mutanDNA);		
		int cantVertically = getNumberOfSequencesVertically(mutanDNA);		
		int cantDiagonally = getNumberOfSequencesDiagonally(mutanDNA);		
		int total = (cantHorizontally + cantVertically + cantDiagonally);
		return total >= minMatchesRequired;
	}
	
	public static int getNumberOfSequencesHorizontally(String[] dnaSequenceMatrix) {
		return getNumberOfSequencesByMatchesRequired(dnaSequenceMatrix, 3);
	}
	
	private static int getNumberOfSequencesByMatchesRequired(String[] dnaSequenceMatrix, int matchesRequired) {
		return getNumberOfSequencesByMatchesRequiredAndPosition(dnaSequenceMatrix, matchesRequired, 0);
	}
	
	private static int getNumberOfSequencesByMatchesRequiredAndPosition(String[] dnaSequenceMatrix, int matchesRequired, int position) {
		if (position < dnaSequenceMatrix.length) {
			int cantMatches = getNumberOfSequentialMatches(dnaSequenceMatrix[position].toCharArray());
			int cant = (cantMatches >= matchesRequired) ? 1 : 0;
			return cant + getNumberOfSequencesByMatchesRequiredAndPosition(dnaSequenceMatrix, matchesRequired, (position + 1));
		}
		return 0;
	}
	
	public static final int getNumberOfSequentialMatches(char[] sequenceMatrix) {
		return getNumberOfSequentialMatchesByPosition(sequenceMatrix, 0);
	}
	
	private static int getNumberOfSequentialMatchesByPosition(char[] sequenceMatrix, int position) {		
		if (position < sequenceMatrix.length) {
			int nextPosition = (position + 1);
			
			if (nextPosition < sequenceMatrix.length) {
				int cant = (sequenceMatrix[position] == sequenceMatrix[nextPosition]) ? 1 : 0;
				return cant + getNumberOfSequentialMatchesByPosition(sequenceMatrix, nextPosition);
			}
		}
		return 0;
	}
	
	public static int getNumberOfSequencesVertically(String[] dnaSequenceMatrix) {
		return getNumberOfSequencesHorizontally(getNewMatrixByChangingRowsByColumns(dnaSequenceMatrix));
	}
	
	private static String[] getNewMatrixByChangingRowsByColumns(String[] dnaSequenceMatrix) {
		int size = dnaSequenceMatrix.length;
		
		String[] newDnaSequenceMatrix = new String[size];
		char[][] dnaSequenceMatrixAux = new char[size][size];
		
		for (int row=0; row < dnaSequenceMatrix.length; row++) {
			char[] sequenceMatrix = dnaSequenceMatrix[row].toCharArray();
						
			for (int col = 0; col < sequenceMatrix.length; col++) {				
				dnaSequenceMatrixAux[col][row] = sequenceMatrix[col];
			}
		}
		
		for (int i = 0; i < dnaSequenceMatrixAux.length; i++) {
			newDnaSequenceMatrix[i] = new String(dnaSequenceMatrixAux[i]);
		}
		
		return newDnaSequenceMatrix;
	}
	
	public static int getNumberOfSequencesDiagonally(String[] dnaSequenceMatrix) {
		return getNumberOfSequencesThatMatchDiagonallyByMatchesRequired(dnaSequenceMatrix, 3);
	}
	
	private static int getNumberOfSequencesThatMatchDiagonallyByMatchesRequired(String[] dnaSequenceMatrix, int matchesRequired) {
		StringBuilder buildSequence = new StringBuilder();
		
		for (int row=0; row < dnaSequenceMatrix.length; row++) {
			String sequence = dnaSequenceMatrix[row];
			char[] sequenceMatrix = sequence.toCharArray();
			
			buildSequence.append(sequenceMatrix[row]);
		}
		
		return getNumberOfSequencesHorizontally(new String[] { buildSequence.toString() });
	}
}