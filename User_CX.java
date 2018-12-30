import javax.swing.*;
import java.awt.BorderLayout; 
import java.awt.Image;
import static javax.swing.JFrame.*; //引入JFrame的静态常量
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class User_CX extends JFrame implements ActionListener{	
	 JButton buttondirection,buttoncontent,buttonborrowlist,buttonexit;	 
	 BackgroundPanel bgp;//创建背景面板
	 String s1;
public User_CX(String s){
		setTitle("用户查询界面");
		setBounds(0,0,500,700);		
		setLayout(null);		
		init();   //添加控件的操作封装成一个函数         
		setVisible(true);//放在添加组件后面执行
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		s1=s;
		System.out.println(s1);
	}


void init(){//添加的控件
		bgp=new BackgroundPanel((new ImageIcon("用户查询1.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
       
		buttondirection=new JButton("期刊去向查询");
		buttondirection.setBounds(110,80,280,50);
		buttondirection.setFont(new Font("幼圆", Font.PLAIN, 20));
		buttondirection.setBackground(Color.white);
	   bgp.add(buttondirection);
	   ImageIcon register;
	   register=new ImageIcon("复1.jpg");
	   Image temp1=register.getImage().getScaledInstance(60,60,register.getImage().SCALE_DEFAULT);
	   register=new ImageIcon(temp1);
	   buttondirection.setIcon(register);//添加按钮
	   buttondirection.addActionListener(this);
       
       
	   buttoncontent=new JButton("期刊内容查询");
	   buttoncontent.setBounds(110,150,280,50);
	   buttoncontent.setFont(new Font("幼圆", Font.PLAIN, 20));
	   buttoncontent.setBackground(Color.white);
	   buttoncontent.addActionListener(this);//添加关联
       bgp.add(buttoncontent);
       ImageIcon subscribe;
       subscribe=new ImageIcon("复3.jpg");
	   Image temp2=subscribe.getImage().getScaledInstance(60,60,subscribe.getImage().SCALE_DEFAULT);
	   subscribe=new ImageIcon(temp2);
	   buttoncontent.setIcon(subscribe);//添加按钮
       
	   buttonborrowlist=new JButton("期刊清单查询");
	   buttonborrowlist.setBounds(110,220,280,50); 
	   buttonborrowlist.setFont(new Font("幼圆", Font.PLAIN, 20));
	   buttonborrowlist.setBackground(Color.white);
	   buttonborrowlist.addActionListener(this);//添加关联
       bgp.add(buttonborrowlist);
       ImageIcon inquire;
       inquire=new ImageIcon("复2.jpg");
	   Image temp3=inquire.getImage().getScaledInstance(60,60,inquire.getImage().SCALE_DEFAULT);
	   inquire=new ImageIcon(temp3);
	   buttonborrowlist.setIcon(inquire);//添加按钮
       
       buttonexit=new JButton("退        出");
       buttonexit.setBounds(110,290,280,50);
       buttonexit.setFont(new Font("宋体", Font.PLAIN, 20));
       buttonexit.setBackground(Color.white);
       buttonexit.addActionListener(this);//添加关联
       bgp.add(buttonexit);
       ImageIcon exit;
       exit=new ImageIcon("复4.jpg");
	   Image temp4=exit.getImage().getScaledInstance(60,60,exit.getImage().SCALE_DEFAULT);
	   exit=new ImageIcon(temp4);
	   buttonexit.setIcon(exit);//添加按钮
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
	   String title[]={"期刊编号 ","期刊名称","出版日期","卷号","期号","借阅时间"};
		  new UserViewFrame(title,sql,"借阅清单查询",s1);
   }
		if(e.getSource()==buttonexit) {
		   dispose();
}	
	}
}
