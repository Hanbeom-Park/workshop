package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1681 {

	//출발지는 1번
	//다 거친 후 돌아와야한다.
	//최단거리?
	static int[][] map;
	static int N,min;
	static boolean[] visit;
	static ArrayList<Integer> check= new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N+1][N+1];
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		min=Integer.MAX_VALUE;
		for (int i = 2; i <=N; i++) {
			if(map[1][i]!=0) {
				visit=new boolean[N+1];
				visit[1]=true;
				visit[i]=true;
				check.add(i);
				dfs(i,map[1][i]);
			}
		}
		System.out.println(min);
		//
	}
	static void dfs(int n,int tot) {
		if(Allvisit()) {
			if(map[n][1]!=0) {
				tot=tot+map[n][1];
			}else {
				return;
			}
			//System.out.println(tot);
			if(tot<min) {
				min=tot;
				//System.out.println(check);
			}
			return;
		}
		
		for (int i = 1; i <=N; i++) {
			if(!visit[i]&&map[n][i]!=0) {
				visit[i]=true;
				if(tot+map[n][i]<min) {
					//check.add(i);
					dfs(i,tot+map[n][i]);
					//Integer aa=i;
					//check.remove(aa);
				}
				visit[i]=false;
			}
		}
	}
	static boolean Allvisit() {
		for (int i = 1; i <=N; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		return true;
	}
}
