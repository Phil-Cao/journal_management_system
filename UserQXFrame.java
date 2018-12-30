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


public class UserQXFrame extends JFrame implements ActionListener {
    static Connection con=Conn.getConnection();
	static Statement  st,st1;
	static ResultSet  res;
	static PreparedStatement  pst;
	JLabel jl1,jl3,jl5;
	JTextField text1,text2,text3,text4,text5;
	JButton SeekButton,ExitButton;
	BackgroundPanel bgp;
	public UserQXFrame(){
		setTitle("�ڿ�ȥ���ѯ����");
		setBounds(200,0,500,700);		
		setLayout(null);		
		init3();   //��ӿؼ��Ĳ�����װ��һ������         
		setVisible(true);//��������������ִ��
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	void init3() {
		bgp=new BackgroundPanel((new ImageIcon("�û���ѯ1.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
		jl1=new JLabel("�� �� ����");
		jl1.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl1.setBounds(60,120,100,35);
	    bgp.add(jl1);	       
	    text1=new JTextField(30);
	    text1.setBounds(160,120,230,35);
	    text1.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text1);
	    
	    
	    
	    jl3=new JLabel("��    �ݣ�");
		jl3.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl3.setBounds(60,200,100,35);
	    bgp.add(jl3);	       
	    text3=new JTextField(30);
	    text3.setBounds(160,200,230,35);
	    text3.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text3);
	     

	    jl5=new JLabel("��    �ţ�");
		jl5.setFont(new Font("��Բ",Font.PLAIN,20));
	    jl5.setBounds(60,280,100,35);
	    bgp.add(jl5);	
	    text5=new JTextField(30);
	    text5.setBounds(160,280,230,35);
	    text5.setFont(new Font("��Բ",Font.PLAIN,20));
	    bgp.add(text5);
	    
	    
	    SeekButton=new JButton("��    ѯ");
	    SeekButton.setFont(new Font("��Բ",Font.PLAIN,20));
	    SeekButton.setBounds(160,355,200,50);
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
	
		String mgz_name=text1.getText();
		String yeartime=text3.getText();
        String mgz_number=text5.getText();	
        String sql1="select * from Mag_bor_Inf where Mgz_name='"+mgz_name+"' and  Yeartime='"+yeartime+"'and Mgz_number='"+mgz_number+"'";
		if(mgz_name.equals("")||yeartime.equals("")||mgz_number.equals(""))
			JOptionPane.showMessageDialog(this, "��ѯ��Ϣ����Ϊ��");
		else {
				String title[]=	{"��������","�ڿ����","�ڿ���","���","���","�ں�","���ʱ��","�黹ʱ��","״̬"};
			try {
			st=con.createStatement();
			res=st.executeQuery(sql1);
			if(res.next()) {
				MyFrame  QXFrame=new MyFrame(title,sql1,"ȥ���ѯ�������");
			}
			else {
				JOptionPane.showMessageDialog(this, "��ѯ���������Ϣ");
			}
			}catch (SQLException e1) {
				e1.printStackTrace();}
			}}
				}


