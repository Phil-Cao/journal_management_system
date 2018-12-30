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

public class ManagerDJMFrame extends JFrame implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;
	JButton RegisterButton,ResetButton;
	BackgroundPanel bgp;
	static Connection con=JavaCoSQL.getConnection();
	static ResultSet  res;
	static PreparedStatement  pst;
	public ManagerDJMFrame(){
		setTitle("�Ǽ�Ŀ¼����");
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
		jl1=new JLabel("�� �� ����");
		jl1.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl1.setBounds(60,20,100,35);
	    bgp.add(jl1);	       
	    text1=new JTextField(30);
	    text1.setBounds(160,20,230,35);
	    text1.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text1);
	    
	    jl2=new JLabel("CN �� �ţ�");
		jl2.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl2.setBounds(60,75,100,35);
	    bgp.add(jl2);	       
	    text2=new JTextField(30);
	    text2.setBounds(160,75,230,35);
	    text2.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text2);
	    
	    jl3=new JLabel("��    �ݣ�");
		jl3.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl3.setBounds(60,130,100,35);
	    bgp.add(jl3);	       
	    text3=new JTextField(30);
	    text3.setBounds(160,130,230,35);
	    text3.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text3);
	     
	    jl4=new JLabel("��    �ţ�");
		jl4.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl4.setBounds(60,185,100,35);
	    bgp.add(jl4);	
	    text4=new JTextField(30);
	    text4.setBounds(160,185,230,35);
	    text4.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text4);
	    
	    jl5=new JLabel("ISSN��");
		jl5.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl5.setBounds(60,240,100,35);
	    bgp.add(jl5);	
	    text5=new JTextField(30);
	    text5.setBounds(160,240,230,35);
	    text5.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text5);
	    
	    jl6=new JLabel("�ʷ����ţ�");
	 	jl6.setFont(new Font("��Բ",Font.PLAIN,20));
	 	jl6.setBounds(60,295,100,35);
	 	bgp.add(jl6);	
	 	text6=new JTextField(30);
	 	text6.setBounds(160,295,230,35);
	 	text6.setFont(new Font("��Բ",Font.PLAIN,20));
	 	bgp.add(text6);
	 	
	 	jl7=new JLabel("�������ڣ�");
	 	jl7.setFont(new Font("��Բ",Font.PLAIN,20));
	 	jl7.setBounds(60,350,100,35);
	 	bgp.add(jl7);	
	 	text7=new JTextField(30);
	 	text7.setBounds(160,350,230,35);
	 	text7.setFont(new Font("��Բ",Font.PLAIN,20));
	 	bgp.add(text7);
	 	
	 	jl8=new JLabel("�� �� �أ�");
	 	jl8.setFont(new Font("��Բ",Font.PLAIN,20));
	 	jl8.setBounds(60,405,100,35);
	 	bgp.add(jl8);	
	 	text8=new JTextField(30);
	 	text8.setBounds(160,405,230,35);
	 	text8.setFont(new Font("��Բ",Font.PLAIN,20));
	 	bgp.add(text8);
	 	
	 	jl9=new JLabel("���쵥λ��");
	 	jl9.setFont(new Font("��Բ",Font.PLAIN,20));
	 	jl9.setBounds(60,460,100,35);
	 	bgp.add(jl9);	
	 	text9=new JTextField(30);
	 	text9.setBounds(160,460,230,35);
	 	text9.setFont(new Font("��Բ",Font.PLAIN,20));
	 	bgp.add(text9);
	    
		jl10=new JLabel("��    ����");
	 	jl10.setFont(new Font("��Բ",Font.PLAIN,20));
	 	jl10.setBounds(60,515,100,35);
	 	bgp.add(jl10);	
	 	text10=new JTextField(30);
	 	text10.setBounds(160,515,230,35);
	 	text10.setFont(new Font("��Բ",Font.PLAIN,20));
	 	bgp.add(text10);

	    
	    RegisterButton=new JButton("��   ��");
	    RegisterButton.setFont(new Font("��Բ",Font.PLAIN,20));
	    RegisterButton.setBounds(50,575,180,50);
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
	    ResetButton.setBounds(270,575,180,50);
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
		    String Mgz_Name=text1.getText();
			String CN_Number=text2.getText();
			String Yeartime=text3.getText();
			String Mgz_Number=text4.getText();
			String ISSN_Number=text5.getText();
			String Mgz_PostNumber=text6.getText();
			String Mgz_Period=text7.getText();
			String Mgz_PublishingCity=text8.getText();
			String Host_unit=text9.getText();
			String M_count=text10.getText();
			String sql="insert into Mgz_dir_Inf values(?,?,?,?,?,?,?,?,?,?)";
			if(text1.getText().equals("")||text2.getText().equals("")||text3.getText().equals("")||text4.getText().equals("")||text5.getText().equals("")||text6.getText().equals("")||text7.getText().equals("")||text8.getText().equals("")||text9.getText().equals("")||text10.getText().equals(""))
				JOptionPane.showMessageDialog(this, "�Ǽ�Ŀ¼��Ϣ����Ϊ��");
			else{				
				 try {
				            	pst=con.prepareStatement(sql);
							    pst.setString(1,Mgz_Name);
							    pst.setString(2,CN_Number);
							    pst.setString(3,Yeartime);
							    pst.setString(4,Mgz_Number);
							    pst.setString(5,ISSN_Number);
							    pst.setString(6,Mgz_PostNumber);
							    pst.setString(7,Mgz_Period);
							    pst.setString(8,Mgz_PublishingCity);
							    pst.setString(9,Host_unit);
							    pst.setString(10,M_count);
							    pst.executeUpdate();//�������ݿ�
							    JOptionPane.showMessageDialog(this, "�Ǽ�Ŀ¼��Ϣ�ɹ���");
							  //  con.close();
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
			text6.setText("");
			text7.setText("");
			text8.setText("");
			text9.setText("");
			text10.setText("");
		}

	}
		
	}

