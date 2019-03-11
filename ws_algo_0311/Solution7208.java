package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7208 {
	//최소 변경된 색의 수 출력
	//인접한 국가가 서로 같은 색일 경우 다른색으로 바꿔줘야함.어떤색으로 바꿀지?
	//색은 최대 4개
	//인접한 국가가 많은애가 바꾸는게 효과적이다.
	//빈도수 측정
	//색이 많은애들중에 빈도수 높은거 먼저?
	//주변에 없는 색 중 빈도수 적은 색으로 바꾼다.
	//DP dfs?
	static int[][] map;
	static int[] color;
	//static boolean[] check;//색 확인용
	//static boolean[] visit;//방문 확인용
	static int N,min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			//나라수
			N=Integer.parseInt(br.readLine().trim());
			color=new int[N];
			st=new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < color.length; j++) {
				color[j]=Integer.parseInt(st.nextToken());
			}
			map=new int[N][N];
			for (int j = 0; j < map.length; j++) {
				st=new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 < map.length; j2++) {
					map[j][j2]=Integer.parseInt(st.nextToken());
				}
			}
			//visit=new boolean[N];
			min=Integer.MAX_VALUE;
			boolean[] visit=new boolean[N];
			visit[0]=true;
			//System.out.println(Arrays.toString(color));
			dfs(0,0,new int[N],visit);
			System.out.println("#"+i+" "+min);
		}
	}
	static void dfs(int index,int count,int[] check,boolean[] visit) {
		//check=new boolean[N+1];
//		if(index==N) {
//			if(count<min) {
//				min=count;
//			}
//			return;
//		}
		
		if(Allvisit(visit)) {
			//System.out.println("결과"+Arrays.toString(check)+" "+count+"aA "+index);
			for (int i = 0; i <check.length-1; i++) {
				//System.out.println(check[i]+" "+color[N-1]);
				if(map[N-1][i]==1&&check[i]==color[N-1]) {
					if((count+1)<min) {
						min=count+1;
						//System.out.println(min+"Aa");
						return;
					}
					return;
				}
			}
			if(count<min) {
				min=count;
				//System.out.println(min+"BB");
				return;
			}
		}
		//System.out.println(Arrays.toString(check)+" "+count+"aA "+index);
		for (int i = 0; i <N; i++) {
			if(!visit[i]&&map[index][i]==1) {
				con:for (int j = 1; j <=4; j++) {
					for (int j2 = 0; j2 <N; j2++) {
						if(map[index][j2]==1&&check[j2]==j) {
							continue con;
						}
					}
					check[index]=j;
					visit[i]=true;
					if(color[index]==j) {
						//System.out.println(index+"같은색"+"dfs 돌림"+j);
						dfs(i,count,check,visit);
					}else {
						//System.out.println(index+"dfs 돌림"+j);
						dfs(i,count+1,check,visit);
					}
					check[index]=0;
					visit[i]=false;
					
				}
			}
		}
		//System.out.println(count);
//		if(Allvisit(visit)) {
//			System.out.println(Arrays.toString(check));
//		}
//		if(Allvisit(visit)&&count<min) {
//			min=count;
//		}
	}
	static boolean Allvisit(boolean[] visit) {
		for (int i = 0; i < visit.length; i++) {
			if(!visit[i]) {
				return false;
			}
		}
		return true;
	}
}

/*
1
4
1 2 3 4
0 1 1 1
1 0 1 1
1 1 0 1
1 1 1 0

1
4
1 1 2 2
0 1 0 0
1 0 1 0
0 1 0 1
0 0 1 0

1
8
1 2 3 4 4 3 2 1
0 1 0 1 0 1 0 1
1 0 1 1 0 1 0 1
1 1 0 0 1 1 1 1
1 1 1 0 1 1 1 1
1 1 1 1 0 1 1 1
1 1 1 1 1 0 1 1
1 1 1 1 1 1 0 1
1 1 1 1 1 1 1 0

*/
