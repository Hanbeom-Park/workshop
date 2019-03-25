package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2458 {
	//자신의 키가 몇번째인지 알 수 있는 학생 수
	//자기보다 작은지 큰지 다 알아야함
	//모든 점이 자기 자신과 연결되어 있어야한다. 같은 방향으로 
	//
	static boolean[] check;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String ss[];
		ss=br.readLine().split(" ");
		N=Integer.parseInt(ss[0]);
		int M=Integer.parseInt(ss[1]);
		boolean[][] map1=new boolean[N+1][N+1];//가는 방향 
		boolean[][] map2=new boolean[N+1][N+1];//들어오는 방향
		
		for (int i = 0; i < M; i++) {
			ss=br.readLine().split(" ");
			int x=Integer.parseInt(ss[0]);
			int y=Integer.parseInt(ss[1]);
			map1[x][y]=true;
			map2[y][x]=true;
		}
		int count=0;
		for (int i = 1; i <=N; i++) {
			check=new boolean[N+1];
			check[i]=true;
			dfs(i,map1);
			dfs(i,map2);
			
			if (isVisited()) {
				count++;
			}
		}
		System.out.println(count);
	}
	static void dfs(int n,boolean[][] map) {
		for (int i = 1; i <=N; i++) {
			if(!check[i]&&map[n][i]) {
				check[i]=true;
				dfs(i,map);
			}
		}
	}
	static boolean isVisited() {
		for (int i = 1; i <=N; i++) {
			if(!check[i]) {
				return false;
			}
		}
		return true;
	}
}
