import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
public class Modify extends JFrame implements ActionListener {
	static Connection con=Conn.getConnection();
	static Statement  st,st1;
	static ResultSet  res;
	static PreparedStatement  pst;
	Container c;
	BackgroundPanel bgp;
	Box box_info,box_field,box_not;
	JLabel l1,l2,l3,l4,l5;
	JTextField jt2,jt3;
	JLabel b1,b2,b3,b4,b5;
	JPasswordField jt1,jpf1,jpf2;
	JButton registerbutton;
	ImageIcon register;
	String number,pword;
	String s1,s2;
	public  Modify(String s,String s0) {
		c=this.getContentPane();
		this.setLayout(null);//不采用任何布局方式
		init();
		setTitle("修改个人信息");
		this.setSize(450,480);
		this.setLocation(600,80);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		s1=s;s2=s0;
		String userid=s1;
		String pwd=s2;
	}
	void init() {
		bgp=new BackgroundPanel((new ImageIcon("5.jpg")).getImage());
		bgp.setBounds(0,0, 450, 480);
		c.add(bgp);
		l1=new JLabel(" 原密码");
		l1.setFont(new Font("幼圆",Font.PLAIN,18));
		l2=new JLabel(" 新密码");
		l2.setFont(new Font("幼圆",Font.PLAIN,18));
		l3=new JLabel("确认密码");
		l3.setFont(new Font("幼圆",Font.PLAIN,18));
		l4=new JLabel("电    话");
		l4.setFont(new Font("幼圆",Font.PLAIN,18));
		l5=new JLabel("邮    箱");
		l5.setFont(new Font("幼圆",Font.PLAIN,18));
		box_info=Box.createVerticalBox();
		box_info.add(Box.createVerticalStrut(30));
		box_info.add(l1);
		box_info.add(Box.createVerticalStrut(40));
		box_info.add(l2);
		box_info.add(Box.createVerticalStrut(40));
		box_info.add(l3);
		box_info.add(Box.createVerticalStrut(40));
		box_info.add(l4);
		box_info.add(Box.createVerticalStrut(40));
		box_info.add(l5);
		box_info.add(Box.createVerticalStrut(70));
		bgp.add(box_info);
		
		jt1=new JPasswordField(10);
		jt1.setFont(new Font("幼圆",Font.PLAIN,18));
		jt1.setEchoChar('*');
		jpf1=new JPasswordField(10);
		jpf1.setEchoChar('*');
		jpf1.setFont(new Font("幼圆",Font.PLAIN,18));
		jpf2=new JPasswordField(10);
		jpf2.setEchoChar('*');
		jpf2.setFont(new Font("幼圆",Font.PLAIN,18));
		jt2=new JTextField(10);
		jt2.setFont(new Font("幼圆",Font.PLAIN,18));
		jt3=new JTextField(10);
		jt3.setFont(new Font("幼圆",Font.PLAIN,18));
		registerbutton=new JButton("修 改");
		registerbutton.setBackground(Color.white);
		registerbutton.setSize(30, 25);
		register=new ImageIcon("register.jpg");
		Image temp1=register.getImage().getScaledInstance(40, registerbutton.getHeight(), register.getImage().SCALE_DEFAULT);
		register=new ImageIcon(temp1);
		registerbutton.setIcon(register);
		registerbutton.setFont(new Font("幼圆",Font.PLAIN,18));
		registerbutton.addActionListener(this);	
		box_field=Box.createVerticalBox();
		box_field.add(Box.createVerticalStrut(35));
		box_field.add(jt1);
		box_field.add(Box.createVerticalStrut(35));
		box_field.add(jpf1);
		box_field.add(Box.createVerticalStrut(35));
		box_field.add(jpf2);
		box_field.add(Box.createVerticalStrut(35));
		box_field.add(jt2);
		box_field.add(Box.createVerticalStrut(35));
		box_field.add(jt3);
		box_field.add(Box.createVerticalStrut(40));
		box_field.add(registerbutton);
		bgp.add(box_field);
		
		b1=new JLabel(" ");
		b1.setFont(new Font("幼圆",Font.PLAIN,14));
		b2=new JLabel("*至少5位的字母或数字");
		b2.setFont(new Font("幼圆",Font.PLAIN,14));
		b3=new JLabel("*与原密码一致");
		b3.setFont(new Font("幼圆",Font.PLAIN,14));
		b4=new JLabel("");
		b4.setSize(100, 40);
		b4.setFont(new Font("幼圆",Font.PLAIN,14));
		b5=new JLabel("");
		b5.setFont(new Font("幼圆",Font.PLAIN,14));
		box_not=Box.createVerticalBox();
		box_not.add(Box.createVerticalStrut(0));
		box_not.add(b1);
		box_not.add(Box.createVerticalStrut(45));
		box_not.add(b2);
		box_not.add(Box.createVerticalStrut(45));
		box_not.add(b3);
		box_not.add(Box.createVerticalStrut(45));
		box_not.add(b4);
		box_not.add(Box.createVerticalStrut(40));
		box_not.add(b5);
		box_not.add(Box.createVerticalStrut(70));
		bgp.add(box_not);
	}
	public int isletdig(String  str) {
		   int count=0;
		   for(int i=0;i<str.length();i++)
			   if(Character.isDigit(str.charAt(i))||Character.isLetter(str.charAt(i)))
				    count++;
		   return  count;
	}
	public void actionPerformed(ActionEvent e) {
		Font font=new Font("幼圆",Font.PLAIN,14);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		String userid=s1;String pwd=s2;
		String password0=String.valueOf(jt1.getPassword());
		String password1=String.valueOf(jpf1.getPassword());
		String password2=String.valueOf(jpf2.getPassword());
		String t_number=jt2.getText();
		String email=jt3.getText();
		String sql1="update User_Inf set User_Password=?,User_number=?,User_mailbox=? where UserID='"+userid+"'";
		String sql2="select * from  User_Inf  where  User_mailbox='"+email+"'";
		if(password0.equals("")||password1.equals("")
				||password2.equals("")||t_number.equals("")||email.equals(""))
			    JOptionPane.showMessageDialog(this, "填入的信息不能为空!");
		else  if(!password0.equals(pwd)){
			   JOptionPane.showMessageDialog(this, "原密码错误，请重新输入!");
		       jt1.setText("");}
		else  if(password0.equals(password1)){
			   JOptionPane.showMessageDialog(this, "新密码与原密码一致，请重新输入!");
		       jpf1.setText("");jpf2.setText("");}
		else  if(!password1.equals(password2)){
			   JOptionPane.showMessageDialog(this, "两次输入的新密码不一致，请重新输入!");
		        jpf2.setText("");} 
	   else {
		    if(password1.length()<5){
			    JOptionPane.showMessageDialog(this, "密码至少为5位的字符!");
		    jpf1.setText("");}
		   else if(t_number.length()<11){
			    JOptionPane.showMessageDialog(this, "此电话不存在!");
		         jt2.setText("");}
		   else if(email.indexOf("@")==-1){
			     JOptionPane.showMessageDialog(this, "此邮箱不存在!");
		         jt3.setText("");}
		   else {
		try { st=con.createStatement();  
				res=st.executeQuery(sql2);
			    if(res.next()) {
			    	JOptionPane.showMessageDialog(this, "此邮箱已存在！");
			    	 jt3.setText("");
			    }
			    else {
			    pst=con.prepareStatement(sql1);
			    pst.setString(1,password1);
			    pst.setString(2,t_number);
			    pst.setString(3,email);
			    pst.executeUpdate();//更新数据库
			    JOptionPane.showMessageDialog(this, "更新成功！");
			    dispose();
			    }
			    } catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	   }}}
