package com.ssafy.edu.j4;

import java.net.*;
import java.io.*;

public class Client {
	Socket s;
	BufferedReader br, br1;
	PrintWriter pw;
	String str;
	public void go(){
		try{
			s = new Socket("192.168.208.40",5433);//접속할 서버의 주소와 포트번호로 소켓 객체를 생성한다.
			br = new BufferedReader(new InputStreamReader(System.in));//버퍼 리더 객체 생성한다.client의 입력을 받기위함
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);//메세지를 보내기 위한 pw객체 생성. true시 flush시킨다.

			ClientThread ct = new ClientThread(s);//스레드를 상속한 클라이언트스레드 객체 생성. 
			ct.start();//시작

			while ( ( str = br.readLine() ) != null ){
				pw.println(str);//str내용을 pw로 서버에 보냄.
			}
		}catch (IOException e){
			System.out.println(e.getMessage());//예외처리
		}
		
	}
	public static void main(String [] args){
		System.out.println("Client");
		Client c = new Client();//클라이언트 객체 생성
		c.go();//go 실행
	}
}

class ClientThread extends Thread{
	Socket s;
	BufferedReader br1;		
	String str;
	public ClientThread(Socket s) throws IOException {//오류는 위에서 처리하므로 throws로 그냥 날림
		this.s = s;//생성자 소켓
		br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));//입력을 받기위한 버퍼리더 초기화.
	}
	public void run(){
		try{
			while ( ( str = br1.readLine() ) != null){//입력받은거 있는지 확인.
				System.out.println(str);//str출력
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
}
	
