package com.ssafy.algo;
import java.util.Scanner;

public class Solution4796 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[] mountain = new int[N];
			for (int j = 0; j < N; j++) {
				mountain[j] = sc.nextInt();
			}
			int count = 0;
			for (int j = 0; j < mountain.length; j++) {
				
				int point = j;
				int up=0;
				int down=0;
				int start=j;
				for (int k = j; k < mountain.length-1; k++) {
					if(mountain[k]>=mountain[k+1]) {
						point=k;
						break;
					}
					up++;
				}
				for (int k = point; k < mountain.length-1; k++) {
					if(mountain[k]<=mountain[k+1]) {
						point=k;
						break;
					}
					down++;
				}
				j=point-1;
				int end=point;
				count=count+up*down;
				if(start==end) {
					break;
				}
			}
			System.out.println("#" + i + " " + count);
		}
	}

}