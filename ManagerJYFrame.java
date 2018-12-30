import javax.swing.*;
import static javax.swing.JFrame.*; //����JFrame�ľ�̬����
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.SimpleDateFormat;
public class ManagerJYFrame extends JFrame implements ActionListener {
	static Connection con=Conn.getConnection();
	static Statement  st,st1;
	static ResultSet  res;
	static PreparedStatement  pst;
	 JButton buttonrequiry;	 
	 JLabel   jl;
	 JComboBox  jc;
	 BackgroundPanel bgp;//�����������
	 String id,item;
     public ManagerJYFrame(){
		setTitle("�����嵥��ѯ����");
		setBounds(80,60,500,500);		
		setLayout(null);		
		init();   //��ӿؼ��Ĳ�����װ��һ������         
		setVisible(true);//��������������ִ��
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

     void init(){//��ӵĿؼ�
    	 String sql="select distinct UserID from User_Inf ";
			bgp=new BackgroundPanel((new ImageIcon("3.jpg")).getImage());
			bgp.setBounds(0,0,500,460);
			bgp.setLayout(null);
			add(bgp);
			
			jl=new JLabel("��ѡ�����ѯ���û�ID��");
			jl.setBounds(70,100,300,50);
			jl.setFont(new Font("��Բ", Font.PLAIN, 18));
			
			jc=new JComboBox<String>();
			jc.setFont(new Font("��Բ",Font.PLAIN,16));
			jc.setBackground(Color.white);
			jc.setBounds(300, 100, 120, 50);
			try {
				st=con.createStatement();
				res=st.executeQuery(sql);
				jc.addItem("");
				while(res.next()) {
					id=res.getString("UserID");
					jc.addItem(id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
			
		  buttonrequiry=new JButton("��   ѯ");
		  buttonrequiry.setBounds(150,260,180,50);
		  buttonrequiry.setFont(new Font("��Բ", Font.PLAIN, 20));
		  buttonrequiry .setBackground(Color.white);
		  ImageIcon register;
		  register=new ImageIcon("requiry.jpg");
		  Image temp1=register.getImage().getScaledInstance(50,60,register.getImage().SCALE_DEFAULT);
		   register=new ImageIcon(temp1);
		   buttonrequiry.setIcon(register);//��Ӱ�ť
		   buttonrequiry.addActionListener(this);
		  
		  bgp.add(jl); bgp.add(jc); bgp.add(buttonrequiry);
     }
	       public void actionPerformed(ActionEvent e) {
	    	   item=String.valueOf(jc.getSelectedItem());
	    		if(item.equals(""))
					JOptionPane.showMessageDialog(this, "����ID����Ϊ��");     
	    		else {
	    			String sql1="select *  from Mag_bor_Inf  where UserID='"+item+"' ";
	    			String title[]=	{"����ID","�ڿ����","�ڿ�����","���","���","�ں�","��������","�黹����","����״̬"}	;
					try {
			st=con.createStatement();
			res=st.executeQuery(sql1);
			if(res.next()) {
				MyFrame  inqFrame=new MyFrame(title,sql1,"�û����������ѯ�������");
			}
			else {
				JOptionPane.showMessageDialog(this, "��ѯ�������û��������");
				dispose();
			}
			}catch (Exception e1) {
				e1.printStackTrace();}
			}
	}
}
