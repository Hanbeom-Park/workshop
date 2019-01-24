package com.ssafy.edu.j4;

import java.net.*;
import java.io.*;
import java.util.Vector;

public class Server{
	ServerSocket ss;
	Socket s;
	Vector<ServerThread> v;
	public Server(){
		v = new Vector<>(10,10);//벡터 생성함.
	}
	public synchronized void addThread(ServerThread st){
		v.add(st);//벡터에 서버스레드를 추가함
	}
	public synchronized void removeThread(ServerThread st){
		v.remove(st);//벡터에서 서버스레드 제거
	}
	public synchronized void broadcast(String str){
		for ( int i = 0 ; i < v.size() ; i++ ){//벡터에 저장된 모든 서버스레드에 메세지 보냄
			ServerThread st1 =v.get(i);
			st1.sendMessage(str);
		}
	}
	public void go(){
		try{
			ss = new ServerSocket(5432);//해당 포트번호로 서버소켓 생성
			ss.setReuseAddress(true);//10분 대기 안하게 해줌. 끊어도 바로 포트 사용할수 있게 해준다.
			System.out.println("1.ready");
			while ( true ){//무한루프로 클라이언드의 요청을 받아줌.
				s = ss.accept();
				ServerThread st = new ServerThread(this, s);//this는 벡터에 접근하기 위함
				this.addThread(st);//스레드 추가
				st.start();//동작
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String [] args) throws IOException{
		Server server = new Server();//서버 객체 생성/
		server.go();
	}
}

class ServerThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String str;
	Server server;

	public ServerThread(Server server,Socket s) throws IOException {
		this.server = server;//서버에 있는 방을 사용하기 위해 
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));//버퍼리더 생성. 클라이언트로부터 메세지 받음
		pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);//메세지 보내기 위한 pw생성. true해서 flush해줌
		System.out.println(s.getInetAddress()+"가 붙음");
	}
	public void sendMessage(String string){
		pw.println(string);//string의 내용 보냄.
	}
	public void run(){
		try{
			while ( ( str = br.readLine() ) != null ){
				server.broadcast(str);//메세지 받은거 싹다 보내줌.
			}
		}catch (IOException e){
			System.out.println(s.getInetAddress()+".");
			server.removeThread(this);//스레드 제거
			try{
				s.close();
			}catch (IOException ie){ }
		}
	}
}
