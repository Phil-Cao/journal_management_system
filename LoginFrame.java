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
		this.setLayout(null);//�������κβ��ַ�ʽ
		init();
		setTitle("�û���¼");
		this.setSize(460,500);
		this.setLocation(600,80);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		}
	void init() {
		bgp=new BackgroundPanel((new ImageIcon("2.jpg")).getImage());
		bgp.setBounds(0,0, 460, 460);
		c.add(bgp);
		user=new JLabel("�û�ID:");
		user.setFont(new Font("��Բ",Font.PLAIN,18));
		ps=new JLabel("��  ��:");
		ps.setFont(new Font("��Բ",Font.PLAIN,18));
		identity=new JLabel("��  ��:");
		identity.setFont(new Font("��Բ",Font.PLAIN,18));
		
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
		textfield.setFont(new Font("��Բ",Font.PLAIN,18));
		textfield.setOpaque(false);
		 password=new JPasswordField(20);
		 password.setEchoChar('*');
		 password.setFont(new Font("��Բ",Font.PLAIN,18));
		 password.setOpaque(false);
		 jcb=new JComboBox();
		jcb.setOpaque(false);
		jcb.setFont(new Font("��Բ",Font.PLAIN,18));
		jcb.addItem("");
		jcb.addItem("����");
		jcb.addItem("����Ա");
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
		textfield1.setFont(new Font("��Բ",Font.PLAIN,18));
		textfield1.setOpaque(false);
		code=new JLabel("��֤��:");
		code.setFont(new Font("��Բ",Font.PLAIN,18));
		vcode = new ValidCode();
		box4.add(Box.createHorizontalStrut(15));
		box4.add(code);
		box4.add(Box.createHorizontalStrut(10));
		box4.add(textfield1);
		box4.add(Box.createHorizontalStrut(10));
		box4.add(vcode);
		bgp.add(box4);
		
		 loginbutton=new JButton("�� ¼");
		 loginbutton.addActionListener(this);
		 loginbutton.setSize(40, 25);
		 loginbutton.setFont(new Font("��Բ",Font.PLAIN,18));
		 loginbutton.setBackground(Color.white);
		 loginbutton.addKeyListener(this);
		 login=new ImageIcon("login.jpg");
		Image temp=login.getImage().getScaledInstance(50, 40, login.getImage().SCALE_DEFAULT);
		login=new ImageIcon(temp);
		loginbutton.setIcon(login);
		 clearbutton=new JButton("�� ��");
		 clearbutton.addActionListener(this);
		 clearbutton.setSize(40, 25);
		 clearbutton.setFont(new Font("��Բ",Font.PLAIN,18));
		 clearbutton.setBackground(Color.white);
		 clear=new ImageIcon("��1.jpg");
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
		Font font=new Font("��Բ",Font.PLAIN,14);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		if(e.getSource()==loginbutton) {
			  String username=textfield.getText();
			  String pwd=String.valueOf(password.getPassword());
			 String role=String.valueOf(jcb.getSelectedItem());
			 String verfcode=textfield1.getText();
			 if(username.equals("")||pwd.equals("")) {
					JOptionPane.showMessageDialog(this, "�û��������벻��Ϊ�գ�����������");
				}
			 if(verfcode.equals(""))
				 JOptionPane.showMessageDialog(this, "��֤�벻��Ϊ�գ�����������");
			 if(!username.equals("")&&!pwd.equals("")&&!verfcode.equals("")&&role.equals("����")) {
				 String sql="select * from User_Inf where UserID='"+username+"'and User_Password='"+pwd+"'";
				try {
					st=con.createStatement();
					res=st.executeQuery(sql); 
					if(!res.next())
						  JOptionPane.showMessageDialog(this, "�û������������");
					else {
					if(!vcode.getCode().equals(textfield1.getText()))
						JOptionPane.showMessageDialog(this, "��֤�����");
					else {
					if(vcode.getCode().equals(textfield1.getText())) {
						 JOptionPane.showMessageDialog(this, "��¼�ɹ���");
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
			 if(!username.equals("")&&!pwd.equals("")&&!verfcode.equals("")&&role.equals("����Ա")) {
				 String sql="select * from M_Inf where m_ID='"+username+"'and m_Password='"+pwd+"'";
				try {
					st=con.createStatement();
					res=st.executeQuery(sql); 
					if(!res.next())
						  JOptionPane.showMessageDialog(this, "�û������������");
					else {
					if(!vcode.getCode().equals(textfield1.getText()))
						JOptionPane.showMessageDialog(this, "��֤�����");
					else {
					if(vcode.getCode().equals(textfield1.getText())) {
						 JOptionPane.showMessageDialog(this, "��¼�ɹ���");
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
