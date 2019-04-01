package com.challenge;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MutationsTest extends MutationsLogic {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner user = new Scanner(System.in);
		System.out.println("Input a gene string.");
		String first = user.nextLine();
		if (first.length() > 8) {
			System.out.println("Please input a string of 8 charcters.");
		}
		System.out.println("Input a gene string you want to mutate too.");	
		String last = user.nextLine();
		if (last.length() > 8) {
			System.out.println("Please input a string of 8 character.");
		}
		user.close();
		System.out.println("THe Number of mutations is" + mutation(first, last));

	}
	
}
