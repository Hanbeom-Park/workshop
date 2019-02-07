package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution6719 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 1; i <=T; i++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			int[] data=new int[N];
			for (int j = 0; j < N; j++) {
				data[j]=sc.nextInt();
			}
			Arrays.sort(data);
			//
			double A=0;
//			for (int j =N-1 ; j >=N-K; j--) {
//				A=(A+data[j])/2;
//			}			
			for (int j =N-K; j <N; j++) {
				A=(A+data[j])/2;
			}
			System.out.printf("#%d %.6f\n",i,A);
		}
	}

}
