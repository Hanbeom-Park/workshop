package edu.ssafy.algo;

import java.util.Scanner;

public class Solution1247 {
	static int N;
	static int count=0;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 1; i <=T; i++) {
			N=sc.nextInt();
			int[] company={sc.nextInt(),sc.nextInt()};
			int[] home= {sc.nextInt(),sc.nextInt()};
			int[][] location=new int[N+2][2];
			for (int j = 1; j < N+1; j++) {
				location[j][0]=sc.nextInt();
				location[j][1]=sc.nextInt();
			}
			location[0]=company;
			location[N+1]=home;
			
			search(location,1);
			//System.out.println(min);
			System.out.println("#"+i+" "+min);
			min=Integer.MAX_VALUE;
		}
	}
	static void search(int[][] cus,int d) {
		if(d==cus.length-2) {
			int x=cus[0][0],y=cus[0][1];
			int move_x=0;
			int move_y=0;
			for (int i = 1; i < cus.length; i++) {
				move_x=move_x+Math.abs(x-cus[i][0]);
				move_y=move_y+Math.abs(y-cus[i][1]);
				x=cus[i][0];
				y=cus[i][1];
			}
			if(move_x+move_y<min) {
				min=move_x+move_y;
			}
//			for (int i = 0; i < cus.length; i++) {
//				System.out.print(cus[i][0]+" "+cus[i][1]+" | ");
//			}
//			System.out.println();
			count++;
			return;
		}
		for (int i = d; i < cus.length-1; i++) {
			int[] temp;
			temp=cus[d];
			cus[d]=cus[i];
			cus[i]=temp;
			search(cus,d+1);
			temp=cus[d];
			cus[d]=cus[i];
			cus[i]=temp;
		}
	}

}
/*
10
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
7
22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83
8
30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63
9
3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92
10
39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36
10
26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96
10
46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63
10
94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3
10
32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86

1
3
0 0 100 100 70 40 50 20 90 70

1
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20

*/