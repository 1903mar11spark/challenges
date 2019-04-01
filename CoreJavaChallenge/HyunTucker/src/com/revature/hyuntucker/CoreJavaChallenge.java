package com.revature.hyuntucker;

import java.util.*;

public class CoreJavaChallenge {

	
	public static String loopingStuff(String start, String compare) {
		int counter = 0;
		char[] first  = start.toLowerCase().toCharArray();
		char[] second = compare.toLowerCase().toCharArray();

		int minLength = Math.min(first.length, second.length);

		for(int i = 0; i < minLength; i++) {
			
		        if (first[i] == second[i]) {
		            counter++;   
		            
		            
		        }
		}
		
		
		
		if (counter == 7) {
			return compare;
		
		}
		else {
		
			return "No";
		}
		
	}
	
	
	
	
	public static int coreJavaChallenges(String start, String[] bank, String end) {
		
		String test2=end.replaceAll("[^a,g,t,c]", "");
		String test=start.replaceAll("[^a,g,t,c]", "");
		if(test.length()!=8||test2.length()!=8) {
			return -1;
		}
		
		if(start.equals(end)) {
			return 0;
		}
		else {
		
		
		int retrun=0;
		String comparing = start;
		ArrayList<String> banks = new ArrayList<String>(Arrays.asList(bank));
		banks.add(end);
	
		
		for (int i = 0 ; i < banks.size(); i ++) {
		
			
			loopingStuff(comparing, banks.get(i));
			
			if (loopingStuff(comparing, banks.get(i)) != "No") {
				comparing = loopingStuff(comparing, banks.get(i));
				banks.remove(i);
				retrun++;
				i=-1;
			
			}
		}
		if(comparing.equals(end)) {
			
			return retrun;}
		else return -1; 
		}
	}
	
	
	
	
	













	public static void main(String[] args) {
		String[] banking = {"aaaaaaag",  "aaaaaagg","aaaaaggg","aaaagggg"};
		
		
		//CoreJavaChallenges("acgtacgt", banking, "agtcagtc");
		coreJavaChallenges("aaaaaaaa", banking, "aaaggggg");
		System.out.println(coreJavaChallenges("aaaaaaaa", banking, "aaaggggg"));
		
	}
}
