import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class MainFrame extends JFrame implements ActionListener{
	BackgroundPanel bgp1,bgp2;//创建背景面板
	Container ct;//创建一个容器
	JLabel jl1;
	JButton  loginbutton,registerbutton;
	ImageIcon login,register;
	public MainFrame(){//
		ct=this.getContentPane();
		this.setLayout(null);//不采用任何布局方式
		init1();
		setTitle("期刊管理系统");
		this.setSize(700,620);
		this.setLocation(300,50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		}
	public static void main(String[] args) {
		new MainFrame();
	}
	void init1() {
		bgp1=new BackgroundPanel(new ImageIcon("1.jpg").getImage());
		bgp1.setBounds(0,0,700,600);
		ct.add(bgp1);
		bgp1.setLayout(null);
		jl1=new JLabel("期刊管理系统");
		bgp1.add(jl1);
		jl1.setBounds(40,0,600,120);
		jl1.setFont(new Font("幼圆",Font.PLAIN,80));
		jl1.setForeground(Color.DARK_GRAY);
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		loginbutton=new JButton(" 登  录 ");
		loginbutton.setBounds(250, 450, 180, 40);
		loginbutton.addActionListener(this);
		loginbutton.setFont(new Font("幼圆",Font.PLAIN,20));
		login=new ImageIcon("login.jpg");
		Image temp=login.getImage().getScaledInstance(50, loginbutton.getHeight(), login.getImage().SCALE_DEFAULT);
		login=new ImageIcon(temp);
		loginbutton.setIcon(login);
		//loginbutton.setContentAreaFilled(false);
		//loginbutton.setBorderPainted(false);
		loginbutton.setBackground(Color.white);
		bgp1.add(loginbutton);
		
		registerbutton=new JButton(" 注  册 ");
		registerbutton.setBounds(250,510, 180, 40);
		registerbutton.addActionListener(this);
		registerbutton.setFont(new Font("幼圆",Font.PLAIN,20));
		register=new ImageIcon("register.jpg");
		Image temp1=register.getImage().getScaledInstance(50, registerbutton.getHeight(), register.getImage().SCALE_DEFAULT);
		register=new ImageIcon(temp1);
		registerbutton.setIcon(register);
		//registerbutton.setContentAreaFilled(false);
		//registerbutton.setBorderPainted(false);
		registerbutton.setBackground(Color.white);
		bgp1.add(registerbutton);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginbutton) {
		     new LoginFrame();
		
	}
		if(e.getSource()==registerbutton) { 
			new RegisterFrame();
}
	}
}


