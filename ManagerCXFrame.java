import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random; 


public class ManagerCXFrame  extends JFrame implements ActionListener{
	BackgroundPanel bgp;
	static Connection con=Conn.getConnection();
	static Statement  st,st1;
	static ResultSet  res;
	static PreparedStatement  pst;
	 JMenuBar menuBar;
	  JMenuItem direction,content,borrow,imformation,exit;
	  JMenu choice;
	  JLabel  jl,jl1;
	Container c;//创建一个容器
	public ManagerCXFrame(){
		c=this.getContentPane();
		setTitle("查询界面");         
		setBounds(300,0,660,700);
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	void init() {
		bgp=new BackgroundPanel((new ImageIcon("3.jpg")).getImage());
		bgp.setBounds(0,0,500,500);
		bgp.setLayout(null);
		c.add(bgp);
		
		jl=new JLabel("欢迎使用");
		jl1=new JLabel("管理员查询功能");
		bgp.add(jl);
		jl.setBounds(40,100,600,120);
		jl.setFont(new Font("幼圆",Font.PLAIN,80));
		jl.setForeground(Color.GRAY);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
        bgp.add(jl1);
		jl1.setBounds(20,240,600,120);
		jl1.setFont(new Font("幼圆",Font.PLAIN,80));
		jl1.setForeground(Color.GRAY);
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		choice=new JMenu("管理员查询");
		choice.setFont(new Font("幼圆",Font.PLAIN,18));
		menuBar.add(choice);
		direction=new JMenuItem("期刊去向查询");
		direction.setFont(new Font("幼圆",Font.PLAIN,18));
		direction.addActionListener(this);
		content=new JMenuItem("期刊内容查询");
		content.setFont(new Font("幼圆",Font.PLAIN,18));
		content.addActionListener(this);
		borrow=new JMenuItem("借阅清单查询");
		borrow.setFont(new Font("幼圆",Font.PLAIN,18));
		borrow.addActionListener(this);
		imformation=new JMenuItem("用户信息查询");
		imformation.setFont(new Font("幼圆",Font.PLAIN,18));
		imformation.addActionListener(this);
		exit=new JMenuItem("退出");
		exit.setFont(new Font("幼圆",Font.PLAIN,18));
		exit.addActionListener(this);
		
		choice.add(direction);
		choice.add(content);
		choice.add(borrow);
		choice.add(imformation);
		choice.addSeparator();
		choice.add(exit);
	}

	public void actionPerformed(ActionEvent e) {
		Font font=new Font("幼圆",Font.PLAIN,14);
		UIManager.put("OptionPane.messageFont", font);
		UIManager.put("OptionPane.buttonFont", font);
		if(e.getSource()==direction){
		try { 
			ManagerQXFrame directionFrame=new ManagerQXFrame();
			} catch (Exception e1) {
			e1.printStackTrace();
			}
		}
		if(e.getSource()==content) {
			try {
				ManagerNRFrame contentFrame=new ManagerNRFrame();
			}catch (Exception e1) {
				e1.printStackTrace();
				}
		}
		if(e.getSource()==borrow) {
			try {
				 ManagerJYFrame borrowFrame=new ManagerJYFrame();
				//bgp.add(borrowFrame);
			}catch (Exception e1) {
				e1.printStackTrace();
				}
		}
		if(e.getSource()==imformation) {
			try {
				ManagerCXUserInf imformationFrame=new ManagerCXUserInf();
				//bgp.add(imformationFrame);
			}catch (Exception e1) {
				e1.printStackTrace();
				}
		}
			if(e.getSource()==exit) {
				this.dispose();
				 new Manager();
			}
		}
}

