import  java.sql.*;
import java.sql.Connection;
public class Conn {
	static Connection con;
	public static Connection getConnection() {
		try {//�������ݿ�������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {//ͨ���������ݿ��URL��ȡ���ݿ����Ӷ���
			String dbURL = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=��һ���ڿ�����ϵͳ";
			String userName = "sa"; // Ĭ���û���
			String userPwd = "123456"; // ����
			con=DriverManager.getConnection(dbURL, userName,userPwd);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
