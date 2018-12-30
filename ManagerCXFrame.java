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
	Container c;//����һ������
	public ManagerCXFrame(){
		c=this.getContentPane();
		setTitle("��ѯ����");         
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
		
		jl=new JLabel("��ӭʹ��");
		jl1=new JLabel("����Ա��ѯ����");
		bgp.add(jl);
		jl.setBounds(40,100,600,120);
		jl.setFont(new Font("��Բ",Font.PLAIN,80));
		jl.setForeground(Color.GRAY);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
        bgp.add(jl1);
		jl1.setBounds(20,240,600,120);
		jl1.setFont(new Font("��Բ",Font.PLAIN,80));
		jl1.setForeground(Color.GRAY);
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		choice=new JMenu("����Ա��ѯ");
		choice.setFont(new Font("��Բ",Font.PLAIN,18));
		menuBar.add(choice);
		direction=new JMenuItem("�ڿ�ȥ���ѯ");
		direction.setFont(new Font("��Բ",Font.PLAIN,18));
		direction.addActionListener(this);
		content=new JMenuItem("�ڿ����ݲ�ѯ");
		content.setFont(new Font("��Բ",Font.PLAIN,18));
		content.addActionListener(this);
		borrow=new JMenuItem("�����嵥��ѯ");
		borrow.setFont(new Font("��Բ",Font.PLAIN,18));
		borrow.addActionListener(this);
		imformation=new JMenuItem("�û���Ϣ��ѯ");
		imformation.setFont(new Font("��Բ",Font.PLAIN,18));
		imformation.addActionListener(this);
		exit=new JMenuItem("�˳�");
		exit.setFont(new Font("��Բ",Font.PLAIN,18));
		exit.addActionListener(this);
		
		choice.add(direction);
		choice.add(content);
		choice.add(borrow);
		choice.add(imformation);
		choice.addSeparator();
		choice.add(exit);
	}

	public void actionPerformed(ActionEvent e) {
		Font font=new Font("��Բ",Font.PLAIN,14);
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

