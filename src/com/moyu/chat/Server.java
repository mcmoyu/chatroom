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
  * 1.����JFrame�Լ�һЩ���
  * 2.�ڹ��췽���г�ʼ����������
  * 3.ʹ��������ʵ�����ݴ��䣨TCP��UDPЭ�飩
  * 4.���Ͱ�ť�ļ�������¼�
  */
public class Server extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		new Server();
	}
	
	// ���ԣ�
	private JTextArea jta; // �ı���
	private JScrollPane jsp; // ������
	private JPanel jp; // ���
	private JTextField jtf; // �ı���
	private JButton jb; // ��ť
	BufferedWriter bw = null; // �����
	int[] arr = {1111,2222,3333,4444};
	int i = 0;
	
	// ���췽��
	public Server() {
		// ��ʼ�����
		jta = new JTextArea(); // �ı���
		jta.setEditable(false); // ���ò��ɱ༭
		jsp = new JScrollPane(jta); // ����������Ҫ���ı�����뵽�������У�ʵ�ֹ���Ч����
		jp = new JPanel(); // ���
		jtf = new JTextField(18); // �ı���
		jb = new JButton("����"); // ��ť
		jb.addActionListener(this);
		
		// ��Ҫ���ı����밴ť��ӵ������
		jp.add(jtf);
		jp.add(jb);
		
		// �������������ȫ����ӵ�������
		this.add(jsp, BorderLayout.CENTER);
		this.add(jp,BorderLayout.SOUTH);
		
		// ���ñ��⣬��С��λ�ã��رգ��Ƿ�ɼ�
		this.setTitle("Chat - Server");
		this.setBounds(300, 300, 300, 300);
		this.setLocationRelativeTo(getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		/********************TCP �����  ��ʼ*********************/
		
		// 1111
		new Thread() {
			public void run() {
				try {
					// 1.����һ������˵��׽���
					ServerSocket serverSocket = new ServerSocket(1111);
					
					// 2.�ȴ��ͻ��˵�����
					Socket socket = serverSocket.accept();
					System.out.println("���ӳɹ�\nIPΪ" + socket.getLocalAddress() + "���û����ӳɹ�");
					
					// 3.��ȡsocket��������ʵ�ֶ�ȡ���ݣ�һ��һ�ж�ȡ��BufferedReader -> readLine()
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					// 4.��ȡsocket�������ʵ��д�����ݣ�Ҳ��дһ�У���һ�У�ˢ�£�BufferedWrite -> newLine()
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					String line = null;
					while((line = br.readLine()) != null) {
						// ����ȡ������ƴ�ӵ��ı�������ʾ
						jta.append("���գ�" + line + System.lineSeparator());
					}
					
					// 5.�ر�socketͨ��
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
					// 1.����һ������˵��׽���
					ServerSocket serverSocket = new ServerSocket(2222);
					
					// 2.�ȴ��ͻ��˵�����
					Socket socket = serverSocket.accept();
					System.out.println("���ӳɹ�\nIPΪ" + socket.getLocalAddress() + "���û����ӳɹ�");
					
					// 3.��ȡsocket��������ʵ�ֶ�ȡ���ݣ�һ��һ�ж�ȡ��BufferedReader -> readLine()
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					// 4.��ȡsocket�������ʵ��д�����ݣ�Ҳ��дһ�У���һ�У�ˢ�£�BufferedWrite -> newLine()
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					String line = null;
					while((line = br.readLine()) != null) {
						// ����ȡ������ƴ�ӵ��ı�������ʾ
						jta.append("���գ�" + line + System.lineSeparator());
					}
					
					// 5.�ر�socketͨ��
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
					// 1.����һ������˵��׽���
					ServerSocket serverSocket = new ServerSocket(3333);
					
					// 2.�ȴ��ͻ��˵�����
					Socket socket = serverSocket.accept();
					System.out.println("���ӳɹ�\nIPΪ" + socket.getLocalAddress() + "���û����ӳɹ�");
					
					// 3.��ȡsocket��������ʵ�ֶ�ȡ���ݣ�һ��һ�ж�ȡ��BufferedReader -> readLine()
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					// 4.��ȡsocket�������ʵ��д�����ݣ�Ҳ��дһ�У���һ�У�ˢ�£�BufferedWrite -> newLine()
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					String line = null;
					while((line = br.readLine()) != null) {
						// ����ȡ������ƴ�ӵ��ı�������ʾ
						jta.append("���գ�" + line + System.lineSeparator());
					}
					
					// 5.�ر�socketͨ��
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
					// 1.����һ������˵��׽���
					ServerSocket serverSocket = new ServerSocket(4444);
					
					// 2.�ȴ��ͻ��˵�����
					Socket socket = serverSocket.accept();
					System.out.println("���ӳɹ�\nIPΪ" + socket.getLocalAddress() + "���û����ӳɹ�");
					
					// 3.��ȡsocket��������ʵ�ֶ�ȡ���ݣ�һ��һ�ж�ȡ��BufferedReader -> readLine()
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					// 4.��ȡsocket�������ʵ��д�����ݣ�Ҳ��дһ�У���һ�У�ˢ�£�BufferedWrite -> newLine()
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					
					String line = null;
					while((line = br.readLine()) != null) {
						// ����ȡ������ƴ�ӵ��ı�������ʾ
						jta.append("���գ�" + line + System.lineSeparator());
					}
					
					// 5.�ر�socketͨ��
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
		/********************TCP �����  ����*********************/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = jtf.getText();
		try {
			bw.write(text);
			bw.newLine();
			bw.flush();
			jtf.setText("");
			text = "���ͣ�" + text;
			jta.append(text + System.lineSeparator());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}