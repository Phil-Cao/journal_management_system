import javax.swing.*;
import java.awt.BorderLayout; 
import java.awt.Image;
import static javax.swing.JFrame.*; //引入JFrame的静态常量
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


public class ManagerZDFrame extends JFrame implements ActionListener{
	JLabel jl1;
	JTextField text1;
	JButton SeekButton,ResetButton;
	BackgroundPanel bgp;
	static Connection con=JavaCoSQL.getConnection();
	static ResultSet  res;
	static PreparedStatement  pst;
	static Statement  st,st1;
	public ManagerZDFrame(){
		setTitle("查询往年期刊被借情况界面");
		setBounds(200,0,500,700);		
		setLayout(null);		
		init4();   //添加控件的操作封装成一个函数         
		setVisible(true);//放在添加组件后面执行
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//定义添加航班内部窗体
	void init4() {

		bgp=new BackgroundPanel((new ImageIcon("back2.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
		jl1=new JLabel("输入所要查询的年份：");
		jl1.setFont(new Font("幼圆",Font.PLAIN,20));
	    jl1.setBounds(160,70,300,35);
	    bgp.add(jl1);	       
	    text1=new JTextField(30);
	    text1.setBounds(190,130,120,35);
	    text1.setFont(new Font("幼圆",Font.PLAIN,20));
	    bgp.add(text1);
	    
	  
	    SeekButton=new JButton("查   询");
	    SeekButton.setFont(new Font("幼圆",Font.PLAIN,20));
	    SeekButton.setBounds(160,200,180,50);
	    SeekButton .setBackground(Color.white);
	    SeekButton.addActionListener(this);
	    bgp.add(SeekButton);
	    ImageIcon Seek;
	    Seek=new ImageIcon("复2.jpg");
		 Image temp1=Seek.getImage().getScaledInstance(60,60,Seek.getImage().SCALE_DEFAULT);
		 Seek=new ImageIcon(temp1);
		 SeekButton.setIcon(Seek);//添加按钮
	    
		    ResetButton=new JButton("重   置");
		    ResetButton.setFont(new Font("幼圆",Font.PLAIN,20));
		    ResetButton.setBounds(160,270,180,50);
		    ResetButton .setBackground(Color.white);
		    ResetButton.addActionListener(this);
		    bgp.add(ResetButton);
		    ImageIcon Reset;
		    Reset=new ImageIcon("复4.jpg");
			 Image temp2=Reset.getImage().getScaledInstance(60,60,Reset.getImage().SCALE_DEFAULT);
			 Reset=new ImageIcon(temp2);
			 ResetButton.setIcon(Reset);//添加按钮*/

		
	}
	public void actionPerformed(ActionEvent e) {
		Font font=new Font("幼圆",Font.PLAIN,14);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
	  if(e.getSource()==SeekButton){
		  String  keyword=text1.getText();
		   String  sql="select Mgz_name, count(*) as count from Mag_bor_Inf where Yeartime='"+keyword+"'"+" group by Mgz_name";
			String title[]=	{"期刊名","借阅数量","征订"}	;
					try {
			st=con.createStatement();
			res=st.executeQuery(sql);
			if(res.next()) {
				ButtonTZ  vframe=new ButtonTZ(title,sql);
			}
			else {
				JOptionPane.showMessageDialog(this, "没有相关借阅信息！");
				dispose();
			}
			}catch (SQLException e1) {
				e1.printStackTrace();} 
		}
	  if(e.getSource()==ResetButton){
			text1.setText("");

		}
	  
	  
}
}


