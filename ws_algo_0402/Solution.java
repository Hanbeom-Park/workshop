package com.ssafy.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution {
    static boolean [][]mag;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine().trim());
        StringTokenizer st;
        for (int i = 1; i <=T; i++) {
            int K=Integer.parseInt(br.readLine().trim());
             
            mag =new boolean[4][8];
            for (int j = 0; j < mag.length; j++) {
                st=new StringTokenizer(br.readLine().trim());
                for (int j2 = 0; j2 <8; j2++) {
                    if(st.nextToken().charAt(0)=='0') {
                        mag[j][j2]=false;
                    }else {
                        mag[j][j2]=true;
                    }
                }
            }
            for (int j = 0; j < K; j++) {
                ArrayList<Integer[]> s=new ArrayList<>();
                st=new StringTokenizer(br.readLine().trim());
                int num=Integer.parseInt(st.nextToken())-1;
                int dir=Integer.parseInt(st.nextToken());
                int first=dir;
                int left=num-1;
                int right=num+1;
                boolean stop_l=false;
                boolean stop_r=false;
                while(left>-1||right<4) {
                    dir=-dir;
                    if(!stop_l&&left>-1&&mag[left+1][6]!=mag[left][2]) {
                        s.add(new Integer[]{left,dir});
                    }else {
                        stop_l=true;
                    }
                    if(!stop_r&&right<4&&mag[right][6]!=mag[right-1][2]) {
                        s.add(new Integer[]{right,dir});
                    }else {
                        stop_r=true;
                    }
                     
                    left--;
                    right++;
                }
                move(num,first);
                for (int l = 0; l < s.size(); l++) {
                    Integer[] aa=s.get(l);
                    move(aa[0],aa[1]);
                }
            }
            int tot=0;
            int p=1;
            for (int j = 0; j <4; j++) {
                if(mag[j][0]==true) {
                    tot=tot+p;
                }
                p=p*2;
            }
            System.out.println("#"+i+" "+tot);
        }
    }
    static void move(int num,int dir) {
        if(dir==1) {
            boolean tmp=mag[num][7];
            for (int i = 7; i >0; i--) {
                mag[num][i]=mag[num][i-1];
                 
            }
            mag[num][0]=tmp;
             
        }else {
            boolean tmp=mag[num][0];
            for (int i = 0; i <7; i++) {
                mag[num][i]=mag[num][i+1];
                 
            }
            mag[num][7]=tmp;
             
        }
         
         
    }
     
 
}