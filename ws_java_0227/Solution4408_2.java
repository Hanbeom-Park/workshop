

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution4408_2 {

	public static void main(String[] args)
			throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] move = new int[N][2];
			int[][] room = new int[N][201];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if ((start + 1) / 2 < (end + 1) / 2) {
					for (int j2 = (start + 1) / 2; j2 <= (end + 1) / 2; j2++) {
						room[j][j2]++;
					}
				} else {
					for (int j2 = (end + 1) / 2; j2 <= (start + 1) / 2; j2++) {
						room[j][j2]++;
					}
				}
			}
			int max = 0;
			for (int j = 1; j < room[0].length; j++) {
				int count = 0;
				for (int j2 = 0; j2 < N; j2++) {
					if (room[j2][j] == 1) {
						count++;
					}
				}
				if (count > max) {
					max = count;
				}
			}

			for (int j = 0; j < room.length; j++) {
				for (int j2 = 1; j2 < room[j].length; j2++) {
					System.out.print(room[j][j2] + " ");
				}
				System.out.println();
			}

			// 걸쳐지면 1씩 증가?

			System.out.println("#" + i + " " + max);
		}
	}

}
/*
 * 3 4 10 20 30 40 50 60 70 80 2 1 3 2 200 3 10 100 20 80 30 50
 * 
 * 1 4 1 3 4 6 7 8 4 5
 * 
 * 
 */