import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class MainFrame extends JFrame implements ActionListener{
	BackgroundPanel bgp1,bgp2;//�����������
	Container ct;//����һ������
	JLabel jl1;
	JButton  loginbutton,registerbutton;
	ImageIcon login,register;
	public MainFrame(){//
		ct=this.getContentPane();
		this.setLayout(null);//�������κβ��ַ�ʽ
		init1();
		setTitle("�ڿ�����ϵͳ");
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
		jl1=new JLabel("�ڿ�����ϵͳ");
		bgp1.add(jl1);
		jl1.setBounds(40,0,600,120);
		jl1.setFont(new Font("��Բ",Font.PLAIN,80));
		jl1.setForeground(Color.DARK_GRAY);
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		loginbutton=new JButton(" ��  ¼ ");
		loginbutton.setBounds(250, 450, 180, 40);
		loginbutton.addActionListener(this);
		loginbutton.setFont(new Font("��Բ",Font.PLAIN,20));
		login=new ImageIcon("login.jpg");
		Image temp=login.getImage().getScaledInstance(50, loginbutton.getHeight(), login.getImage().SCALE_DEFAULT);
		login=new ImageIcon(temp);
		loginbutton.setIcon(login);
		//loginbutton.setContentAreaFilled(false);
		//loginbutton.setBorderPainted(false);
		loginbutton.setBackground(Color.white);
		bgp1.add(loginbutton);
		
		registerbutton=new JButton(" ע  �� ");
		registerbutton.setBounds(250,510, 180, 40);
		registerbutton.addActionListener(this);
		registerbutton.setFont(new Font("��Բ",Font.PLAIN,20));
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


