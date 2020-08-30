package com.moyu.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 /*
  * 1.定义JFrame以及一些组件
  * 2.在构造方法中初始化窗体的组件
  * 3.使用网络编程实现数据传输（TCP、UDP协议）
  * 4.发送按钮的监听点击事件
  */
public class Server extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		new Server();
	}
	
	// 属性：
	private JTextArea jta; // 文本域
	private JScrollPane jsp; // 滚动条
	private JPanel jp; // 面板
	private JTextField jtf; // 文本框
	private JButton jb; // 按钮
	BufferedWriter bw = null; // 输出流
	int[] arr = {1111,2222,3333,4444};
	int i = 0;
	
	// 构造方法
	public Server() {
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
		this.setTitle("Chat - Server");
		this.setBounds(300, 300, 300, 300);
		this.setLocationRelativeTo(getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		/********************TCP 服务端  开始*********************/
		
		// 1111
		new Thread() {
			public void run() {
				try {
					// 1.创建一个服务端的套接字
					ServerSocket serverSocket = new ServerSocket(1111);
					
					// 2.等待客户端的连接
					Socket socket = serverSocket.accept();
					System.out.println("连接成功\nIP为" + socket.getLocalAddress() + "的用户连接成功");
					
					// 3.获取socket输入流（实现读取数据，一行一行读取）BufferedReader -> readLine()
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					// 4.获取socket输出流（实现写出数据，也是写一行，换一行，刷新）BufferedWrite -> newLine()
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					String line = null;
					while((line = br.readLine()) != null) {
						// 将读取的数据拼接到文本域中显示
						jta.append("接收：" + line + System.lineSeparator());
					}
					
					// 5.关闭socket通道
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		// 2222
		new Thread() {
			public void run() {
				try {
					// 1.创建一个服务端的套接字
					ServerSocket serverSocket = new ServerSocket(2222);
					
					// 2.等待客户端的连接
					Socket socket = serverSocket.accept();
					System.out.println("连接成功\nIP为" + socket.getLocalAddress() + "的用户连接成功");
					
					// 3.获取socket输入流（实现读取数据，一行一行读取）BufferedReader -> readLine()
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					// 4.获取socket输出流（实现写出数据，也是写一行，换一行，刷新）BufferedWrite -> newLine()
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					String line = null;
					while((line = br.readLine()) != null) {
						// 将读取的数据拼接到文本域中显示
						jta.append("接收：" + line + System.lineSeparator());
					}
					
					// 5.关闭socket通道
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		// 3333
		new Thread() {
			public void run() {
				try {
					// 1.创建一个服务端的套接字
					ServerSocket serverSocket = new ServerSocket(3333);
					
					// 2.等待客户端的连接
					Socket socket = serverSocket.accept();
					System.out.println("连接成功\nIP为" + socket.getLocalAddress() + "的用户连接成功");
					
					// 3.获取socket输入流（实现读取数据，一行一行读取）BufferedReader -> readLine()
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					// 4.获取socket输出流（实现写出数据，也是写一行，换一行，刷新）BufferedWrite -> newLine()
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					String line = null;
					while((line = br.readLine()) != null) {
						// 将读取的数据拼接到文本域中显示
						jta.append("接收：" + line + System.lineSeparator());
					}
					
					// 5.关闭socket通道
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		// 4444
		new Thread() {
			public void run() {
				try {
					// 1.创建一个服务端的套接字
					ServerSocket serverSocket = new ServerSocket(4444);
					
					// 2.等待客户端的连接
					Socket socket = serverSocket.accept();
					System.out.println("连接成功\nIP为" + socket.getLocalAddress() + "的用户连接成功");
					
					// 3.获取socket输入流（实现读取数据，一行一行读取）BufferedReader -> readLine()
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					// 4.获取socket输出流（实现写出数据，也是写一行，换一行，刷新）BufferedWrite -> newLine()
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					String line = null;
					while((line = br.readLine()) != null) {
						// 将读取的数据拼接到文本域中显示
						jta.append("接收：" + line + System.lineSeparator());
					}
					
					// 5.关闭socket通道
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
		/********************TCP 服务端  结束*********************/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = jtf.getText();
		try {
			bw.write(text);
			bw.newLine();
			bw.flush();
			jtf.setText("");
			text = "发送：" + text;
			jta.append(text + System.lineSeparator());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}