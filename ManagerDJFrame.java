import javax.swing.*;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ManagerDJFrame extends JFrame implements ActionListener{
	JButton RegisterMButton,RegisterXButton,RegisterNButton;
	BackgroundPanel bgp;
	static Connection con=JavaCoSQL.getConnection();
	static ResultSet  res;
	static PreparedStatement  pst;
	public ManagerDJFrame(){
		setTitle("登记期刊界面");
		setBounds(200,0,500,700);		
		setLayout(null);		
		init1();   //添加控件的操作封装成一个函数         
		setVisible(true);//放在添加组件后面执行
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//定义添加航班内部窗体
	void init1() {
		bgp=new BackgroundPanel((new ImageIcon("DJ.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
		RegisterMButton=new JButton("目录登记");
		RegisterMButton.setBounds(160,100,180,50);
		RegisterMButton.setFont(new Font("幼圆", Font.PLAIN, 20));
		RegisterMButton .setBackground(Color.white);
		   bgp.add(RegisterMButton);
		   ImageIcon registerM;
		   registerM=new ImageIcon("复1.jpg");
		   Image temp1=registerM.getImage().getScaledInstance(60,60,registerM.getImage().SCALE_DEFAULT);
		   registerM=new ImageIcon(temp1);
		   RegisterMButton.setIcon(registerM);//添加按钮
		   RegisterMButton.addActionListener(this);
	       
	       
		   RegisterXButton=new JButton("信息登记");
		   RegisterXButton.setBounds(160,170,180,50);
		   RegisterXButton.setFont(new Font("幼圆", Font.PLAIN, 20));
		   RegisterXButton .setBackground(Color.white);
		   RegisterXButton.addActionListener(this);//添加关联
	       bgp.add(RegisterXButton);
	       ImageIcon RegisterX;
	       RegisterX=new ImageIcon("复2.jpg");
		   Image temp2=RegisterX.getImage().getScaledInstance(60,60,RegisterX.getImage().SCALE_DEFAULT);
		   RegisterX=new ImageIcon(temp2);
		   RegisterXButton.setIcon(RegisterX);//添加按钮
	       
		   RegisterNButton=new JButton("内容登记");
		   RegisterNButton.setBounds(160,240,180,50); 
		   RegisterNButton.setFont(new Font("幼圆", Font.PLAIN, 20));
		   RegisterNButton.setBackground(Color.white);
		   RegisterNButton.addActionListener(this);//添加关联
	       bgp.add(RegisterNButton);
	       ImageIcon inquire;
	       inquire=new ImageIcon("复3.jpg");
		   Image temp3=inquire.getImage().getScaledInstance(60,60,inquire.getImage().SCALE_DEFAULT);
		   inquire=new ImageIcon(temp3);
		   RegisterNButton.setIcon(inquire);//添加按钮

	  
	    
/*	    ExitButton=new JButton("退    出");
	    ExitButton.setFont(new Font("幼圆",Font.PLAIN,20));
	    ExitButton.setBounds(150,465,180,50);
	    ExitButton .setBackground(Color.white);
	    //ExitButton.addActionListener(this);
	    bgp.add(ExitButton);
	    ImageIcon Exit;
	    Exit=new ImageIcon("复4.jpg");
		 Image temp2=Exit.getImage().getScaledInstance(60,60,Exit.getImage().SCALE_DEFAULT);
		 Exit=new ImageIcon(temp2);
		 ExitButton.setIcon(Exit);//添加按钮*/
		
	}

	  public void actionPerformed(ActionEvent e) {
	  if(e.getSource()==RegisterMButton){
		  new ManagerDJMFrame();
		}
	  if(e.getSource()==RegisterXButton){
		  new ManagerDJXFrame();
		}
	 if(e.getSource()==RegisterNButton){
		  new ManagerDJNFrame();
		}
	}
		
	}

