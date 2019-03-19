package com.ssafy.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

public class Solution3074_2 {
	//심사대가 N개 심사시간 tk? 최소한의 시간을 구하는 프로그램
	//긴사람을 먼저 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 1; i <=T; i++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			long[] t=new long[N];
			long max=0;
			for (int j = 0; j < t.length; j++) {
				t[j]=sc.nextInt();
				if(t[j]>max) {
					max=t[j];
				}
			}
			//시간 정해서 찾기
			//1~10^9
			//
			long left=0;
			long right=(long)M*(long)max;
			long res=right;
			while(left<=right) {
				long mid=(left+right)/2;
				long sum=0;
				for (int j = 0; j <N; j++) {
					sum=sum+mid/t[j];
				}
				if(M<=sum){
					if(mid<res) {
						res=mid;
					}
					right=mid-1;
				}else {
					left=mid+1;
				}
			}
			System.out.println("#"+i+" "+res);
		}
	}

}
