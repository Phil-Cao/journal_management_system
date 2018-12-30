import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class LoginFrame extends JFrame implements ActionListener,KeyListener {
	static Connection con=Conn.getConnection();
	static Statement  st,st1;
	static ResultSet  res;
	static PreparedStatement  pst;
	Container c;
	BackgroundPanel bgp;
	JLabel user,ps,identity,code;
	JTextField textfield,textfield1;
	JPasswordField password;
	JComboBox  jcb;
	Box box1,box2,box3,box4;
	JButton  loginbutton,clearbutton;
	ImageIcon login,clear;
	 ValidCode vcode;
	public LoginFrame(){//
		c=this.getContentPane();
		this.setLayout(null);//不采用任何布局方式
		init();
		setTitle("用户登录");
		this.setSize(460,500);
		this.setLocation(600,80);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		}
	void init() {
		bgp=new BackgroundPanel((new ImageIcon("2.jpg")).getImage());
		bgp.setBounds(0,0, 460, 460);
		c.add(bgp);
		user=new JLabel("用户ID:");
		user.setFont(new Font("幼圆",Font.PLAIN,18));
		ps=new JLabel("密  码:");
		ps.setFont(new Font("幼圆",Font.PLAIN,18));
		identity=new JLabel("身  份:");
		identity.setFont(new Font("幼圆",Font.PLAIN,18));
		
		box1=Box.createVerticalBox();
		box1.add(Box.createVerticalStrut(45));
		box1.add(user);
		box1.add(Box.createVerticalStrut(40));
		box1.add(ps);
		box1.add(Box.createVerticalStrut(40));
		box1.add(identity);
		box1.add(Box.createVerticalStrut(30));
		bgp.add(box1);
		
		textfield=new JTextField(20);
		textfield.setFont(new Font("幼圆",Font.PLAIN,18));
		textfield.setOpaque(false);
		 password=new JPasswordField(20);
		 password.setEchoChar('*');
		 password.setFont(new Font("幼圆",Font.PLAIN,18));
		 password.setOpaque(false);
		 jcb=new JComboBox();
		jcb.setOpaque(false);
		jcb.setFont(new Font("幼圆",Font.PLAIN,18));
		jcb.addItem("");
		jcb.addItem("读者");
		jcb.addItem("管理员");
		box2=Box.createVerticalBox();
		box2.add(Box.createVerticalStrut(30));
		box2.add(textfield);
		box2.add(Box.createVerticalStrut(30));
		box2.add(password);
		box2.add(Box.createVerticalStrut(30));
		box2.add(jcb);
		box2.add(Box.createVerticalStrut(10));
		bgp.add(box2);
		
		box4=Box.createHorizontalBox();
		textfield1=new JTextField(10);
		textfield1.setFont(new Font("幼圆",Font.PLAIN,18));
		textfield1.setOpaque(false);
		code=new JLabel("验证码:");
		code.setFont(new Font("幼圆",Font.PLAIN,18));
		vcode = new ValidCode();
		box4.add(Box.createHorizontalStrut(15));
		box4.add(code);
		box4.add(Box.createHorizontalStrut(10));
		box4.add(textfield1);
		box4.add(Box.createHorizontalStrut(10));
		box4.add(vcode);
		bgp.add(box4);
		
		 loginbutton=new JButton("登 录");
		 loginbutton.addActionListener(this);
		 loginbutton.setSize(40, 25);
		 loginbutton.setFont(new Font("幼圆",Font.PLAIN,18));
		 loginbutton.setBackground(Color.white);
		 loginbutton.addKeyListener(this);
		 login=new ImageIcon("login.jpg");
		Image temp=login.getImage().getScaledInstance(50, 40, login.getImage().SCALE_DEFAULT);
		login=new ImageIcon(temp);
		loginbutton.setIcon(login);
		 clearbutton=new JButton("重 置");
		 clearbutton.addActionListener(this);
		 clearbutton.setSize(40, 25);
		 clearbutton.setFont(new Font("幼圆",Font.PLAIN,18));
		 clearbutton.setBackground(Color.white);
		 clear=new ImageIcon("复1.jpg");
		Image temp1=clear.getImage().getScaledInstance(50,40, clear.getImage().SCALE_DEFAULT);
		clear=new ImageIcon(temp1);
		clearbutton.setIcon(clear);
		box3=Box.createHorizontalBox();
		box3.add(Box.createVerticalStrut(120));
		box3.add(Box.createHorizontalStrut(50));
		box3.add(loginbutton);
		box3.add(Box.createHorizontalStrut(50));
		box3.add(clearbutton);
		bgp.add(box3);
	}

	public void actionPerformed(ActionEvent e) {
		Font font=new Font("幼圆",Font.PLAIN,14);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		if(e.getSource()==loginbutton) {
			  String username=textfield.getText();
			  String pwd=String.valueOf(password.getPassword());
			 String role=String.valueOf(jcb.getSelectedItem());
			 String verfcode=textfield1.getText();
			 if(username.equals("")||pwd.equals("")) {
					JOptionPane.showMessageDialog(this, "用户名或密码不能为空，请重新输入");
				}
			 if(verfcode.equals(""))
				 JOptionPane.showMessageDialog(this, "验证码不能为空，请重新输入");
			 if(!username.equals("")&&!pwd.equals("")&&!verfcode.equals("")&&role.equals("读者")) {
				 String sql="select * from User_Inf where UserID='"+username+"'and User_Password='"+pwd+"'";
				try {
					st=con.createStatement();
					res=st.executeQuery(sql); 
					if(!res.next())
						  JOptionPane.showMessageDialog(this, "用户名或密码错误！");
					else {
					if(!vcode.getCode().equals(textfield1.getText()))
						JOptionPane.showMessageDialog(this, "验证码错误！");
					else {
					if(vcode.getCode().equals(textfield1.getText())) {
						 JOptionPane.showMessageDialog(this, "登录成功！");
						dispose();
						new user(username,pwd);
					}
					}
					}
				}
					catch (SQLException e1) {
						e1.printStackTrace();
					}	
					}
			 if(!username.equals("")&&!pwd.equals("")&&!verfcode.equals("")&&role.equals("管理员")) {
				 String sql="select * from M_Inf where m_ID='"+username+"'and m_Password='"+pwd+"'";
				try {
					st=con.createStatement();
					res=st.executeQuery(sql); 
					if(!res.next())
						  JOptionPane.showMessageDialog(this, "用户名或密码错误！");
					else {
					if(!vcode.getCode().equals(textfield1.getText()))
						JOptionPane.showMessageDialog(this, "验证码错误！");
					else {
					if(vcode.getCode().equals(textfield1.getText())) {
						 JOptionPane.showMessageDialog(this, "登录成功！");
						dispose();
						new Manager();
					}
					}
					}
				}
					catch (SQLException e1) {
						e1.printStackTrace();
					}	
					}
		}
		if(e.getSource()==clearbutton) {
	    	textfield.setText("");
	    	textfield1.setText("");
	    	password.setText("");	
	    }
		}	
	@Override
	public void keyTyped(KeyEvent e) {
		loginbutton.doClick();
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		loginbutton.doClick();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	}
