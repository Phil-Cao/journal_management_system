import javax.swing.*;
import static javax.swing.JFrame.*; //引入JFrame的静态常量
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
	 BackgroundPanel bgp;//创建背景面板
	 String id,item;
     public ManagerJYFrame(){
		setTitle("借阅清单查询界面");
		setBounds(80,60,500,500);		
		setLayout(null);		
		init();   //添加控件的操作封装成一个函数         
		setVisible(true);//放在添加组件后面执行
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

     void init(){//添加的控件
    	 String sql="select distinct UserID from User_Inf ";
			bgp=new BackgroundPanel((new ImageIcon("3.jpg")).getImage());
			bgp.setBounds(0,0,500,460);
			bgp.setLayout(null);
			add(bgp);
			
			jl=new JLabel("请选择待查询的用户ID：");
			jl.setBounds(70,100,300,50);
			jl.setFont(new Font("幼圆", Font.PLAIN, 18));
			
			jc=new JComboBox<String>();
			jc.setFont(new Font("幼圆",Font.PLAIN,16));
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
			 
			
		  buttonrequiry=new JButton("查   询");
		  buttonrequiry.setBounds(150,260,180,50);
		  buttonrequiry.setFont(new Font("幼圆", Font.PLAIN, 20));
		  buttonrequiry .setBackground(Color.white);
		  ImageIcon register;
		  register=new ImageIcon("requiry.jpg");
		  Image temp1=register.getImage().getScaledInstance(50,60,register.getImage().SCALE_DEFAULT);
		   register=new ImageIcon(temp1);
		   buttonrequiry.setIcon(register);//添加按钮
		   buttonrequiry.addActionListener(this);
		  
		  bgp.add(jl); bgp.add(jc); bgp.add(buttonrequiry);
     }
	       public void actionPerformed(ActionEvent e) {
	    	   item=String.valueOf(jc.getSelectedItem());
	    		if(item.equals(""))
					JOptionPane.showMessageDialog(this, "读者ID不能为空");     
	    		else {
	    			String sql1="select *  from Mag_bor_Inf  where UserID='"+item+"' ";
	    			String title[]=	{"读者ID","期刊编号","期刊名字","年号","卷号","期号","借阅日期","归还日期","借阅状态"}	;
					try {
			st=con.createStatement();
			res=st.executeQuery(sql1);
			if(res.next()) {
				MyFrame  inqFrame=new MyFrame(title,sql1,"用户借阅情况查询结果界面");
			}
			else {
				JOptionPane.showMessageDialog(this, "查询不到该用户借阅情况");
				dispose();
			}
			}catch (Exception e1) {
				e1.printStackTrace();}
			}
	}
}
