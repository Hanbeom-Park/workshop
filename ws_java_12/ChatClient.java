package com.ssafy.edu.ws2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
//ctrl shift o 필요한거 전부 import
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	private JTextArea ta;
	private JTextField tf;
	private JButton bSend,bExit;
	private JPanel panel;//소그룹
	private static ChatConnect cc;
	public static void main(String[] args) {
		ChatClient cl=new ChatClient();
		cc=new ChatConnect(cl, "127.0.0.1",5433,"한범");
		cc.go();
	}
	public ChatClient() {
		//cc=new ChatConnect(this,ip,port,name);
		ta=new JTextArea(40,50);
		tf=new JTextField(50);
		bSend=new JButton("SEND");
		bExit=new JButton("EXIT");
		panel=new JPanel();
		
		//tf랑 send 버튼에 우리가 작성한 이벤트 처리 객체 전달하기
		tf.addActionListener(new ChattingListener());
		bSend.addActionListener(new ChattingListener());
		ta.setEditable(false);//텍스트 수정못하게
		//ta.setBackground(new Color(255,0,0,50));
		
		//패널에 버튼 두개 추가
		//panel.setLayout(new GridLayout(2, 1));
		//bSend.setSize(30, 20);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(bSend);
		panel.add(bExit);
		
		
		
		//패널과 ta와 tf를 프레임에 추가하기
		add(panel,BorderLayout.LINE_END);//
		add(new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),BorderLayout.CENTER);
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		
		setTitle("채팅 프로그램입니다.");
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	void show(String msg) {
		
		ta.append(msg+"\n");
		
	}
	
	//frame의 멤버인 ta나 tf같은 애들한테 접근하려면 내부 클래스로 작성하는게 용이하다.
	class ChattingListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//tf에서 엔터키를 누르거나 send 버튼을 클릭하는 이벤트가 발생했을때 메소드가 실행되도록함
			String input_msg=tf.getText();//입력된 메세지를 가져옴
			cc.send(input_msg);
			//ta.append(input_msg+"\n");
			tf.setText("");//textField에는 새로운 내용을 위해 비워주기
			
		}
		
	}
	
}
