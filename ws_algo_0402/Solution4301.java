package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4301 {
	//오른쪽이 왼쪽보다 크면 안된다
	//
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int[] dx= {-2,2,0,0};
		int[] dy= {0,0,-2,2};
		
		for (int i = 1; i <=T; i++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			int count=0;
			boolean[][] map=new boolean[N][M];
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map[j].length; j2++) {
					boolean check=true;
					for (int k = 0; k < 4; k++) {
						if(j+dx[k]<0||j2+dy[k]<0||j+dx[k]>=N||j2+dy[k]>=M) {
							
						}
						else if(map[j+dx[k]][j2+dy[k]]) {
							check=false;
						}
						
					}
					if(check) {
						map[j][j2]=true;
						count++;
					}
				}
			}
			System.out.println("#"+i+" "+count);
		}
		
	}

}
/*
1
3 3

*/