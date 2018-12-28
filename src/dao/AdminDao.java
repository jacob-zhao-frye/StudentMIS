package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
public class AdminDao extends BaseDao {
public Admin Login(Admin Admin) {
	String sql = "select * from Admin where Admin_Num = ? and Admin_Password = ?";
	Admin adminRst = null;
	try {
	PreparedStatement prst=con.prepareStatement(sql);
	prst.setString(1,Admin.getNum());
	prst.setString(2, Admin.getPassword());
	ResultSet rs = prst.executeQuery();
	if(rs.next()){
		adminRst = new Admin();
		adminRst.setNum(rs.getString("Admin_Num"));                      //将admin的类中的编号设为查询到的编号
		adminRst.setName(rs.getString("Admin_Name"));                  //将admin类中的名字设为查询到的名字
		adminRst.setPassword(rs.getString("Admin_Password"));//将admin类的密码设为查询到的密码
	}}catch(SQLException e){
		e.printStackTrace();
	}
	return adminRst;
}
public String editPassword(Admin admin,String newPassword){
	String sql = "select * from Admin where Admin_Num = ? and Admin_Password = ?";
	PreparedStatement prst = null;
	String Num =null;
	try {
		prst = con.prepareStatement(sql);
		prst.setString(1, admin.getNum());
		prst.setString(2, admin.getPassword());
		ResultSet executeQuery = prst.executeQuery();
		System.out.println("编号为"+admin.getNum());
		if(!executeQuery.next()){
			String retString = "旧密码错误！";
			return retString;
		}
		Num = executeQuery.getString("Admin_Num");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}//把sql语句传给数据库操作对象
	String retString = "修改失败";
	String sqlString = "update Admin set Admin_Password = ? where Admin_Num = ?";
	try {
		prst = con.prepareStatement(sqlString);
		prst.setString(1, newPassword);
		prst.setString(2, Num);
		int rst = prst.executeUpdate();
		if(rst > 0){
			retString = "密码修改成功！";
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//把sql语句传给数据库操作对象
	return retString;
}
}

