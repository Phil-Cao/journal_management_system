import javax.swing.*;
import java.awt.BorderLayout; 
import java.awt.Image;
import static javax.swing.JFrame.*; //����JFrame�ľ�̬����
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class UserNRFrame extends JFrame implements ActionListener {
	JLabel jl1;
	JTextField text1;
	JButton SeekButton;
	BackgroundPanel bgp;
	static Connection con=Conn.getConnection();
	static Statement  st,st1;
	static ResultSet  res;
	static PreparedStatement  pst;
	String s1;
	public UserNRFrame(String s){
		setTitle("�ڿ����ݲ�ѯ����");
		setBounds(0,0,500,700);		
		setLayout(null);	
		s1=s;
		init2();   //��ӿؼ��Ĳ�����װ��һ������         
		setVisible(true);//��������������ִ��
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}//
	void init2() {
		bgp=new BackgroundPanel((new ImageIcon("�û���ѯ1.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
		jl1=new JLabel("���������ѯ�Ĺؼ��֣�");
		jl1.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl1.setBounds(130,150,300,35);
	    bgp.add(jl1);	       
	    text1=new JTextField(30);
	    text1.setBounds(90,250,300,35);
	    text1.setFont(new Font("��Բ",Font.PLAIN,18));
	    bgp.add(text1);
	    
	    SeekButton=new JButton("��    ѯ");
	    SeekButton.setFont(new Font("��Բ",Font.PLAIN,18));
	    SeekButton.setBounds(150,350,180,40);
	    SeekButton .setBackground(Color.white);
	    SeekButton.addActionListener(this);
	    bgp.add(SeekButton);
	    ImageIcon Seek;
	    Seek=new ImageIcon("��3.jpg");
		 Image temp1=Seek.getImage().getScaledInstance(60,60,Seek.getImage().SCALE_DEFAULT);
		 Seek=new ImageIcon(temp1);
		 SeekButton.setIcon(Seek);//��Ӱ�ť
		 
	}

	public void actionPerformed(ActionEvent e) {
		Font font=new Font("��Բ",Font.PLAIN,14);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		   if(e.getSource()== SeekButton) {
			   String  keyword=text1.getText();
			   String  sql="select distinct Title_of_article,Author_name,Mgz_name,Yeartime,Reel_number,Mgz_Number  from Mgz_cont_Inf  where Keywords='"+keyword+"'";
				String title[]=	{"������Ŀ","����","�ڿ���","���","���","�ں�","�鿴����"}	;
						try {
				st=con.createStatement();
				res=st.executeQuery(sql);
				if(res.next()) {
					ButtonT2  vframe=new ButtonT2(title,sql,s1);
				}
				else {
					JOptionPane.showMessageDialog(this, "û��������ݣ�");
					dispose();
				}
				}catch (SQLException e1) {
					e1.printStackTrace();}
		}
			   
			      
		   }
		         
	}
	