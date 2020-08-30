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
	
	// ���ԣ�
	private JTextArea jta; // �ı���
	private JScrollPane jsp; // ������
	private JPanel jp; // ���
	private JTextField jtf; // �ı���
	private JButton jb; // ��ť
	BufferedWriter bw = null;
	String ip = "192.168.137.1";
	
	// ���췽��
	public Client() {
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
		this.setTitle("Chat - Client");
		this.setBounds(300, 300, 300, 300);
		this.setLocationRelativeTo(getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		/********************TCP �ͻ���  ��ʼ*********************/
		
		try {
			// 1.����һ���ͻ��˵��׽��֣��������ӣ�
			Socket socket = new Socket(ip, 1111);

			// 2.��ȡsocket������
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 3.��ȡsocket�����
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// ѭ����ȡ���ݣ���ƴ��
			String line = null;
			while((line = br.readLine()) != null) {
				jta.append("�����Է�������" + line + System.lineSeparator());
			}
			
			// 4.�ر�socketͨ��
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/********************TCP �ͻ���  ����*********************/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = jtf.getText();
		try {
			bw.write(text);
			bw.newLine();
			bw.flush();
			jtf.setText("");
			text = "���͸���������" + text;
			jta.append(text + System.lineSeparator());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}