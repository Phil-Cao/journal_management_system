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
		setTitle("�Ǽ��ڿ�����");
		setBounds(200,0,500,700);		
		setLayout(null);		
		init1();   //��ӿؼ��Ĳ�����װ��һ������         
		setVisible(true);//��������������ִ��
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//������Ӻ����ڲ�����
	void init1() {
		bgp=new BackgroundPanel((new ImageIcon("DJ.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
		RegisterMButton=new JButton("Ŀ¼�Ǽ�");
		RegisterMButton.setBounds(160,100,180,50);
		RegisterMButton.setFont(new Font("��Բ", Font.PLAIN, 20));
		RegisterMButton .setBackground(Color.white);
		   bgp.add(RegisterMButton);
		   ImageIcon registerM;
		   registerM=new ImageIcon("��1.jpg");
		   Image temp1=registerM.getImage().getScaledInstance(60,60,registerM.getImage().SCALE_DEFAULT);
		   registerM=new ImageIcon(temp1);
		   RegisterMButton.setIcon(registerM);//��Ӱ�ť
		   RegisterMButton.addActionListener(this);
	       
	       
		   RegisterXButton=new JButton("��Ϣ�Ǽ�");
		   RegisterXButton.setBounds(160,170,180,50);
		   RegisterXButton.setFont(new Font("��Բ", Font.PLAIN, 20));
		   RegisterXButton .setBackground(Color.white);
		   RegisterXButton.addActionListener(this);//��ӹ���
	       bgp.add(RegisterXButton);
	       ImageIcon RegisterX;
	       RegisterX=new ImageIcon("��2.jpg");
		   Image temp2=RegisterX.getImage().getScaledInstance(60,60,RegisterX.getImage().SCALE_DEFAULT);
		   RegisterX=new ImageIcon(temp2);
		   RegisterXButton.setIcon(RegisterX);//��Ӱ�ť
	       
		   RegisterNButton=new JButton("���ݵǼ�");
		   RegisterNButton.setBounds(160,240,180,50); 
		   RegisterNButton.setFont(new Font("��Բ", Font.PLAIN, 20));
		   RegisterNButton.setBackground(Color.white);
		   RegisterNButton.addActionListener(this);//��ӹ���
	       bgp.add(RegisterNButton);
	       ImageIcon inquire;
	       inquire=new ImageIcon("��3.jpg");
		   Image temp3=inquire.getImage().getScaledInstance(60,60,inquire.getImage().SCALE_DEFAULT);
		   inquire=new ImageIcon(temp3);
		   RegisterNButton.setIcon(inquire);//��Ӱ�ť

	  
	    
/*	    ExitButton=new JButton("��    ��");
	    ExitButton.setFont(new Font("��Բ",Font.PLAIN,20));
	    ExitButton.setBounds(150,465,180,50);
	    ExitButton .setBackground(Color.white);
	    //ExitButton.addActionListener(this);
	    bgp.add(ExitButton);
	    ImageIcon Exit;
	    Exit=new ImageIcon("��4.jpg");
		 Image temp2=Exit.getImage().getScaledInstance(60,60,Exit.getImage().SCALE_DEFAULT);
		 Exit=new ImageIcon(temp2);
		 ExitButton.setIcon(Exit);//��Ӱ�ť*/
		
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

