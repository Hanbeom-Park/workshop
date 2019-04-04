package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5644 {
	//범위 겹치면 둘중하나 선택해서 접속 가능
	//사용자가 같이 접속한 경우, 충전양을 균등하게 분배
	//최대 충전량 구하기
	static int A;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] dx= {0,-1,0,1,0};//X 상 우 하 좌
		int[] dy= {0,0,1,0,-1};
		
		for (int i = 1; i <=T; i++) {
			st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			A=Integer.parseInt(st.nextToken());
			boolean[][][] map=new boolean[A][11][11];
			int[] user1= {1,1};
			int[] user2= {10,10};
			int[][] Move=new int[2][M];
			for (int j = 0; j <2; j++) {
				st=new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 <M; j2++) {
					Move[j][j2]=Integer.parseInt(st.nextToken());
				}
			}
			int[] power=new int[A];
			for (int j = 0; j < A; j++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int C=Integer.parseInt(st.nextToken());
				int P=Integer.parseInt(st.nextToken());
				power[j]=P;
				for (int j2 = 1; j2 <=10; j2++) {
					for (int k = 1; k <=10; k++) {
						if(Math.abs(j2-x)+Math.abs(k-y)<=C) {
							map[j][k][j2]=true;
						}
					}
				}
			}
//			for (int j = 0; j <A; j++) {
//				for (int j2 = 1; j2 <=10; j2++) {
//					for (int k = 1; k <=10; k++) {
//						System.out.print(map[j][j2][k]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
			int tot=0;
			//겹치는거는 
			for (int j = -1; j < M; j++) {
				
				boolean[] check1=new boolean[A];
				boolean[] check2=new boolean[A];
				if(j==-1) {
					
				}else {
					user1[0]=user1[0]+dx[Move[0][j]];
					user1[1]=user1[1]+dy[Move[0][j]];
					user2[0]=user2[0]+dx[Move[1][j]];
					user2[1]=user2[1]+dy[Move[1][j]];
				}
				for (int k = 0; k <A; k++) {
					if(map[k][user1[0]][user1[1]]==true) {
						check1[k]=true;
					}
					if(map[k][user2[0]][user2[1]]==true) {
						check2[k]=true;
					}
				}
				int max=0;
				//System.out.println(Arrays.toString(check1));
				//System.out.println(Arrays.toString(check2));
				for (int k = 0; k < check1.length; k++) {
					for (int k2 = 0; k2 < check2.length; k2++) {
						if(k==k2&&(check1[k]&&check2[k2])) {
							if(power[k]>max) {
								max=power[k];
							}
						}else {
							int tmp=0;
							if(check1[k]) {
								tmp=tmp+power[k];
							}
							if(check2[k2]) {
								tmp=tmp+power[k2];
							}
							
							if(tmp>max) {
								max=tmp;
							}
						}
						
					}	
							
				}
				//System.out.println(max);
				tot=tot+max;
				
			}
			System.out.println("#"+i+" "+tot);
		}
	}
	//dfs
	//check1[]={true,false,;lfa,df;}
	//check2[]={asdasd,adsas,asd,a}


}
/*
 * 
1
20 3
2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
4 4 1 100
7 10 3 40
6 3 2 70

*/