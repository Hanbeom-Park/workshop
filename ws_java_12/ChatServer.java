package com.ssafy.edu.ws2;

import java.net.*;
import java.io.*;
import java.util.Vector;

public class ChatServer{
	ServerSocket ss;
	Socket s;
	Vector<ServerThread> v;
	public ChatServer(){
		v = new Vector<>(10,10);
	}
	public synchronized void addThread(ServerThread st){
		v.add(st);
	}
	public synchronized void removeThread(ServerThread st){
		v.remove(st);
	}
	public synchronized void broadcast(String str){
		for ( int i = 0 ; i < v.size() ; i++ ){
			ServerThread st1 = v.get(i);
			st1.sendMessage(str);
		}
	}
	public void go(){
		try{
			ss = new ServerSocket(5433);
			ss.setReuseAddress(true);
			System.out.println("1.ready~~~");
			while ( true ){
				s = ss.accept();
				ServerThread st = new ServerThread(this, s);
				this.addThread(st);
				st.start();
			}
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	public static void main(String [] args) throws IOException{
		ChatServer server = new ChatServer();
		server.go();
	}
}

class ServerThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	String str;
	ChatServer server;

	public ServerThread(ChatServer server,Socket s) throws IOException {
		this.server = server;//?쒕쾭???덈뒗 諛⑹쓣 ?ъ슜?섍린 ?꾪빐 
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		System.out.println(s.getInetAddress()+"연결됨");
	}
	public void sendMessage(String string){
		pw.println(string);
	}
	public void run(){
		try{
			while ( ( str = br.readLine() ) != null ){
				System.out.println("받아짐");
				server.broadcast(str);
			}
		}catch (IOException e){
			System.out.println(s.getInetAddress()+"나감");
			server.removeThread(this);
			try{
				s.close();
			}catch (IOException ie){ }
		}
	}
}
