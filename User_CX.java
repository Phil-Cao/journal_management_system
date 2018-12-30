import javax.swing.*;
import java.awt.BorderLayout; 
import java.awt.Image;
import static javax.swing.JFrame.*; //����JFrame�ľ�̬����
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class User_CX extends JFrame implements ActionListener{	
	 JButton buttondirection,buttoncontent,buttonborrowlist,buttonexit;	 
	 BackgroundPanel bgp;//�����������
	 String s1;
public User_CX(String s){
		setTitle("�û���ѯ����");
		setBounds(0,0,500,700);		
		setLayout(null);		
		init();   //��ӿؼ��Ĳ�����װ��һ������         
		setVisible(true);//��������������ִ��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		s1=s;
		System.out.println(s1);
	}


void init(){//��ӵĿؼ�
		bgp=new BackgroundPanel((new ImageIcon("�û���ѯ1.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
       
		buttondirection=new JButton("�ڿ�ȥ���ѯ");
		buttondirection.setBounds(110,80,280,50);
		buttondirection.setFont(new Font("��Բ", Font.PLAIN, 20));
		buttondirection.setBackground(Color.white);
	   bgp.add(buttondirection);
	   ImageIcon register;
	   register=new ImageIcon("��1.jpg");
	   Image temp1=register.getImage().getScaledInstance(60,60,register.getImage().SCALE_DEFAULT);
	   register=new ImageIcon(temp1);
	   buttondirection.setIcon(register);//��Ӱ�ť
	   buttondirection.addActionListener(this);
       
       
	   buttoncontent=new JButton("�ڿ����ݲ�ѯ");
	   buttoncontent.setBounds(110,150,280,50);
	   buttoncontent.setFont(new Font("��Բ", Font.PLAIN, 20));
	   buttoncontent.setBackground(Color.white);
	   buttoncontent.addActionListener(this);//��ӹ���
       bgp.add(buttoncontent);
       ImageIcon subscribe;
       subscribe=new ImageIcon("��3.jpg");
	   Image temp2=subscribe.getImage().getScaledInstance(60,60,subscribe.getImage().SCALE_DEFAULT);
	   subscribe=new ImageIcon(temp2);
	   buttoncontent.setIcon(subscribe);//��Ӱ�ť
       
	   buttonborrowlist=new JButton("�ڿ��嵥��ѯ");
	   buttonborrowlist.setBounds(110,220,280,50); 
	   buttonborrowlist.setFont(new Font("��Բ", Font.PLAIN, 20));
	   buttonborrowlist.setBackground(Color.white);
	   buttonborrowlist.addActionListener(this);//��ӹ���
       bgp.add(buttonborrowlist);
       ImageIcon inquire;
       inquire=new ImageIcon("��2.jpg");
	   Image temp3=inquire.getImage().getScaledInstance(60,60,inquire.getImage().SCALE_DEFAULT);
	   inquire=new ImageIcon(temp3);
	   buttonborrowlist.setIcon(inquire);//��Ӱ�ť
       
       buttonexit=new JButton("��        ��");
       buttonexit.setBounds(110,290,280,50);
       buttonexit.setFont(new Font("����", Font.PLAIN, 20));
       buttonexit.setBackground(Color.white);
       buttonexit.addActionListener(this);//��ӹ���
       bgp.add(buttonexit);
       ImageIcon exit;
       exit=new ImageIcon("��4.jpg");
	   Image temp4=exit.getImage().getScaledInstance(60,60,exit.getImage().SCALE_DEFAULT);
	   exit=new ImageIcon(temp4);
	   buttonexit.setIcon(exit);//��Ӱ�ť
}

public void actionPerformed(ActionEvent e) {

 if(e.getSource()== buttondirection){
	 new UserQXFrame();
	}
	if(e.getSource()==buttoncontent) {
		 new UserNRFrame(s1);
	}
   if(e.getSource()==buttonborrowlist) {
	   String sql="select Mgz_ID,Mgz_name,Yeartime,Reel_number,Mgz_number,Borrowdate from  Mag_bor_Inf where UserID='"+s1+"' and Returneddate is NULL";
	   String title[]={"�ڿ���� ","�ڿ�����","��������","���","�ں�","����ʱ��"};
		  new UserViewFrame(title,sql,"�����嵥��ѯ",s1);
   }
		if(e.getSource()==buttonexit) {
		   dispose();
}	
	}
}
