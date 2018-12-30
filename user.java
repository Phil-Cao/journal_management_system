import javax.swing.*;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import static javax.swing.JFrame.*; //引入JFrame的静态常量
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class user extends JFrame implements ActionListener{	
	JButton button1,button2;JLabel jl1;	 
	BackgroundPanel bgp2;//创建背景面板	 
	String s1,s2;
public user(String s,String s0){

	setTitle("读者界面");
	setBounds(0,0,480,700);			
		setLayout(null);		
		init();   //添加控件的操作封装成一个函数         
		setVisible(true);//放在添加组件后面执行
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		s1=s;s2=s0;
	}

void init(){//添加的控件
	String str1="               尊敬的读者";
	String str2="欢迎您使用本系统";
	String str3="<html><body>"+str1+"<br>"+str2+"<body><html>";
	
	 jl1=new JLabel(str3);
	
		jl1.setBounds(0,40,480,120);
		jl1.setFont(new Font("幼圆",Font.PLAIN,36));
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
	
       
       button1=new JButton("查    询");
       button1.setBounds(25,380,180,50); 
       button1.setFont(new Font("幼圆", Font.PLAIN, 20));
       button1 .setBackground(Color.white);
     //  button1 .setBackground(new Color(250,250,250));
      button1.addActionListener(this);//添加关联
       bgp2.add(button1);
       ImageIcon inquire;
       inquire=new ImageIcon("复3.jpg");
	   Image temp3=inquire.getImage().getScaledInstance(60,60,inquire.getImage().SCALE_DEFAULT);
	   inquire=new ImageIcon(temp3);
	   button1.setIcon(inquire);//添加按钮
       
       button2=new JButton("修改信息");
       button2.setBounds(25,480,180,50);
       button2.setFont(new Font("幼圆", Font.PLAIN, 20));
       button2.setBackground(Color.white);
      //button2 .setBackground(new Color(250,250,250));
      button2.addActionListener(this);//添加关联
       bgp2.add(button2);
       ImageIcon exit;
       exit=new ImageIcon("复4.jpg");
	   Image temp4=exit.getImage().getScaledInstance(60,60,exit.getImage().SCALE_DEFAULT);
	   exit=new ImageIcon(temp4);
	   button2.setIcon(exit);//添加按钮
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


