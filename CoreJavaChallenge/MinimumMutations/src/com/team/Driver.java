package com.team;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) throws Exception {
		
		//assign startGs, endGs, and geneBank
		
		
		List<String> geneBankOne = new ArrayList<String>(); 
		geneBankOne.add("AACCGGTA"); 
		geneBankOne.add("AACCGCTA"); 
		geneBankOne.add("AAACGGTA"); 
		
		//instantiate MinMutations
		
		
		//MinMutations myMinMutations = new MinMutations("AACCGGTT", "AAACGGTA",geneBankOne);
		
		//test for equal start and end gene strings 
		String geneStringOne = "AAAAAAAA"; 
		System.out.println(geneStringOne.equals(geneStringOne));
		
		MinMutations myMinMutations = new MinMutations(geneStringOne,geneStringOne,geneBankOne);

		
		
		//run getShortestPath
	
		String startGs = "AACCGGTT";
		
		int result = myMinMutations.getShortestPath(0); 
		System.out.println(result);
		
	}
	
}
