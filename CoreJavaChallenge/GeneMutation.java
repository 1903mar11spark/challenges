package com.edgar.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class GeneMutation {

	public static void main(String[] args) {
		String[] bank = {"AACCGGTT", "AACCGCTA", "AAACGGTA"};
		gene( "AACCGGTT ", "AAACGGTA" , bank);
		
	}
	
	public static int gene (String start, String end, String[] bank) {
		start = start.toUpperCase();
		end =  end.toUpperCase();
		List<Integer> position = new ArrayList<Integer>(); 
		int totalMutation = 0;
		int counter = 0;
		
		if (start == end) {
			return 0;
		}
		
		/*if((start.length() != 8) && (end.length() != 8)) {
			
			return -2;
		}*/
		
		for(int i=0; i<start.length()-1; i++) {
			if (start.charAt(i) == end.charAt(i)) {
				continue;
			}else {
				position.add(i);
				String temp = start.substring(0,(i-1))+end.charAt(i)+start.substring((i+1));
				counter++;
				if(Arrays.asList(bank).contains(temp)) {
					String mid = temp;
					totalMutation++;
						if (mid == end) {
							System.out.println(totalMutation);
							return totalMutation;
						} else {
							if (position.size() == counter) {
								System.out.println(position);
								return -1;
								} else {
									continue;
									}
								}
			}
		}
		
		//String temp = position.get(y)
		//for (int y=0; y<position.size(); y++) {
			//if (positon.get(y) == ) {
				
			}
	return totalMutation;		//bank cont
	}
	
}
