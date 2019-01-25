package com.ssafy.edu.ws2;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;


//채팅할때 소켓 연결과 관련된 작업을 수행하는 클래스
public class ChatConnect{
	private Socket s;
	private BufferedReader br;
	private PrintWriter pw;
	private String name;//(나 and 상대방) or 대화명 기능 추가
	private ChatClient cl;//내가 보낼 데이터를 얻어고거나 수신한 메시지를 전달해야하는 GUI프레임
	String str;
	private String ip;
	private int port;
	private static ChatConnect cc;
	public ChatConnect(ChatClient cl,String ip,int port,String name) {
		this.cl=cl;
		this.ip=ip;
		this.port=port;
		this.name=name;
		
	}
	public void go() {
		try{
			s = new Socket(ip,port);//접속할 서버의 주소와 포트번호로 소켓 객체를 생성한다.
			br = new BufferedReader(new InputStreamReader(System.in));//버퍼 리더 객체 생성한다.client의 입력을 받기위함
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);

			ClientThread ct = new ClientThread(s);//스레드를 상속한 클라이언트스레드 객체 생성. 
			ct.start();//시작
			//System.out.println(str);
			while ( ( str = br.readLine() ) != null ){
				send(str);
				//pw.write(str);//str내용을 pw로 서버에 보냄.
			}
		}catch (IOException e){
			System.out.println(e.getMessage());//예외처리
		}
		
	}
	public void send(String msg) {
		msg=name+":"+msg;
		pw.println(msg);
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
					//System.out.println(str);//str출력
					cl.show(str);
				}
			}catch (IOException e){
				System.out.println(e.getMessage());
			}
		}
		
	}

}
