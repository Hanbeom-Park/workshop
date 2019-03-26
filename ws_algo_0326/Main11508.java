package BAEKJOON;
import java.util.Arrays;
import java.util.Scanner;

public class Main11508 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] aa=new int[N];
		long tot=0;
		for (int i = 0; i <N; i++) {
			aa[i]=sc.nextInt();
			tot=tot+aa[i];
		}
		Arrays.sort(aa);
		//7-3 4 
		for (int i = aa.length-3; i >=0; i=i-3) {
			tot=tot-aa[i];
		}
		System.out.println(tot);
	}

}