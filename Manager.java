import javax.swing.*;
import java.awt.BorderLayout; 
import java.awt.Image;
import static javax.swing.JFrame.*; //����JFrame�ľ�̬����
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class Manager extends JFrame implements ActionListener{	
	 JButton buttonregister,buttonsubscribe,buttoninquire,buttonexit;	 
	 BackgroundPanel bgp;//�����������
public Manager(){

		setTitle("����Ա����");
		setBounds(0,0,500,700);		
		setLayout(null);		
		init();   //��ӿؼ��Ĳ�����װ��һ������         
		setVisible(true);//��������������ִ��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

//public static void main(String[] args) {
//	new Manager();
//}

void init(){//��ӵĿؼ�
		bgp=new BackgroundPanel((new ImageIcon("back1.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
       
	  buttonregister=new JButton("�Ǽ��ڿ�");
	  buttonregister.setBounds(5,300,180,50);
	  buttonregister.setFont(new Font("��Բ", Font.PLAIN, 20));
	  buttonregister .setBackground(Color.white);
	   bgp.add(buttonregister);
	   ImageIcon register;
	   register=new ImageIcon("��1.jpg");
	   Image temp1=register.getImage().getScaledInstance(60,60,register.getImage().SCALE_DEFAULT);
	   register=new ImageIcon(temp1);
	   buttonregister.setIcon(register);//��Ӱ�ť
	 buttonregister.addActionListener(this);
       
       
	   buttonsubscribe=new JButton("�����ڿ�");
	   buttonsubscribe.setBounds(5,370,180,50);
	   buttonsubscribe.setFont(new Font("��Բ", Font.PLAIN, 20));
	  buttonsubscribe .setBackground(Color.white);
	 buttonsubscribe.addActionListener(this);//��ӹ���
       bgp.add(buttonsubscribe);
       ImageIcon subscribe;
       subscribe=new ImageIcon("��2.jpg");
	   Image temp2=subscribe.getImage().getScaledInstance(60,60,subscribe.getImage().SCALE_DEFAULT);
	   subscribe=new ImageIcon(temp2);
	   buttonsubscribe.setIcon(subscribe);//��Ӱ�ť
       
       buttoninquire=new JButton("��    ѯ");
       buttoninquire.setBounds(5,440,180,50); 
       buttoninquire.setFont(new Font("��Բ", Font.PLAIN, 20));
       buttoninquire .setBackground(Color.white);
      buttoninquire.addActionListener(this);//��ӹ���
       bgp.add(buttoninquire);
       ImageIcon inquire;
       inquire=new ImageIcon("��3.jpg");
	   Image temp3=inquire.getImage().getScaledInstance(60,60,inquire.getImage().SCALE_DEFAULT);
	   inquire=new ImageIcon(temp3);
	   buttoninquire.setIcon(inquire);//��Ӱ�ť
       
       buttonexit=new JButton("��    ��");
       buttonexit.setBounds(5,510,180,50);
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

 if(e.getSource()== buttonregister){
	    new ManagerDJFrame();
	}
	if(e.getSource()==buttonsubscribe) {
		new ManagerZDFrame();
	}
  if(e.getSource()==buttoninquire) {
		 new ManagerCXFrame();
	}
		if(e.getSource()==buttonexit) {
			dispose();
}
	
	}
}


