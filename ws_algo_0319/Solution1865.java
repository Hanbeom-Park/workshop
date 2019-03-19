package com.ssafy.algo;

import java.util.Scanner;

public class Solution1865 {
	//주어진 일이 성공활 확률 최대값
	static int[][] map;
	static boolean[] visit;
	static double max;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 1; i <=T; i++) {
			int N=sc.nextInt();
			map=new int[N][N];
			visit=new boolean[N];
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					map[j][j2]=sc.nextInt();
				}
			}
			//한번 선택한 일은 선택불가.
			//최대 신장?
			//확률은 곱할수록 작아진다.
			max=0;
			dfs(0,100);
			System.out.printf("#%d %.6f\n",i,max);
		}
	}
	static void dfs(int n,double now) {
		if(n==map.length) {
			if(now>max) {
				max=now;
			}
			return;
		}
		for (int i = 0; i < map.length; i++) {
			if(now*map[n][i]/100>max&&!visit[i]) {
				visit[i]=true;
				dfs(n+1,now*map[n][i]/100);
				visit[i]=false;
			}
		}
	}

}
