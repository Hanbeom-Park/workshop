package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3124 {
	static boolean[] visit;
	static int[] parent;
	static int V,E;
	static long mst;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			st=new StringTokenizer(br.readLine().trim());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			mst=0;
			visit=new boolean[V+1];
			parent=new int[V+1];
			pq=new PriorityQueue<>(new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					return o1.value > o2.value ? 1 : -1;
				}
			});
			for (int e = 0; e < E; e++) {
				st=new StringTokenizer(br.readLine().trim());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());

				pq.add(new Edge(start,end,value));//간선들을 가중치로 정렬하는 우선순위 큐에 다 집어넣기
			}
			kruskal();
			System.out.println("#"+i+" "+mst);
		}
	}
	static void kruskal() {
		for (int i = 1; i <=V; i++) {
			parent[i]=i;
		}
		for (int i = 0; i <E; i++) {
			Edge edge=pq.poll();
			if(find(edge.start)==find(edge.end)) {
				continue;
			}
			union(edge.start,edge.end);
			mst=mst+(long)edge.value;
			
		}
	}
	static int find(int n) {
		if(parent[n]==n) {
			return n;
		}
		parent[n]=find(parent[n]);
		return parent[n];
	}
	static void union(int n1,int n2) {
		int p1=find(n1);
		int p2=find(n2);
		if(p1!=p2) {
			parent[p1]=p2;
		}
	}
	static class Edge {// 하나의 간선정보를 하나의 객체에 묶기 위한 내부 클래스
		int start, end, value;
		Edge(int s, int e, int v) {
			start = s;
			end = e;
			value = v;
		}
	}
}
/*
1
7 11
1 2 2
2 3 5
1 3 20
1 4 10
4 5 1
5 6 23
3 6 3
3 5 6
7 6 9
7 3 2
2 7 7
*/