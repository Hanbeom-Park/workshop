package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3234_2 {
	//오른쪽이 왼쪽보다 크면 안된다
	//
	static boolean[] check;
	static int[] map;
	static int tot,tt;
	static boolean[] tmp;
	static int[] pow= {1,2,4,8,16,32,64,128,256,512,1024};
	static int[] fac= {0,1,2,6,24,120,720,5040,40320,362880};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();

		for (int i = 1; i <=T; i++) {
			int N=sc.nextInt();
			map=new int[N];
			tt=0;
			for (int j = 0; j <N; j++) {
				map[j]=sc.nextInt();
				tt=tt+map[j];
			}
			//순열?
			tot=0;
			check=new boolean[N];
			tmp=new boolean[N];

			dfs2(0,0,0);					

			System.out.println("#"+i+" "+tot);
			//System.out.println(count);
		}
	}
	static void dfs2(int d,int r,int l) {
		
		//System.out.println(d+" "+r+" "+l);
		if(r>l) {
			return;
		}
		if(tt/2<r) {
			return;
		}
		if(d==map.length) {
			//System.out.println("AAA");
			tot++;
			//System.out.println(r+" "+l);
			
			return;
		}//System.out.println(d);

		if(tt<=l*2) {
			int count=0;
			for (int i = 0; i < check.length; i++) {
				if(!tmp[i]) {
					count++;
				}
			}
			//System.out.println(count);

			tot=tot+(fac[count]*pow[count]);
			//System.out.println(r+" "+l);
			
			return;
		}
		for (int i = 0; i < tmp.length; i++) {
			if(!tmp[i]) {
				tmp[i]=true;
					dfs2(d+1,r+map[i],l);
					dfs2(d+1,r,l+map[i]);
				tmp[i]=false;
			}
		}
		
	}
	//N개에서 rc개의 순열
	//3개에서 2개 순열 1
	//3*2*1/1
}
/*
1
3
1 2 4

*/