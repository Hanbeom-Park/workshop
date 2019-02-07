package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6782 {
	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= T; i++) {
			long N = Long.parseLong((br.readLine().trim()));
			long count=0;
			
			while(N>2) {
					long tmp=(long) Math.sqrt(N);
					if(tmp!=Math.sqrt(N)){
						while(N>(tmp)*(tmp)){
							tmp++;
						}
						count=count+(tmp*tmp)-N+1;
						N=(long) Math.sqrt(tmp*tmp);
						
					}else {
						N=(long) Math.sqrt(N);
						count++;
					}
		
			}
			System.out.println("#" + i + " " + count);
			

			
		}

	}


}