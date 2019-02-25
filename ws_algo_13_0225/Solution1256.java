package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Solution1256 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <=T; i++) {
			int index=Integer.parseInt(br.readLine().trim());
			String ss=br.readLine().trim();
			String[] s=new String[ss.length()];
			for (int j = 0; j < s.length; j++) {
				s[j]=ss.substring(j,ss.length());
				//System.out.println(s[j]);
			}
			Arrays.sort(s);
			System.out.println("#"+i+" "+s[index-1]);
		}
	}

}
/*
1
4
monster

*/