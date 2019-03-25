package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main1077 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int W=sc.nextInt();
		int[][] gem=new int[N][2];//0무게 1가치
		int[] max=new int[W+1];
		for (int i = 0; i < N; i++) {
			gem[i][0]=sc.nextInt();
			gem[i][1]=sc.nextInt();
		}
		for (int i = 1; i <= W; i++) {
			max[i]=max[i-1];
			for (int j = 0; j <N; j++) {
				if(i>=gem[j][0]) {
					if(max[i]<max[i-gem[j][0]]+gem[j][1]) {
						max[i]=max[i-gem[j][0]]+gem[j][1];
					}
				}
			}
		}
		//System.out.println(Arrays.toString(max));
		System.out.println(max[W]);
	}

}
/*
3 12
3 6 
4 3 
5 5


 */

