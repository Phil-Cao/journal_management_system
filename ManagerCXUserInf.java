

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



public class ManagerCXUserInf extends JFrame {
	static Connection con=JavaCoSQL.getConnection();
	static Statement  st;
	static ResultSet  res;
	static PreparedStatement  pst;
	public ManagerCXUserInf(){
	String sql="select UserID from User_Inf ";
	String title[]=	{"�û�ID"}	;
			try {
	st=con.createStatement();
	res=st.executeQuery(sql);
	if(res.next()) {
		TableUserID  tframe=new TableUserID(title,sql,"�û���Ϣ��ѯ����");
	}
	else {
		JOptionPane.showMessageDialog(this, "û���û���Ϣ");
	}
	}catch (SQLException e1) {
		e1.printStackTrace();}
}
}

