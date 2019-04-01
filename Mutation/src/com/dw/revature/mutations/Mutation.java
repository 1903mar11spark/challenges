package com.dw.revature.mutations;

import java.awt.Container;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Mutation {

	public static void main(String[] args) {
		
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String [] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		System.out.println(mutationCreation(start, end, bank));
//		mutationCreation(start, end, bank);

	}

	public static int mutationCreation(String start, String end, String[] bank) {
		 if (start==null || end==null || start.length()!=end.length()) {
			 return -1;
		 }
	        int mutation = 0;
	        char[] genes = new char[]{'A', 'C', 'G', 'T'};
	        
			//for validating only alphabets
			start = start.replaceAll("[@!:()\\s-+.]+", start);
	        
			// changing string array of banks to hashet for quicker lookup.
	        HashSet<String> banksy = new HashSet<String>();
	        for (String str : bank) {
	            banksy.add(str);
	        }
	        
	        
	        if (!banksy.contains(end)) {
	        	return -1;
	        }
	        
	        if (banksy.contains(start)) {
	        	banksy.remove(start);
	        }
			// queue to store and count our mutations
	        Queue<String> dna = new LinkedList<String>();
	        dna.offer(start);
	        
			//while our queue is NOT empty, get size
	        while (!dna.isEmpty()) {
	        	
				//looping through our "dna" queue
	            int size = dna.size();
	            for (int k=0; k<size; k++) {
	            	
					//setting current to the first element in our dna queue
	                String cur = dna.poll();
	                for (int i=0; i<cur.length(); i++) {
	                    for (char c : genes) {
	                    	
	                    	//build new string out of current
	                        StringBuilder sb = new StringBuilder(cur);
	                        
	                        //set each i char to mutated gene letter
	                        sb.setCharAt(i, c);
	                        
	                        //we're counting how many mutations til the end
	                        String afterMutation = sb.toString();
	                        
	                        //we're counting how many mutations til the end
	                        if (afterMutation.equals(end)) {
	                        	return mutation+1;
	                        }
	                        
	                        //checking if hashset contains our new gene, then removing the duplicate
	                         //and then putting it in our dna queue
	                        if (banksy.contains(afterMutation)) {
	                            banksy.remove(afterMutation);
	                            dna.offer(afterMutation);
	                        }
	                    }
	                }
	            }
	            mutation++;
	        }
	        return -1;
	    }
}
