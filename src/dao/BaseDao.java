package dao;

import java.sql.Connection;
import java.sql.SQLException;

import Util.DbUtil;

public class BaseDao {
public Connection con = new DbUtil().getCon();
public void closeDao() {                     //¹Ø±ÕÊý¾Ý¿â
	try {
		con.close();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
}
}
