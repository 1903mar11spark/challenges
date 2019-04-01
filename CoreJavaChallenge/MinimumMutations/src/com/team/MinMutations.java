package com.team;

import java.util.ArrayList;
import java.util.List;

public class MinMutations {
	
	//instance variables 
	String startGs; 
	String endGs; 
	List<String> geneBank = new ArrayList<>();
	
	int currentGsIndexInList; 
	int nextGsInPathIndex;
	int numOfRecursiveCalls; 
	
	//constructors
	public MinMutations() {
		super();
		this.startGs = startGs;
		this.endGs = endGs;
		this.geneBank = geneBank;
	} 
	
	public MinMutations(String startGs, String endGs, List<String> geneBank) {
		super();
		this.startGs = startGs;
		this.endGs = endGs;
		this.geneBank = geneBank;
	} 
	
	// ------------methods-------------- 
	public int getShortestPath(int nextGsInPathIndex) throws Exception {
		//logic here
		/*
		try {
			startGs.equals(endGs); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Start and end gene string must be different"); 
		}
		*/
		
		geneBank.add(0, startGs); 
		
		if (startGs.equals(endGs)) {
			System.out.println("Start and end gene string must be different");
		}
		
		int innerLoopChangeCounter = 0; 
		
		//
		for (int i = 0; i < geneBank.size(); i++) {
			
			 
			
			for (int j = 0; j < 7; j ++) {
				if (!(geneBank.get(nextGsInPathIndex).charAt(j) == geneBank.get(i).charAt(j))) {
					innerLoopChangeCounter = innerLoopChangeCounter + 1; 
					
					nextGsInPathIndex = 0;
					
					if (innerLoopChangeCounter == 1 ) {
						
						nextGsInPathIndex = i;
					}
				}
			}
			
			if (innerLoopChangeCounter > 1) {
				// then this is not the next gs in the path 
				
			} else if (innerLoopChangeCounter < 1){
				// this is a duplicate gs chain
			} else {
				// inner LoopCounter is equal to one and we have found the next gs sequence in the path
				
			}
			
		}
		
		return nextGsInPathIndex; 
	}
	
	
	

}
