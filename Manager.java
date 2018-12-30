import javax.swing.*;
import java.awt.BorderLayout; 
import java.awt.Image;
import static javax.swing.JFrame.*; //引入JFrame的静态常量
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class Manager extends JFrame implements ActionListener{	
	 JButton buttonregister,buttonsubscribe,buttoninquire,buttonexit;	 
	 BackgroundPanel bgp;//创建背景面板
public Manager(){

		setTitle("管理员界面");
		setBounds(0,0,500,700);		
		setLayout(null);		
		init();   //添加控件的操作封装成一个函数         
		setVisible(true);//放在添加组件后面执行
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

//public static void main(String[] args) {
//	new Manager();
//}

void init(){//添加的控件
		bgp=new BackgroundPanel((new ImageIcon("back1.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
       
	  buttonregister=new JButton("登记期刊");
	  buttonregister.setBounds(5,300,180,50);
	  buttonregister.setFont(new Font("幼圆", Font.PLAIN, 20));
	  buttonregister .setBackground(Color.white);
	   bgp.add(buttonregister);
	   ImageIcon register;
	   register=new ImageIcon("复1.jpg");
	   Image temp1=register.getImage().getScaledInstance(60,60,register.getImage().SCALE_DEFAULT);
	   register=new ImageIcon(temp1);
	   buttonregister.setIcon(register);//添加按钮
	 buttonregister.addActionListener(this);
       
       
	   buttonsubscribe=new JButton("征订期刊");
	   buttonsubscribe.setBounds(5,370,180,50);
	   buttonsubscribe.setFont(new Font("幼圆", Font.PLAIN, 20));
	  buttonsubscribe .setBackground(Color.white);
	 buttonsubscribe.addActionListener(this);//添加关联
       bgp.add(buttonsubscribe);
       ImageIcon subscribe;
       subscribe=new ImageIcon("复2.jpg");
	   Image temp2=subscribe.getImage().getScaledInstance(60,60,subscribe.getImage().SCALE_DEFAULT);
	   subscribe=new ImageIcon(temp2);
	   buttonsubscribe.setIcon(subscribe);//添加按钮
       
       buttoninquire=new JButton("查    询");
       buttoninquire.setBounds(5,440,180,50); 
       buttoninquire.setFont(new Font("幼圆", Font.PLAIN, 20));
       buttoninquire .setBackground(Color.white);
      buttoninquire.addActionListener(this);//添加关联
       bgp.add(buttoninquire);
       ImageIcon inquire;
       inquire=new ImageIcon("复3.jpg");
	   Image temp3=inquire.getImage().getScaledInstance(60,60,inquire.getImage().SCALE_DEFAULT);
	   inquire=new ImageIcon(temp3);
	   buttoninquire.setIcon(inquire);//添加按钮
       
       buttonexit=new JButton("退    出");
       buttonexit.setBounds(5,510,180,50);
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


