

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class ManagerCXUserInfX extends JFrame {
	static Connection con=JavaCoSQL.getConnection();
	static Statement  st;
	static ResultSet  res;
	static PreparedStatement  pst;
	public ManagerCXUserInfX(String s){
	String User_ID=s;
	String sql="select User_number,User_mailbox,Use_Borrownum from User_Inf where UserID='"+User_ID+"'";
	String title[]=	{"�û��绰","�û�����","��������"}	;
			try {
	st=con.createStatement();
	res=st.executeQuery(sql);
	if(res.next()) {
		TableUserIDShow  tframe=new TableUserIDShow(title,sql,"�û���Ϣ��ʾ����");
	}
	else {
		JOptionPane.showMessageDialog(this, "û���û���Ϣ");
	}
	}catch (SQLException e1) {
		e1.printStackTrace();}
}
}

