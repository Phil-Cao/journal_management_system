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

public class ManagerDJNFrame extends JFrame implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JTextField text1,text2,text3,text4,text5,text6;
	JButton RegisterButton, ResetButton;
	BackgroundPanel bgp;
	static Connection con=JavaCoSQL.getConnection();
	static ResultSet  res;
	static PreparedStatement  pst;
	static Statement  st;
	public ManagerDJNFrame(){
		setTitle("�Ǽ����ݽ���");
		setBounds(400,0,500,700);		
		setLayout(null);		
		init1();   //��ӿؼ��Ĳ�����װ��һ������         
		setVisible(true);//��������������ִ��
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//������Ӻ����ڲ�����
	void init1() {
		bgp=new BackgroundPanel((new ImageIcon("back2.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
		jl1=new JLabel("�ڿ���ţ�");
		jl1.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl1.setBounds(60,70,100,35);
	    bgp.add(jl1);	       
	    text1=new JTextField(30);
	    text1.setBounds(160,70,230,35);
	    text1.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text1);
	    
	    jl2=new JLabel("������Ŀ��");
		jl2.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl2.setBounds(60,135,100,35);
	    bgp.add(jl2);	       
	    text2=new JTextField(30);
	    text2.setBounds(160,135,230,35);
	    text2.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text2);
	    
	    jl3=new JLabel("����������");
		jl3.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl3.setBounds(60,195,100,35);
	    bgp.add(jl3);	       
	    text3=new JTextField(30);
	    text3.setBounds(160,195,230,35);
	    text3.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text3);
	     
	    jl4=new JLabel("�� �� �ʣ�");
		jl4.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl4.setBounds(60,255,100,35);
	    bgp.add(jl4);	
	    text4=new JTextField(30);
	    text4.setBounds(160,255,230,35);
	    text4.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text4);
	    
	    jl5=new JLabel("ҳ    �룺");
		jl5.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl5.setBounds(60,325,100,35);
	    bgp.add(jl5);	
	    text5=new JTextField(30);
	    text5.setBounds(160,325,230,35);
	    text5.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text5);
	      
	       
	    RegisterButton=new JButton("��   ��");
	    RegisterButton.setFont(new Font("��Բ",Font.PLAIN,20));
	    RegisterButton.setBounds(50,395,180,50);
	    RegisterButton .setBackground(Color.white);
	    RegisterButton.addActionListener(this);
	    bgp.add(RegisterButton);
	    ImageIcon register;
		 register=new ImageIcon("��1.jpg");
		 Image temp1=register.getImage().getScaledInstance(60,60,register.getImage().SCALE_DEFAULT);
		 register=new ImageIcon(temp1);
		 RegisterButton.setIcon(register);//��Ӱ�ť
	    
		  ResetButton=new JButton("��   ��");
		    ResetButton.setFont(new Font("��Բ",Font.PLAIN,20));
		    ResetButton.setBounds(270,395,180,50);
		    ResetButton .setBackground(Color.white);
		    ResetButton.addActionListener(this);
		    bgp.add(ResetButton);
		    ImageIcon Reset;
		    Reset=new ImageIcon("��4.jpg");
			 Image temp2=Reset.getImage().getScaledInstance(60,60,Reset.getImage().SCALE_DEFAULT);
			 Reset=new ImageIcon(temp2);
			 ResetButton.setIcon(Reset);//��Ӱ�ť*/
		
	}

	  public void actionPerformed(ActionEvent e) {
		  Font font=new Font("��Բ",Font.PLAIN,14);
			UIManager.put("OptionPane.messageFont", font);
			UIManager.put("OptionPane.buttonFont", font);
	  if(e.getSource()==RegisterButton){
		    String Mgz_ID=text1.getText();
			String Title_of_article=text2.getText();
			String Author_name=text3.getText();
			String Keywords=text4.getText();
			String Page_number=text5.getText();
			String sql1="insert into Mgz_cont_Inf values(?,?,?,?,?,?,?,?,?)";
			String sql2="select Mgz_Name,Yeartime,Reel_number,Mgz_Number from Mgz_log_Inf where Mgz_ID='"+text1.getText()+"'";
			//String sql3="select * from Mgz_log_Inf where Mgz_ID='"+Mgz_ID+"'";
			if(text1.getText().equals("")||text2.getText().equals("")||text3.getText().equals("")||text4.getText().equals("")||text5.getText().equals(""))
				JOptionPane.showMessageDialog(this, "�Ǽ�������Ϣ����Ϊ��");
			else{				
				 try {
						st=con.createStatement();
						 res=st.executeQuery(sql2);
						 if(!res.next()){
							 JOptionPane.showMessageDialog(this, "���ڿ���Ų�����");
							 }
						 else {
				    //	st=con.createStatement();
					 //res=st.executeQuery(sql2);
					// while(res.next()) {
					 String Mgz_Name=res.getString("Mgz_Name");
					 String Yeartime=res.getString("Yeartime");
					 String Reel_number=res.getString("Reel_number");
					 String Mgz_Number=res.getString("Mgz_Number");
				            	pst=con.prepareStatement(sql1);
							    pst.setString(1,Mgz_ID);
							    pst.setString(2,Mgz_Name);
							    pst.setString(3,Yeartime);
							    pst.setString(4,Reel_number);
							    pst.setString(5,Mgz_Number);
							    pst.setString(6,Title_of_article);
							    pst.setString(7,Author_name);
							    pst.setString(8,Keywords);
							    pst.setString(9,Page_number);
							    pst.executeUpdate();//���������ļ�				    
							    JOptionPane.showMessageDialog(this, "�Ǽ�������Ϣ�ɹ���");
							   // con.close();
					// }
						 }
				 }
				        catch (Exception exception) {
				            exception.printStackTrace();
				        }			
			
			}
			}
	  if(e.getSource()==ResetButton){
			text1.setText("");
			text2.setText("");
			text3.setText("");
			text4.setText("");
			text5.setText("");

		}
	  
	  

	}
		
	}

