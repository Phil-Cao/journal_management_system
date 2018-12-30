import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;


public class UserJYQDFrame extends JFrame implements ActionListener{
	static Connection con=Conn.getConnection();
	static Statement  st;
	static ResultSet  res;
	static PreparedStatement  pst;
	JLabel jl10,jl11,jl12;
	JTextField text11;
	JTextArea textRecv;
	static String name;
	JButton sureButton,cancButton;
	
	BackgroundPanel bgp;
	JComboBox  jcb;
	String number;
	public UserJYQDFrame (String s){
		super();
		setTitle("期刊归还界面");
		setResizable(true);
		setBounds(300,300,500,250);		
		setLayout(null);
		name=s;
		init();   //添加控件的操作封装成一个函数         
		setVisible(true);//放在添加组件后面执行
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}//定义更改航班内部窗体
	void init(){	

		bgp=new BackgroundPanel((new ImageIcon("11.jpg")).getImage());	
		bgp.setBounds(0,0,500,250);
		bgp.setLayout(null);
		add(bgp);
		
		jl10=new JLabel("请选择要归还的期刊编号");
		jl10.setFont(new Font("宋体",Font.PLAIN,18));
	    jl10.setBounds(50,30,300,30);
	    bgp.add(jl10);	  
	    
		jl11=new JLabel("期刊编号：");
		jl11.setFont(new Font("宋体",Font.PLAIN,18));
	    jl11.setBounds(50,90,300,30);
	    bgp.add(jl11);	
	    
	    jcb=new JComboBox();
		jcb.setFont(new Font("宋体",Font.PLAIN,16));
		jcb.setBackground(Color.white);
	    jcb.setBounds(140,90,300,30);
	    bgp.add(jcb);

	    String sql="select * from  Mag_bor_Inf where  Returneddate is NULL and UserID='"+name+"'"; 
		try {
			st=con.createStatement();
			res=st.executeQuery(sql);
			while(res.next()) {
				number=res.getString("Mgz_ID");
				jcb.addItem(number);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    sureButton=new JButton("确认");
	    sureButton.setFont(new Font("宋体",Font.PLAIN,18));
	    sureButton.setBounds(170,150,90,30);
	    sureButton.addActionListener(this);
	    bgp.add(sureButton);
	        
	    cancButton=new JButton("取消");
	    cancButton.setFont(new Font("宋体",Font.PLAIN,18));
	    cancButton.setBounds(305,150,90,30);
	    cancButton.addActionListener(this);
	    bgp.add(cancButton);

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sureButton){

			String sql2="select * from Mag_bor_Inf where Mgz_ID ='"+String.valueOf(jcb.getSelectedItem())+"' and UserID='"+name+"'";
			try{
				st=con.createStatement();  
				res=st.executeQuery(sql2);
				Date date = new Date();  
				Timestamp timeStamp = new Timestamp(date.getTime());
				if(res.next()){
								   String sql3="update User_Inf set Use_Borrownum=Use_Borrownum-1 where UserID='"+name+"'";
								   String sql4="update Mag_bor_Inf set Borrowstate='归还' where UserID='"+name+"' and Mgz_ID='"+res.getString("Mgz_ID")+"'";
								   String sql5="update Mgz_dir_Inf set M_count=M_count+1 where Mgz_name='"+res.getString("Mgz_name")+"'";
								   String sql6="update Mag_bor_Inf set Returneddate='"+timeStamp+"' where UserID='"+name+"' and Mgz_ID='"+res.getString("Mgz_ID")+"'";
								   String sql7="update Mgz_log_Inf set Mgz_state='在馆' where Mgz_ID='"+res.getString("Mgz_ID")+"'";
								   pst=con.prepareStatement(sql3);
							       pst.executeUpdate();
									pst=con.prepareStatement(sql4);
							    	pst.executeUpdate();
							    	pst=con.prepareStatement(sql5);
							    	pst.executeUpdate();
							    	pst=con.prepareStatement(sql6);
							    	pst.executeUpdate();	 
							    	pst=con.prepareStatement(sql7);
							    	pst.executeUpdate();	 
							    	JOptionPane.showMessageDialog(this, "归还成功！");
							   }
						}catch (SQLException e1) {
							e1.printStackTrace();
							}
						dispose();
						
			}
		if(e.getSource()==cancButton){
			dispose();
		}
	}
}

