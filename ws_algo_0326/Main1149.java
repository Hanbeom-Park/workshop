package BAEKJOON;

import java.util.Scanner;

public class Main1149 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[][] map=new int[N+1][3];
		for (int i = 1; i < map.length; i++) {
			for (int j = 0; j <3; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int[][] min=new int[N+1][3];
		for (int i = 1; i <=N; i++) {
			min[i][0]=Math.min(min[i-1][1],min[i-1][2])+map[i][0];
			min[i][1]=Math.min(min[i-1][0],min[i-1][2])+map[i][1];
			min[i][2]=Math.min(min[i-1][0],min[i-1][1])+map[i][2];
		}
		System.out.println(Math.min(min[N][0], Math.min(min[N][1], min[N][2])));
	}

}
