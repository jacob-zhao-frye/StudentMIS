package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private String dbUrl = "jdbc:sqlserver://localhost:1433;" + "DatabaseName=StudentMIS"; // 数据库连接地址
	private String dbUserName = "jacob"; // 用户名
	private String dbPassword = "123456"; // 密码
	private String jdbcName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 驱动名称

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() {
		try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

//	public static void main(String[] args) {
//		DbUtil dbUtil = new DbUtil();
//		try {
//			dbUtil.getCon();
//			System.out.println("数据库连接成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("数据库连接失败");
//		}
//	}
}
