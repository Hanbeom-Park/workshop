package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Solution1258_2 {
	//하나씩 탐색해서 숫자 만나면 0만날때까지 x축 이동 y축 이동
	//
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			int N=Integer.parseInt(br.readLine().trim());
			int[][] map=new int[N][N];
			for (int j = 0; j < map.length; j++) {
				st=new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 < map.length; j2++) {
					map[j][j2]=Integer.parseInt(st.nextToken());
				}
			}
			ArrayList<Integer[]> arr_size=new ArrayList<>();
			int count=0;
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {

					if(map[j][j2]!=0) {
						int x=j;
						int y=j2;
						while(map[x][j2]!=0) {
							x++;
						}
						while(map[j][y]!=0) {
							y++;
						}
						for (int k = j; k <x; k++) {
							for (int k2 = j2; k2 <y; k2++) {
								map[k][k2]=0;
							}
						}
						
						arr_size.add(new Integer[] {x-j,y-j2});
						//System.out.println((x-1-j)+" "+(y-1-j2));
						
						count++;
					}
				}
			}
			arr_size.sort(new Comparator<Integer[]>() {

				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					if(o1[0]*o1[1]==o2[0]*o2[1]) {
						return o1[0]-o2[0];
					}else {
						return o1[0]*o1[1]-o2[0]*o2[1];						
					}
				}
			
			});
			System.out.print("#"+i+" "+count);
			for (int j = 0; j <arr_size.size(); j++) {
				Integer[] aa=arr_size.get(j);
				System.out.print(" "+aa[0]+" "+aa[1]);
			}
			System.out.println();
		}
	}

}
/*
1
5
1 2 3 4 0 
0 0 0 0 0 
5 0 0 0 0 
6 0 0 0 0 
0 0 0 0 0 
*/