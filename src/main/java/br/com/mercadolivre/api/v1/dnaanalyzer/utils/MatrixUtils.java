package br.com.mercadolivre.api.v1.dnaanalyzer.utils;

public class MatrixUtils {

	// This method runs through the matrix elements in order looking for horizontal, vertical and diagonal sequences
	public static boolean hasAnySequenceInMatrix(String[] stringArray) {
		
		int arraySize = stringArray.length;
		char[][] bidimentionalArray = stringArrayToBidimentionalCharArray(stringArray, arraySize);
		
		int auxColumn = 0;
		
		for(int auxLine = 0; auxLine < arraySize; auxLine++) {
			char charToCompare = bidimentionalArray[auxLine][auxColumn];
 			int matchs = 0;
			
			if((arraySize - auxLine) >= 4) {
				
				//horizontal verification
				for(int auxIndex = auxLine + 1; auxIndex < arraySize; auxIndex++) {
					if(matchs == 3) 
						return true;
					
					if(charToCompare == bidimentionalArray[auxIndex][auxColumn])
						matchs++;
					else {
						matchs = 0;
						break;
					}
				}
				
				if(matchs == 3) 
					return true;
			}
			
			//vertical verification
			if((arraySize - auxColumn) >= 4) {
				
				for(int auxIndex = auxColumn + 1; auxIndex < arraySize; auxIndex++) {
					
					if(matchs == 3) 
						return true;
					
					if(charToCompare == bidimentionalArray[auxLine][auxIndex])
						matchs++;
					else {
						matchs = 0;
						break;
					}
				}
				
				if(matchs == 3) 
					return true;
			}
			
			//right down diagonal verification
			if((arraySize - auxLine) >= 4 && (arraySize - auxColumn) >= 4) {
				int auxColumnForDiagonal = auxColumn;
				for(int auxIndex = auxLine + 1; auxIndex < arraySize; auxIndex++) {
					if(matchs == 3) 
						return true;
					
					if(charToCompare == bidimentionalArray[auxIndex][++auxColumnForDiagonal])
						matchs++;
					else {
						matchs = 0;
						break;
					}
				}
				
				if(matchs == 3) 
					return true;
			}
			
			//left down diagonal verification
			if(auxLine >= 3 && (arraySize - auxColumn) >= 4) {
				int auxColumnForDiagonal = auxColumn;
				for(int auxIndex = auxLine - 1; auxIndex >= 0; auxIndex--) {
					if(matchs == 3) 
						return true;
					
					if(charToCompare == bidimentionalArray[auxIndex][++auxColumnForDiagonal])
						matchs++;
					else {
						matchs = 0;
						break;
					}
				}
				if(matchs == 3) 
					return true;
			}
			
			//go to the next column
			if(auxColumn + 1 < arraySize && (auxLine + 1) == arraySize) {
				auxColumn++;
				auxLine = -1;
			}
		}
		
		return false;
	}
	
	private static char[][] stringArrayToBidimentionalCharArray(String[] stringArray, int arraySize) {
		char[][] bidimentionalArray = new char[arraySize][arraySize];
		
		int auxColumn = 0;
		int auxLine;
		for(String auxArray : stringArray) {
			auxLine = 0;
			for(int auxIndex = 0; auxIndex < auxArray.length(); auxIndex++)
				bidimentionalArray[auxLine++][auxColumn] = auxArray.charAt(auxIndex);
			auxColumn++;
		}
		
		return bidimentionalArray;
	}
	
	public static boolean isAValidMatrix(String[] matrix) {
		
		int columnSize = matrix.length;
		if(columnSize < 4)
			return false;
		else {
			for(String auxMatrix : matrix) {
				int lineSize = auxMatrix.length();
				
				if(lineSize != columnSize) 
					return false;
				
				if(!auxMatrix.matches("^[ATCG]+$"))
					return false;
			}
		}
		return true;
	}	
}
