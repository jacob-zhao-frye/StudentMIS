package dao;

import java.sql.Connection;
import java.sql.SQLException;

import Util.DbUtil;

public class BaseDao {
public Connection con = new DbUtil().getCon();
public void closeDao() {                     //�ر����ݿ�
	try {
		con.close();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}
}
