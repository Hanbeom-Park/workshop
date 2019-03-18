package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3143 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			st=new StringTokenizer(br.readLine().trim());
			char[] ss=st.nextToken().toCharArray();
			char[] cc=st.nextToken().toCharArray();
			int count=0;
			for (int j = 0; j < ss.length; j++) {
				if(j+cc.length-1<ss.length) {	
				boolean check=true;
					for (int j2 = 0; j2 < cc.length; j2++) {
						if(cc[j2]!=ss[j+j2]) {
							check=false;
							break;
						}
					}
					if(check) {
						j=j+cc.length-1;
					}
				}
					count++;
			}
			System.out.println("#"+i+" "+count);
		}
	}

}
/*

3
banana bana
asakusa saa
asdfasssfdssa asdf

*/