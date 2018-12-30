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
public class RegisterFrame extends JFrame implements ActionListener {
	static Connection con=Conn.getConnection();
	static Statement  st,st1;
	static ResultSet  res;
	static PreparedStatement  pst;
	Container c;
	BackgroundPanel bgp;
	Box box_info,box_field,box_not;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField jt1,jt2,jt3,jt4;
	JLabel b1,b2,b3,b4,b5,b6;
	JPasswordField jpf1,jpf2;
	JButton registerbutton;
	ImageIcon register;
	String number,pword;
	public  RegisterFrame() {
		c=this.getContentPane();
		this.setLayout(null);//不采用任何布局方式
		init();
		setTitle("用户注册");
		this.setSize(450,600);
		this.setLocation(600,80);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	void init() {
		bgp=new BackgroundPanel((new ImageIcon("3.jpg")).getImage());
		bgp.setBounds(0,0, 450, 570);
		c.add(bgp);
		l6=new JLabel("用 户 名：");
		l6.setFont(new Font("幼圆",Font.PLAIN,18));
		l1=new JLabel("用 户 ID：");
		l1.setFont(new Font("幼圆",Font.PLAIN,18));
		l2=new JLabel("用户密码:");
		l2.setFont(new Font("幼圆",Font.PLAIN,18));
		l3=new JLabel("确认密码：");
		l3.setFont(new Font("幼圆",Font.PLAIN,18));
		l4=new JLabel("电    话：");
		l4.setFont(new Font("幼圆",Font.PLAIN,18));
		l5=new JLabel("邮    箱：");
		l5.setFont(new Font("幼圆",Font.PLAIN,18));
		box_info=Box.createVerticalBox();
		box_info.add(Box.createVerticalStrut(15));
		box_info.add(l6);
		box_info.add(Box.createVerticalStrut(40));
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
		
		jt4=new JTextField(10);
		jt4.setFont(new Font("幼圆",Font.PLAIN,18));
		jt4.setOpaque(false);
		jt1=new JTextField(10);
		jt1.setFont(new Font("幼圆",Font.PLAIN,18));
		jt1.setOpaque(false);
		jpf1=new JPasswordField(10);
		jpf1.setEchoChar('*');
		jpf1.setFont(new Font("幼圆",Font.PLAIN,18));
		jpf1.setOpaque(false);
		jpf2=new JPasswordField(10);
		jpf2.setFont(new Font("幼圆",Font.PLAIN,18));
		jpf2.setOpaque(false);
		jpf2.setEchoChar('*');
		jt2=new JTextField(10);
		jt2.setFont(new Font("幼圆",Font.PLAIN,18));
		jt2.setOpaque(false);
		jt3=new JTextField(10);
		jt3.setFont(new Font("幼圆",Font.PLAIN,18));
		jt3.setOpaque(false);
		registerbutton=new JButton("注 册");
		registerbutton.setBackground(Color.white);
		registerbutton.setSize(30, 25);
		register=new ImageIcon("register.jpg");
		Image temp1=register.getImage().getScaledInstance(40, registerbutton.getHeight(), register.getImage().SCALE_DEFAULT);
		register=new ImageIcon(temp1);
		registerbutton.setIcon(register);
		registerbutton.setFont(new Font("幼圆",Font.PLAIN,18));
		registerbutton.addActionListener(this);	
		box_field=Box.createVerticalBox();
		box_field.add(Box.createVerticalStrut(15));
		box_field.add(jt4);
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
		box_field.add(Box.createVerticalStrut(30));
		box_field.add(Box.createHorizontalStrut(40));
		box_field.add(registerbutton);
		bgp.add(box_field);
		
		b6=new JLabel("*真实姓名");
		b6.setFont(new Font("幼圆",Font.PLAIN,14));
		b1=new JLabel("*至少6位的字母或数字");
		b1.setFont(new Font("幼圆",Font.PLAIN,14));
		b2=new JLabel("*至少5位的字符");
		b2.setFont(new Font("幼圆",Font.PLAIN,14));
		b3=new JLabel("*与原密码一致");
		b3.setFont(new Font("幼圆",Font.PLAIN,14));
		b4=new JLabel("*真实电话");
		b4.setFont(new Font("幼圆",Font.PLAIN,14));
		b5=new JLabel("*真实邮箱");
		b5.setFont(new Font("幼圆",Font.PLAIN,14));
		box_not=Box.createVerticalBox();
		box_not.add(Box.createVerticalStrut(30));
		box_not.add(b6);
		box_not.add(Box.createVerticalStrut(45));
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
		String username=jt4.getText();
		String userid=jt1.getText();
		String password1=String.valueOf(jpf1.getPassword());
		String password2=String.valueOf(jpf2.getPassword());
		String t_number=jt2.getText();
		String email=jt3.getText();
		String sql="select * from User_Inf where UserID='"+userid+"'";
		String sql1="insert into User_Inf values(?,?,?,?,?,? )";
		String sql2="select * from  User_Inf  where  User_mailbox='"+email+"'";
		if(username.equals("")||userid.equals("")||password1.equals("")
				||password2.equals("")||t_number.equals("")||email.equals(""))
			    JOptionPane.showMessageDialog(this, "填入的信息不能为空!");
		else  if(!password1.equals(password2))
			   JOptionPane.showMessageDialog(this, "两次输入的密码不一致，请重新输入!");
	   else {
		   if(userid.length()<6)
			    JOptionPane.showMessageDialog(this, "用户ID至少为6位的字母或数字!");
		   else if( isletdig(userid)!=userid.length())
			   JOptionPane.showMessageDialog(this, "用户ID不能包含除字母、数字以外的字符!");
		   else  if(password1.length()<5)
			    JOptionPane.showMessageDialog(this, "密码至少为5位的字符!");
		   else if(t_number.length()<11)
			    JOptionPane.showMessageDialog(this, "此电话不存在!");
		   else if(email.indexOf("@")==-1)
			     JOptionPane.showMessageDialog(this, "此邮箱不存在!");
		   else {
		try { st=con.createStatement();  
				res=st.executeQuery(sql);
			    if(res.next()) {
			    	JOptionPane.showMessageDialog(this, "用户ID已存在！");
			    	 jt1.setText("");
			    	}
			   else if(st.executeQuery(sql2).next()){
			    	JOptionPane.showMessageDialog(this, "此邮箱已存在！");
			    	 jt3.setText("");
			    }
			    else {
			    pst=con.prepareStatement(sql1);
			    pst.setString(1, userid);
			    pst.setString(2, username);
			    pst.setString(3,password1);
			    pst.setString(4,t_number);
			    pst.setString(5,email);
			    pst.setInt(6,0);
			    pst.executeUpdate();//更新数据库
			    JOptionPane.showMessageDialog(this, "注册成功！");
			    dispose();
			    new LoginFrame();
			    }
			    } catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
}
	}
}
