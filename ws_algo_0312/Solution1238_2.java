package com.ssafy.algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1238_2{
	static boolean[][] map;
	static boolean[] check;
	static int N;
	static int max_count;
	static int max;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for (int i = 1; i <=10; i++) {
			N=sc.nextInt();
			int start=sc.nextInt();
			map=new boolean[101][101];
			check=new boolean[101];
			for (int j = 0; j < N/2; j++) {
					map[sc.nextInt()][sc.nextInt()]=true;
			}
			max_count=0;
			max=0;
			Queue<Integer[]> q=new LinkedList<>();
			Integer []aa= {start,0};
			q.add(aa);
			while(!q.isEmpty()) {
				Integer[] ss=q.poll();
				int v=ss[0];
				int count=ss[1];
				if(count>max_count) {
					max_count=count;
					max=v;
				}else if(count==max_count&&max<v) {
						max=v;
				}
				check[v]=true;
				for (int j = 1; j <map.length; j++) {
					if(map[v][j]&&!check[j]) {
						map[v][j]=false;
						Integer[] aaa= {j,count+1};
						q.add(aaa);
					}
				}
			}
			System.out.println("#"+i+" "+max);
		}
	}

}
