package ssafy0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3289 {
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <=T; i++) {
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			//0연산은 합치는 연산
			//1연산 확인하는 연산
			//같은 집합 1 아니면 0
			parent=new int[n+1];
			for (int j = 1; j <=n; j++) {
				parent[j]=j;
			}
			System.out.print("#"+i+" ");
			for (int j = 0; j < m; j++) {
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[1]);
				int b=Integer.parseInt(s[2]);
				
				if(s[0].equals("0")) {
					union(a,b);
				}else {
					if(find(a)==find(b)) {
						System.out.print("1");
					}else {
						System.out.print("0");
							
					}
						
				}
			}
			System.out.println();
		}
	}
	static int find(int n) {
		if(parent[n]==n) {
			return n;
		}
		parent[n]=find(parent[n]);
		return parent[n];
	}
	static void union(int p1,int p2) {
		int n1=find(p1);
		int n2=find(p2);
		if(n1==n2) {
			return;
		}
		parent[n1]=n2;
	}
}
