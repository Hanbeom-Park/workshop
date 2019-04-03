package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution4672 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <=T; i++) {
			//aab aba baa
			//abcabc a b c d e f aa baab cbaabc
			//3+같은거 2개면  aaa 3*2
			//6개+ 2*1
			int[] a=new int[26];
			char[] word=br.readLine().toCharArray();
			for (int j = 0; j < word.length; j++) {
				a[word[j]-'a']++;
			}
			int res=0;
			for (int j = 0; j < 26; j++) {
				res=res+a[j]*(a[j]+1)/2;
			}
			System.out.println(Arrays.toString(a));
			System.out.println("#"+i+" "+res);
		}
	}

}
/*
1
zzz

*/