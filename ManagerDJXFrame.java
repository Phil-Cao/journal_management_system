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
import java.sql.Timestamp;
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

public class ManagerDJXFrame extends JFrame implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField text1,text2,text3,text4,text5;
	JButton RegisterButton,ResetButton;
	BackgroundPanel bgp;
	JComboBox  jcb;
	static Connection con=JavaCoSQL.getConnection();
	static ResultSet  res;
	static PreparedStatement  pst;
	static Statement  st;
	public ManagerDJXFrame(){
		setTitle("登记信息界面");
		setBounds(400,0,500,700);		
		setLayout(null);		
		init1();   //添加控件的操作封装成一个函数         
		setVisible(true);//放在添加组件后面执行
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}//定义添加航班内部窗体
	void init1() {
		bgp=new BackgroundPanel((new ImageIcon("back2.jpg")).getImage());
		bgp.setBounds(0,0,500,700);
		bgp.setLayout(null);
		add(bgp);
		jl1=new JLabel("期刊编号：");
		jl1.setFont(new Font("幼圆",Font.PLAIN,20));
	    jl1.setBounds(60,70,100,35);
	    bgp.add(jl1);	       
	    text1=new JTextField(30);
	    text1.setBounds(160,70,230,35);
	    text1.setFont(new Font("幼圆",Font.PLAIN,20));
	    bgp.add(text1);
	    
	    jl2=new JLabel("期 刊 名：");
		jl2.setFont(new Font("幼圆",Font.PLAIN,20));
	    jl2.setBounds(60,135,100,35);
	    bgp.add(jl2);	       
	    text2=new JTextField(30);
	    text2.setBounds(160,135,230,35);
	    text2.setFont(new Font("幼圆",Font.PLAIN,20));
	    bgp.add(text2);
	    
	    jl3=new JLabel("年    份：");
		jl3.setFont(new Font("幼圆",Font.PLAIN,20));
	    jl3.setBounds(60,195,100,35);
	    bgp.add(jl3);	       
	    text3=new JTextField(30);
	    text3.setBounds(160,195,230,35);
	    text3.setFont(new Font("幼圆",Font.PLAIN,20));
	    bgp.add(text3);
	     
	    jl4=new JLabel("卷    号：");
		jl4.setFont(new Font("幼圆",Font.PLAIN,20));
	    jl4.setBounds(60,255,100,35);
	    bgp.add(jl4);	
	    text4=new JTextField(30);
	    text4.setBounds(160,255,230,35);
	    text4.setFont(new Font("幼圆",Font.PLAIN,20));
	    bgp.add(text4);
	    
	    jl5=new JLabel("期    号：");
		jl5.setFont(new Font("幼圆",Font.PLAIN,20));
	    jl5.setBounds(60,325,100,35);
	    bgp.add(jl5);	
	    text5=new JTextField(30);
	    text5.setBounds(160,325,230,35);
	    text5.setFont(new Font("幼圆",Font.PLAIN,20));
	    bgp.add(text5);
	    

	    
	    jl7=new JLabel("期刊状态：");
	 	 	jl7.setFont(new Font("幼圆",Font.PLAIN,20));
	 	 	jl7.setBounds(60,395,100,35);
	 	 	bgp.add(jl7);
	 		 jcb=new JComboBox();
	 		jcb.setOpaque(true);
	 		jcb.setFont(new Font("幼圆",Font.PLAIN,18));
	 		jcb.setBounds(160,395,230,35);
	 		jcb.addItem("");
	 		jcb.addItem("在馆");
	 		jcb.addItem("借出");
	 	     bgp.add(jcb);

	    
	    RegisterButton=new JButton("登   记");
	    RegisterButton.setFont(new Font("幼圆",Font.PLAIN,20));
	    RegisterButton.setBounds(50,535,180,50);
	    RegisterButton .setBackground(Color.white);
	    RegisterButton.addActionListener(this);
	    bgp.add(RegisterButton);
	    ImageIcon register;
		 register=new ImageIcon("复1.jpg");
		 Image temp1=register.getImage().getScaledInstance(60,60,register.getImage().SCALE_DEFAULT);
		 register=new ImageIcon(temp1);
		 RegisterButton.setIcon(register);//添加按钮
	    
		    ResetButton=new JButton("重   置");
		    ResetButton.setFont(new Font("幼圆",Font.PLAIN,20));
		    ResetButton.setBounds(270,535,180,50);
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
	  if(e.getSource()==RegisterButton){
		    String Mgz_ID=text1.getText();
			String Mgz_Name=text2.getText();
			String Yeartime=text3.getText();
			String Reel_number=text4.getText();
			String Mgz_Number=text5.getText();
			SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();  
		    Timestamp timeStamp = new Timestamp(date.getTime());
		    String time=df.format(timeStamp);
			String Mgz_state=String.valueOf(jcb.getSelectedItem());
			String sql1="insert into Mgz_log_Inf values(?,?,?,?,?,?,?)";
			String sql2="update Mgz_dir_Inf set M_count=M_count+1 where Mgz_Name='"+text2.getText()+"'";
			String sql3="select * from Mgz_log_Inf where Mgz_ID='"+Mgz_ID+"'";
            if(text1.getText().equals("")||text2.getText().equals("")||text3.getText().equals("")||text4.getText().equals("")||text5.getText().equals(""))
				JOptionPane.showMessageDialog(this, "登记信息不能为空");
			 else try {
					st=con.createStatement();
					 res=st.executeQuery(sql3);
					 if(res.next()){
						 JOptionPane.showMessageDialog(this, "该期刊编号已存在");
						 }
			else{				
				
				            	pst=con.prepareStatement(sql1);
							    pst.setString(1,Mgz_ID);
							    pst.setString(2,Mgz_Name);
							    pst.setString(3,Yeartime);
							    pst.setString(4,Reel_number);
							    pst.setString(5,Mgz_Number);
							    pst.setString(6,time);
							    pst.setString(7,Mgz_state);
							    pst.executeUpdate();//更新登记文件
							    
							    pst=con.prepareStatement(sql2);
							    pst.executeUpdate();//更新目录文件
							    
							    JOptionPane.showMessageDialog(this, "登记信息成功！");
							   // con.close();
							    }
			}
			 
				        catch (Exception exception) {
				            exception.printStackTrace();
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

