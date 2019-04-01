package ssafy0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4261 {
	//키 입력에 대응되는 단어수 출력
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		char[][] keypad= {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		for (int i = 1; i <=T; i++) {
			String[] s=br.readLine().split(" ");
			String S=s[0];
			int N=Integer.parseInt(s[1]);
			String[] word=new String[N];
			word=br.readLine().split(" ");
			int count=0;
			exit: for (int j = 0; j < word.length; j++) {
				if(S.length()!=word[j].length()) {
					continue;
				}
				for (int j2 = 0; j2 <S.length(); j2++) {
					boolean check=false;
					for (int k2 = 0; k2 < keypad[S.charAt(j2)-'0'-2].length; k2++) {
						if(keypad[S.charAt(j2)-'0'-2][k2]==word[j].charAt(j2)) {
							check=true;
						}
					}
					if(!check) {
						continue exit;
					}
				}
				count++;
			}
			System.out.println("#"+i+" "+count);
		}
	}

}
