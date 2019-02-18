package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2007 {

	public static void main(String[] args)
			throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <= T; i++) {
			String ss = br.readLine().trim();
			int length = 1;
			boolean sss=true;
			while (true) {
				String check = ss.substring(0, length);
				for (int j = 0; j < ss.length()-length; j = j + length) {
					if (!ss.substring(j, j + length).equals(check)) {
						length++;
						sss=false;
						break;
					}
				}
				if(sss==false) {
					sss=true;
				}else {
					break;
				}
			}
			System.out.println("#"+i+" "+length);
		}
	}

}
