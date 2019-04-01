package com.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 


public class MutationsLogic {
	
public static int mutation(String first, String last) throws FileNotFoundException {
	List<String> thebank = new ArrayList<String>();
	File file = new File("src//com//challenge//Bank.txt"); 
	Scanner sc = new Scanner(file);
	while (sc.hasNextLine()) {
		
	thebank.add(sc.nextLine());
	}
	sc.close();
	//thebank.add("AACCGGTA");
	//thebank.add("AAACGGTT");
	//thebank.add("AAACGGTT");
    //thebank.add("AACCGCTA");
    //thebank.add("AAACGGTA");
	int mutationCount = 0;
	StringBuilder replace = new StringBuilder (first);
	String temp = "";
	if(first.equals(last)) {
		mutationCount = 0;
	} else {
	for(int i = 0; i <first.length(); i++) {
		if (first.charAt(i) != last.charAt(i)) {
			replace.setCharAt(i, (last.charAt(i)));
			temp = replace.toString();
			boolean check = thebank.contains(temp);
			if (check) {
			mutationCount++;
			} else {
			mutationCount = -1;
			}
			
		}
	}
	}
	System.out.println(replace);
	return mutationCount;
}
}
