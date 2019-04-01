package com.revature.mutchallenge;

public class Driver {
	
	public static void main(String[] args) {
		String a = "ACCCGGTT";
		String b = "AAACGGTT";
		String[] aB = {"AACCGGTA", "AACCGCTA", "ACACGGTA", "AACCGCTA"};
		System.out.println(utility(a,b,aB));
		
		
	}
	
	public static int utility(String start, String end, String[] aB) {
		String s = start;	
		int count = 0;
		
		for(int i = 0; i < start.length(); i++) {
			
			if(s.charAt(i) == end.charAt(i)) {
				System.out.println(0);
			} else { 
				count++;
				s = aB[i];
				int j=i;
				for (j=i;j<=7;j++) {
					if (s.charAt(j)!= end.charAt(j)) {
						
					} else { 
						if(j>=7) {
						s=aB[i];
						count++;
						
						System.out.println(s);
					    }
				   }
				
				
				
			}
			
		}
		
		}
	
		return count;
	}
	
	

}

//if(s.length() != 8 || end.length() != 8) {
//	System.out.println("not a valid gene"); 
////public static int utility(String start, String end, String[] aB) {
//String s = start;
//
//int loopCount = 0;
//
// for(int i=0; i<=aB.length; i++) {
//       
//       for(int j=0;j<aB[i].length();j++) {
//           
//           String currentEntry = aB[i];
//           
//           if (s.charAt(j) == currentEntry.charAt(j)) {
//               //just continue to the next iteration of j.
//           } else {
//        	   if(loopCount==0) {
//        		   loopCount++;
//        	   }else {
//        		   System.out.println("Here");
//           }
//
//           }
//
//
//       }
// }
//return loopCount;
