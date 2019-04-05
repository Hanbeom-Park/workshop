package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4366_1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 1; i <=T; i++) {
			String two=sc.next();
			String three=sc.next();
			long tmpa=0;
			for (int i1 = 0; i1 < two.length(); i1++) {
				if (two.charAt(two.length() - 1 - i1) == '1') {
					tmpa = tmpa | (1 << (i1));
				}
			}
			for (int j = 0; j < two.length(); j++) {
				long aa=tmpa ^ (1 << j); 
				long c=1;
				String bb="";
				
				while(aa!=0) {
					bb=""+aa%3+bb;
					aa=aa/3;
				}
	
				while(bb.length()!=three.length()) {
					bb="0"+bb;
				}
				int count=0;
				for (int k = 0; k < three.length(); k++) {
					if(three.charAt(k)!=bb.charAt(k)) {
						count++;
					}
				}
				if(count==1) {
					System.out.println("#"+i+" "+Long.parseLong(bb,3));
					break;
				}
			}
		}
	}

}
/*
1

*/
