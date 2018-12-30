import  java.sql.*;
import java.sql.Connection;
public class Conn {
	static Connection con;
	public static Connection getConnection() {
		try {//加载数据库驱动包
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {//通过访问数据库的URL获取数据库连接对象
			String dbURL = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=第一组期刊管理系统";
			String userName = "sa"; // 默认用户名
			String userPwd = "123456"; // 密码
			con=DriverManager.getConnection(dbURL, userName,userPwd);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
