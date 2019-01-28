package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6808 {
	static int[] data;
	static int []data2;
	static int a_win=0,b_win=0;
	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			st=new StringTokenizer(br.readLine());
			data=new int[9];
			data2=new int[9];
			int[] all_card=new int[19];
			for (int j = 0; j < data.length; j++) {
				data[j]=Integer.parseInt(st.nextToken());
				all_card[data[j]]++;
			}
			int c=0;
			for (int j = 1; j <=18; j++) {
				if(all_card[j]==0) {
					data2[c++]=j;
				}
			}
			//System.out.println(Arrays.toString(data2));
			//data2=data.clone();
			card(data2,0);
			System.out.println("#"+i+" "+a_win+" "+b_win);
			a_win=0;
			b_win=0;
		}
	}
	static void card(int[] arr,int index) {
		if(index==9) {
			int a=0,b=0;
			//System.out.println(Arrays.toString(data));
			for (int i = 0; i < arr.length; i++) {
				if(data[i]>arr[i]) {
					a=a+data[i]+arr[i];
				}else if(data[i]<arr[i]) {
					b=b+data[i]+arr[i];
				}
			}
			//System.out.println(a+" "+b);
			
			if(a>b) {
				a_win++;
			}else if(b>a){
				b_win++;
			}
			return;
		}
		for (int i = index; i < arr.length; i++) {
			swap(arr,i,index);
			card(arr,index+1);
			swap(arr,i,index);
		}
		
	}

	public static void swap(int[] arr,int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
/*
 * 
4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18

*/

