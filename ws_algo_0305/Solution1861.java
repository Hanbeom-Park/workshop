package ssafy0305;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1861{
	static int max_count;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dir_x = { 1, -1, 0, 0 };
		int[] dir_y = { 0, 0, 1, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] map = new int[N][N];
			min=Integer.MAX_VALUE;
			max_count=0;
			boolean[][] check = new boolean[N][N];
			for (int j = 0; j < check.length; j++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 < check.length; j2++) {
					map[j][j2] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < check.length; j++) {
				for (int j2 = 0; j2 < check.length; j2++) {
					if (!check[j][j2]) {
						int x = j;
						int y = j2;
						int count = 0;
						boolean cc = true;
						check[x][y] = true;
						while (cc) {
							cc = false;
							for (int k = 0; k < 4; k++) {
								if (x + dir_x[k] < 0 || x + dir_x[k] >= N || y + dir_y[k] < 0 || y + dir_y[k] >= N) {

								} else if (map[x + dir_x[k]][y + dir_y[k]] == map[x][y] + 1) {
									x = x + dir_x[k];
									y = y + dir_y[k];
									cc = true;
									check[x][y] = true;
									break;
								}
							}
							count++;
						}
						if(max_count<count) {
							max_count=count;
							min=map[j][j2];
						}else if(max_count==count&&min>map[j][j2]){
							min=map[j][j2];
						}
					}
					

				}
			}
			System.out.println("#"+i+" "+min+" "+max_count);
		}

	}

}
/*
1
8
38 39 40 41 42 43 44 45 
46 47 48 49 50 51 52 53 
54 55 56 57 58 59 60 61 
62 63 64 1 2 3 4 5 
6 7 8 9 10 11 12 13 
14 15 16 17 18 19 20 21 
22 23 24 25 26 27 28 29 
30 31 32 33 34 35 36 37 

1
3
3 2 1
6 5 4
9 8 7

*
*/