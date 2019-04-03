package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5656_2 {
	//구슬은 N번  H*W
	//벽돌 1~9 상하좌우 벽돌의 숫자 -1만큼 제거
	//남은 벽돌의 갯수
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int min=0;
	static int aaa=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int W=Integer.parseInt(st.nextToken());
			int H=Integer.parseInt(st.nextToken());
			int[][] map=new int[H][W];
			for (int j = 0; j <H; j++) {
				st=new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < W; j2++) {
					map[j][j2]=Integer.parseInt(st.nextToken());
				}
			}
			
			min=Integer.MAX_VALUE;
			dfs(N,map);
			System.out.println("#"+i+" "+min);
		}
	}
	static void dfs(int n,int[][] map) {
		if(n==0) {
			//aaa++;
			int count=0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j]!=0) {
						count++;
					}
				}
			}
//			System.out.println(aaa);
//				for (int i = 0; i < map.length; i++) {
//					for (int j = 0; j < map[i].length; j++) {
//						System.out.print(map[i][j]);
//					}
//					System.out.println();
//				}
//				System.out.println();
			if(count<min) {
				min=count;
			}
			return;
		}
		
		for (int i = 0; i < map[0].length; i++) {
			if(n>0) {
				n--;
				int[][] tmp=new int[map.length][map[0].length];
				for (int j = 0; j < tmp.length; j++) {
					tmp[j]=map[j].clone();
				}
				dfs(n,breakBlock(i,map));
				map=tmp;
				n++;
			}
		}
		
	}

	static int[][] breakBlock(int n,int[][] map) {
		Queue<int[]> queue=new LinkedList<>();
		for (int i = 0; i < map.length; i++) {
			if(map[i][n]!=0) {
				queue.add(new int[] {i,n});
				break;
			}
		}
		while(!queue.isEmpty()) {
			int[] now=queue.poll();
			for (int i = 1; i <map[now[0]][now[1]]; i++) {
				for (int j = 0; j < 4; j++) {
					if(now[0]+i*dx[j]<0||now[1]+i*dy[j]<0||now[0]+i*dx[j]>=map.length||now[1]+i*dy[j]>=map[0].length) {
						
					}else {
						queue.add(new int[] {now[0]+i*dx[j],now[1]+i*dy[j]});
					}
				}
			}
			map[now[0]][now[1]]=0;
		}
		for (int i = map.length - 2; i >= 0; i--) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 0)
					continue;

				int a = map[i][j];
				int temp = i;
				map[i][j] = 0;
				while (true) {
					if (temp + 1 >= map.length || map[temp + 1][j] != 0)
						break;
					temp++;
				}
				map[temp][j] = a;
			}
		}
//		for (int i = 0; i < map[0].length; i++) {
//			int bottom=0;
//			for (int j = map.length-1; j >=0 ; j--) {
//				if(map[j][i]==0) {
//					bottom++;
//				}else if(bottom>0) {
//					map[bottom][i]=map[j][i];
//					map[j][i]=0;
//					bottom=0;
//				}else {
//					bottom=0;
//				}
//			}
//		}	
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		//System.out.println();
		return map;
	}

}
/*
21

1
2 9 10
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
1 1 0 0 1 0 0 0 0
1 1 0 1 1 1 0 1 0
1 1 0 1 1 1 0 1 0
1 1 1 1 1 1 1 1 0
1 1 3 1 6 1 1 1 1
1 1 1 1 1 1 1 1 1

 */
