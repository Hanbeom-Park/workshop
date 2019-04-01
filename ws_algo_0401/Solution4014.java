package ssafy0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4014 {
	//활주로는 높이가 동일한 구간
	//활주로를 건설할수 있는 수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int X=Integer.parseInt(s[1]);
			int[][] map=new int[N][N];
			for (int j = 0; j <N; j++) {
				st=new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 <N; j2++) {
					map[j][j2]=Integer.parseInt(st.nextToken());
				}
			}
			//두칸차이나면 안됨
			//맵 밖으로 나가면 안됨
			//활주로 겹치면 안됨
			int count=0;
			for (int j = 0; j < map.length; j++) {
				boolean[] check=new boolean[N];
				boolean canbuild=true;
				exit:for (int j2 = 0; j2 < map.length-1; j2++) {
					if(map[j][j2]-map[j][j2+1]>1) {//2개이상 차이나서 못지음
						canbuild=false;
						//System.out.println(j+"차이나서 안됨AAA");

						break exit;
		
					}
					if(map[j][j2]-map[j][j2+1]==1) {
						if(j2+X>N-1) {//값이 넘어감
							canbuild=false;
							break exit;
						}
						int now=map[j][j2+1];
						for (int k =j2+1; k <=j2+X; k++) {
							if(now!=map[j][k]||check[k]) {//높이가 안맞음, 이미 지어짐
								canbuild=false;
								break exit;
							}
						}
						
						for (int k =j2+1; k <=j2+X; k++) {
							check[k]=true;//지음
						}
						
					}
				}
				
				exit:for (int j2 =  map.length-1; j2>=1; j2--) {
					if(map[j][j2]-map[j][j2-1]>1) {//2개이상 차이나서 못지음
						canbuild=false;
						break exit;
		
					}
					if(map[j][j2]-map[j][j2-1]==1) {
						if(j2-X<0) {//값이 넘어감
							canbuild=false;
							break exit;
						}
						int now=map[j][j2-1];
						for (int k =j2-1; k >=j2-X; k--) {
							if(now!=map[j][k]||check[k]) {//높이가 안맞음, 이미 지어짐
								canbuild=false;
								break exit;
							}
						}
						
						for (int k =j2-1; k >=j2-X; k--) {
							check[k]=true;//지음
						}
						
					}
				}
				if(canbuild) {
					//System.out.println(j+"AAA");
					count++;
				}
			}
			
			
			for (int j = 0; j < map.length; j++) {
				boolean[] check=new boolean[N];
				boolean canbuild=true;
				exit:for (int j2 = 0; j2 < map.length-1; j2++) {
					if(map[j2][j]-map[j2+1][j]>1) {//2개이상 차이나서 못지음
						canbuild=false;
						break exit;
		
					}
					if(map[j2][j]-map[j2+1][j]==1) {
						if(j2+X>N-1) {//값이 넘어감
							canbuild=false;
							break exit;
						}
						int now=map[j2+1][j];
						for (int k =j2+1; k <=j2+X; k++) {
							if(now!=map[k][j]||check[k]) {//높이가 안맞음, 이미 지어짐
								canbuild=false;
								break exit;
							}
						}
						
						for (int k =j2+1; k <=j2+X; k++) {
							check[k]=true;//지음
						}
						
					}
				}
				
				exit:for (int j2 =  map.length-1; j2>=1; j2--) {
					if(map[j2][j]-map[j2-1][j]>1) {//2개이상 차이나서 못지음
						canbuild=false;
						break exit;
		
					}
					if(map[j2][j]-map[j2-1][j]==1) {
						if(j2-X<0) {//값이 넘어감
							canbuild=false;
							break exit;
						}
						int now=map[j2-1][j];
						for (int k =j2-1; k >=j2-X; k--) {
							if(now!=map[k][j]||check[k]) {//높이가 안맞음, 이미 지어짐
								canbuild=false;
								break exit;
							}
						}
						
						for (int k =j2-1; k >=j2-X; k--) {
							check[k]=true;//지음
						}
						
					}
				}
				if(canbuild) {
					//System.out.println(j+"BBB");
					count++;
				}
			}
			System.out.println("#"+i+" "+count);
		}
	}

}
/*
1
6 2
3 3 3 2 1 1
3 3 3 2 2 1
3 3 3 3 3 2
2 2 3 2 2 2
2 2 3 2 2 2
2 2 2 2 2 2

*/