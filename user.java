import javax.swing.*;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import static javax.swing.JFrame.*; //����JFrame�ľ�̬����
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class user extends JFrame implements ActionListener{	
	JButton button1,button2;JLabel jl1;	 
	BackgroundPanel bgp2;//�����������	 
	String s1,s2;
public user(String s,String s0){

	setTitle("���߽���");
	setBounds(0,0,480,700);			
		setLayout(null);		
		init();   //��ӿؼ��Ĳ�����װ��һ������         
		setVisible(true);//��������������ִ��
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		s1=s;s2=s0;
	}

void init(){//��ӵĿؼ�
	String str1="               �𾴵Ķ���";
	String str2="��ӭ��ʹ�ñ�ϵͳ";
	String str3="<html><body>"+str1+"<br>"+str2+"<body><html>";
	
	 jl1=new JLabel(str3);
	
		jl1.setBounds(0,40,480,120);
		jl1.setFont(new Font("��Բ",Font.PLAIN,36));
		jl1.setForeground(Color.DARK_GRAY);
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		/*bgp1=new BackgroundPanel((new ImageIcon("H://a.jpg")).getImage());
		bgp1.setBounds(100,50,300,300);
		bgp1.setLayout(null);
		add(bgp1);*/
	    bgp2=new BackgroundPanel(new ImageIcon("4.jpg").getImage());
		bgp2.setBounds(0,0,500,700);
		bgp2.setLayout(null);
		add(bgp2);
		bgp2.add(jl1);
	
       
       button1=new JButton("��    ѯ");
       button1.setBounds(25,380,180,50); 
       button1.setFont(new Font("��Բ", Font.PLAIN, 20));
       button1 .setBackground(Color.white);
     //  button1 .setBackground(new Color(250,250,250));
      button1.addActionListener(this);//��ӹ���
       bgp2.add(button1);
       ImageIcon inquire;
       inquire=new ImageIcon("��3.jpg");
	   Image temp3=inquire.getImage().getScaledInstance(60,60,inquire.getImage().SCALE_DEFAULT);
	   inquire=new ImageIcon(temp3);
	   button1.setIcon(inquire);//��Ӱ�ť
       
       button2=new JButton("�޸���Ϣ");
       button2.setBounds(25,480,180,50);
       button2.setFont(new Font("��Բ", Font.PLAIN, 20));
       button2.setBackground(Color.white);
      //button2 .setBackground(new Color(250,250,250));
      button2.addActionListener(this);//��ӹ���
       bgp2.add(button2);
       ImageIcon exit;
       exit=new ImageIcon("��4.jpg");
	   Image temp4=exit.getImage().getScaledInstance(60,60,exit.getImage().SCALE_DEFAULT);
	   exit=new ImageIcon(temp4);
	   button2.setIcon(exit);//��Ӱ�ť
}

public void actionPerformed(ActionEvent e) {
	if(e.getSource()== button2) {
	     new Modify(s1,s2);
	}
	 if(e.getSource()== button1){
           new User_CX(s1);
                 }
	
}

}


