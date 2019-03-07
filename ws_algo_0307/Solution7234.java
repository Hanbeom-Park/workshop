package D3;

import java.util.Scanner;

public class Solution7234 {

	public static void main(String[] args) {
		int[] dir_x = {-1, 1, 0, 0};
		int[] dir_y = {0, 0, -1, 1};

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			int[][] map = new int[N + 1][N + 1];
			for (int j = 0; j < B; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y]--;
			}
			int max = 0;
			for (int j = 1; j < map.length; j++) {
				for (int j2 = 1; j2 < map.length; j2++) {
					if (map[j][j2] < 0) {
						for (int k3 = 0; k3 < -map[j][j2]; k3++) {

							int x = j;
							int y = j2;
							for (int k2 = 1; k2 <= 2; k2++) {

								for (int k = 0; k < 4; k++) {
									if (x + k2 * dir_x[k] < 1
											|| x + k2 * dir_x[k] > N
											|| y + k2 * dir_y[k] < 1
											|| y + k2 * dir_y[k] > N
											|| map[x + k2 * dir_x[k]][y
													+ k2 * dir_y[k]] < 0) {

									} else {
										map[x + k2 * dir_x[k]][y
												+ k2 * dir_y[k]]++;
										if (map[x + k2 * dir_x[k]][y
												+ k2 * dir_y[k]] > max) {
											max = map[x + k2 * dir_x[k]][y
													+ k2 * dir_y[k]];
										}
									}
								}
							}
						}
					}
				}
			}
			// for (int j = 1; j < map.length; j++) {
			// for (int j2 = 1; j2 < map.length; j2++) {
			// System.out.print(map[j][j2] + " ");
			// }
			// System.out.println();
			// }
			System.out.println("#"+i+" "+max);
		}
	}

}
