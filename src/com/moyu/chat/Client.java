package com.moyu.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener{

	public static void main(String[] args) {
		new Client();
	}
	
	// 属性：
	private JTextArea jta; // 文本域
	private JScrollPane jsp; // 滚动条
	private JPanel jp; // 面板
	private JTextField jtf; // 文本框
	private JButton jb; // 按钮
	BufferedWriter bw = null;
	String ip = "192.168.137.1";
	
	// 构造方法
	public Client() {
		// 初始化组件
		jta = new JTextArea(); // 文本域
		jta.setEditable(false); // 设置不可编辑
		jsp = new JScrollPane(jta); // 滚动条，需要将文本域加入到滚动条中，实现滚动效果。
		jp = new JPanel(); // 面板
		jtf = new JTextField(18); // 文本框
		jb = new JButton("发送"); // 按钮
		jb.addActionListener(this);
		
		// 需要将文本框与按钮添加到面板中
		jp.add(jtf);
		jp.add(jb);
		
		// 将滚动条与面板全部添加到窗体中
		this.add(jsp, BorderLayout.CENTER);
		this.add(jp,BorderLayout.SOUTH);
		
		// 设置标题，大小，位置，关闭，是否可见
		this.setTitle("Chat - Client");
		this.setBounds(300, 300, 300, 300);
		this.setLocationRelativeTo(getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		/********************TCP 客户端  开始*********************/
		
		try {
			// 1.创建一个客户端的套接字（尝试连接）
			Socket socket = new Socket(ip, 1111);

			// 2.获取socket输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 3.获取socket输出流
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// 循环读取数据，并拼接
			String line = null;
			while((line = br.readLine()) != null) {
				jta.append("接收自服务器：" + line + System.lineSeparator());
			}
			
			// 4.关闭socket通道
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/********************TCP 客户端  结束*********************/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = jtf.getText();
		try {
			bw.write(text);
			bw.newLine();
			bw.flush();
			jtf.setText("");
			text = "发送给服务器：" + text;
			jta.append(text + System.lineSeparator());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}