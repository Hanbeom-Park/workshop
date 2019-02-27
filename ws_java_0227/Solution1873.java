import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1873 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		char[] field= {'.','*','#','-'};
		char[] now= {'^','v','<','>'};
		char[] move= {'U','D','L','R','S'};
		int[] dir_x= {-1,1,0,0};
		int[] dir_y= {0,0,-1,1};
		
		
		for (int i = 1; i <=T; i++) {
			st=new StringTokenizer(br.readLine().trim());
			int H=Integer.parseInt(st.nextToken());
			int W=Integer.parseInt(st.nextToken());
			char[][] map=new char[H][W];
			for (int j = 0; j <H; j++) {
				st=new StringTokenizer(br.readLine().trim());
				map[j]=st.nextToken().toCharArray();
			}
			int x=0;
			int y=0;
			int dir=0;
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map[j].length; j2++) {
					for (int k = 0; k < 4; k++) {
						if(map[j][j2]==now[k]) {
							dir=k;
							x=j;
							y=j2;
							break;
						}
					}
				}
			}
			int N=Integer.parseInt(br.readLine().trim());
			st=new StringTokenizer(br.readLine().trim());
			String aa=st.nextToken();
			for (int j = 0; j < N; j++) {
				char com=aa.charAt(j);
				for (int k = 0; k <4; k++) {
					if(move[k]==com) {
						dir=k;
						if(x+dir_x[k]<0||x+dir_x[k]>=H||y+dir_y[k]<0||y+dir_y[k]>=W) {
							
						}
						else if(map[x+dir_x[k]][y+dir_y[k]]=='.') {
							map[x][y]='.';
							x=x+dir_x[k];
							y=y+dir_y[k];
						}
						map[x][y]=now[k];
						
					}
				}
				if(move[4]==com) {
					int shoot_x=x;
					int shoot_y=y;
					while(shoot_x+dir_x[dir]>=0&&shoot_x+dir_x[dir]<H&&shoot_y+dir_y[dir]>=0&&shoot_y+dir_y[dir]<W) {
						
						shoot_x=shoot_x+dir_x[dir];
						shoot_y=shoot_y+dir_y[dir];
						
						if(map[shoot_x][shoot_y]=='*') {
							map[shoot_x][shoot_y]='.';
							break;
						}else if(map[shoot_x][shoot_y]=='#') {
							break;
						}else if(map[shoot_x][shoot_y]=='.') {
							
						}else if(map[shoot_x][shoot_y]=='-') {
							
						}
					}
				}
			}
			System.out.print("#"+i+" ");
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map[j].length; j2++) {
					System.out.print(map[j][j2]);
				}
				System.out.println();
			}
		}
	}

}
/*
1
4 6
*.*..*
*.....
..-...
^.*#..
10
SRSSRRUSSR

1
17 11
....#..*...
*-**...*.#.
.-..#...*#*
#...#-#....
.#..#.....*
.#.*-.#..*.
...*..-*-.#
..#***...*<
..*-#*-.*..
..-*##....*
...#..-..-.
.......**..
...*#.-.#.*
*..#..#*...
....*.#.**-
..*-**....*
*.*...##*#.
88
SSSSSUSDLSDSLSLSDRDSLSSRUSRLSRSSULDULLDLSSSLRDSDLRLDRRDSRSUSULSLSLUSDSLLUDSUDRSSRSLLSSDS
14 
*/
