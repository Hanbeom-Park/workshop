package edu.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1240 {

	public static void main(String[] args)
			throws NumberFormatException, IOException {
		String[] pattern= {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String aaa="";
			String password ="";
			int lastIndex = 0;
			for (int j = 0; j < N; j++) {
				aaa= br.readLine().trim();
				if (password.equals("")) {
					for (int j2 = M-1; j2 >=0; j2--) {
						if (aaa.substring(j2, j2+1).equals("1")) {
							password = aaa;
							lastIndex=j2;
							break;
						}
					}
				}
			}
			int[] a=new int[8];
			int count=0;
			//System.out.println(password);
			for (int j = lastIndex - 55; j <= lastIndex; j++) {
				for (int j1 = 0; j1 < 10; j1++) {
					if(pattern[j1].equals(password.substring(j,j+7))) {
						j=j+6;
						a[count++]=j1;
						break;
					}
				}
				//System.out.print(password.substring(j, j+1));
			}
			int res=(a[0]+a[2]+a[4]+a[6])*3+a[1]+a[3]+a[5]+a[7];
			if(res%10==0) {
				System.out.println("#"+i+" "+(a[0]+a[2]+a[4]+a[6]+a[1]+a[3]+a[5]+a[7]));
			}else {
				System.out.println("#"+i+" "+0);	
			}
			
			

		}
	}

}
/*

1
10 70
0000000000000000000000000000000000000000000000000000000000000000000000
0000011101101100010111011011000101100010001101001001101110110000000000
0000011101101100010111011011000101100010001101001001101110110000000000
0000011101101100010111011011000101100010001101001001101110110000000000
0000011101101100010111011011000101100010001101001001101110110000000000
0000011101101100010111011011000101100010001101001001101110110000000000
0000011101101100010111011011000101100010001101001001101110110000000000
0000011101101100010111011011000101100010001101001001101110110000000000
0000000000000000000000000000000000000000000000000000000000000000000000
0000000000000000000000000000000000000000000000000000000000000000000000

 * 
 * 
 */
