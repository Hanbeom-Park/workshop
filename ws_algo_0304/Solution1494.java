package com.ssafy.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution1494 {
	//벡터를 모두 합친값이 가장 작은 경우를 구한다.
	static long min;
	static int[][] dis;
	static int[][] worm;
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 1; i <=T; i++) {
			N=sc.nextInt();
			worm=new int[N][2];
			for (int j = 0; j < worm.length; j++) {
				worm[j][0]=sc.nextInt();
				worm[j][1]=sc.nextInt();
			}
			
			min=Long.MAX_VALUE;
			dfs(0,0,0,0);
			//System.out.println(Arrays.deepToString(worm));
			//System.out.println(Arrays.deepToString(dis));
			System.out.println("#"+i+" "+min);
		}
		
	}
	static void dfs(int d,int c,long x,long y) {
		if(d==worm.length&&c==N/2) {
			if(min>x*x+y*y) {
				min=x*x+y*y;
			}
			return;
			
		}else if(d==worm.length) {
			return;
		}
		dfs(d+1,c,x+worm[d][0],y+worm[d][1]);
		dfs(d+1,c+1,x-worm[d][0],y-worm[d][1]);
		
	}

}
/*
1
10
-4 -5
-71 -62
-20 93
70 39
-26 -55
-46 81
52 -56
42 -22
-24 -97
-6 -79

1
2
100000 100000
-100000 -100000

*/