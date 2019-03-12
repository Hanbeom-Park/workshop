package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7250_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		int[] x_dir= {-1,1,0,0};//상하좌우
		int[] y_dir= {0,0,-1,1};
		
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			st=new StringTokenizer(br.readLine().trim());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			//A 그냥 이동 가능  W 크기 줄이면 통과  F,X는 못지나감
			//K 유지시간 
			//F W와 X에는 불이 안붙고 한칸씩 증가한다.
			//악당은 A와 F를 통과 가능
			//최단 거리로 탈출한 수를 출력. 악당이 먼저 또는 동시 도착시 -1
			//
			char[][] map=new char[N][M];
			for (int j = 0; j < map.length; j++) {
				map[j]=br.readLine().trim().toCharArray();
			}
			Point S=new Point(0,0,0,0);
			Point A=new Point(0,0,0,0);
			boolean[][] enemy=new boolean[N][M];
			
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map[j].length; j2++) {
					if(map[j][j2]=='S') {
						S=new Point(j,j2,-1,0);
						//scot[j][j2]=true;
					}
					if(map[j][j2]=='V') {
						A=new Point(j,j2,0,0);
					}
				}
			}
			//갈 수 있는 방향으로 다 집어 넣기?
			
			//줄인 상태에서는 최대 K만큼 이동 가능
			//S E
			
			Queue<Point> aa=new LinkedList<>();
			aa.add(A);
			int e_count=Integer.MAX_VALUE;
			//int[][] enemy=new int[N][M];
			while(!aa.isEmpty()) {
				//System.out.println("AA");
				Point now=aa.poll();
				if(map[now.x][now.y]=='E') {
					e_count=now.count;
					break;
				}
				enemy[now.x][now.y]=true;
				for (int j = 0; j < 4; j++) {
					if(now.x+x_dir[j]<0||now.x+x_dir[j]>=N||now.y+y_dir[j]<0||now.y+y_dir[j]>=M) {
						
					}else {
						int nx=now.x+x_dir[j];
						int ny=now.y+y_dir[j];
						if(!enemy[nx][ny]&&(map[nx][ny]=='A'||map[nx][ny]=='F'||map[nx][ny]=='E')) {
							if(map[nx][ny]!=0) {
								aa.add(new Point(nx,ny,-1,now.count+1));								
							}
						}	
					}
				}
			}
			
			aa.clear();
			//System.out.println(e_count);
			aa.add(S);
			
			int min_count=Integer.MAX_VALUE;
			ArrayList<Integer> res=new ArrayList<>();
			int[][][] scot=new int[N][M][2];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					scot[j][j2][0]=-2;
					scot[j][j2][1]=-2;
				}
			}
			exit:while(!aa.isEmpty()) {

				ArrayList<Point> bbb=new ArrayList<>();
				while(!aa.isEmpty()) {
					bbb.add(aa.poll());
				}
				//System.out.println(now.x+" "+now.y+" "+now.count+"AAA");
				
				for (int j3 = 0; j3 < bbb.size(); j3++) {
					Point now=bbb.get(j3);
					if(scot[now.x][now.y][0]==now.k&&scot[now.x][now.y][1]!=now.count) {
						continue;
					}
					scot[now.x][now.y][0]=now.k;
					scot[now.x][now.y][1]=now.count;
					//System.out.println(now.x+" "+now.y+" "+now.count);	
					
					//scot[now.x][now.y]=true;
					if(map[now.x][now.y]=='E') {
						min_count=now.count;
						break exit;
					}
//					for (int j = 0; j < enemy.length; j++) {
//						for (int j2 = 0; j2 < enemy.length; j2++) {
//							//System.out.print(map[j][j2]+" ");
//							//System.out.print(scot[j][j2]+" ");
//						}
//						//System.out.println();
//					}
//					//System.out.println();
					for (int j = 0; j < 4; j++) {
						if(now.x+x_dir[j]<0||now.x+x_dir[j]>=N||now.y+y_dir[j]<0||now.y+y_dir[j]>=M) {
							
						}else {
							int nx=now.x+x_dir[j];
							int ny=now.y+y_dir[j];
							//System.out.println(nx+" "+ny+" "+now.count+"Aaa"+map[nx][ny]+"asfdB"+now.k);	
							if((map[nx][ny]=='A'||map[nx][ny]=='E'||map[nx][ny]=='S'||map[nx][ny]=='V')) {
								aa.add(new Point(nx,ny,-1,now.count+1));
								//System.out.println(nx+" "+ny+" "+now.count+"Aaa");	
								
							}
							if(map[nx][ny]=='W') {
								if(now.k==-1) {
									now.k=K;
								}
								if(now.k>=1) {
									aa.add(new Point(nx,ny,now.k-1,now.count+1));
									//System.out.println(nx+" "+ny+" "+now.count+"BBB");	
										
								}
							}						
						}
					}
//					for (int j = 0; j < enemy.length; j++) {
//						for (int j2 = 0; j2 < enemy.length; j2++) {
//							System.out.print(map[j][j2]+" ");
//							//System.out.print(scot[j][j2]+" ");
//						}
//						System.out.println();
//					}
//					System.out.println();
				}
				
				ArrayList<Point> fire=new ArrayList<>();
				for (int j = 0; j < map.length; j++) {
					for (int j2 = 0; j2 < map[j].length; j2++) {
						if(map[j][j2]=='F') {
							fire.add(new Point(j,j2,0,0));
						}
					}
				}
				for (int j = 0; j < fire.size(); j++) {
					Point bul=fire.get(j);
					for (int j2 = 0; j2 <4; j2++) {
						if(bul.x+x_dir[j2]<0||bul.x+x_dir[j2]>=N||bul.y+y_dir[j2]<0||bul.y+y_dir[j2]>=M) {
							
						}else {
							if(map[bul.x+x_dir[j2]][bul.y+y_dir[j2]]=='A'||map[bul.x+x_dir[j2]][bul.y+y_dir[j2]]=='V'||map[bul.x+x_dir[j2]][bul.y+y_dir[j2]]=='S') {
								map[bul.x+x_dir[j2]][bul.y+y_dir[j2]]='F';
							}
						}
					}
				}
			}
			res.sort(null);
			if(min_count>e_count) {
				System.out.println("#"+i+" -1");
			}else if(min_count==Integer.MAX_VALUE){
				System.out.println("#"+i+" -1");
			}else {
				System.out.println("#"+i+" "+min_count);
				
			}
		}
	}
	static class Point{
		int x;
		int y;
		int k;
		int count;
		Point(int x,int y,int k,int c){
			this.x=x;
			this.y=y;
			this.k=k;
			this.count=c;
		}
	}
}
/*
1
5 5 2
SAAAV
AAWXA
WXAFA
WAAAF
AEAAA

1
5 5 3
WWXSX
WWXWX
WWXWX
EWWWA
XXXXX

*/