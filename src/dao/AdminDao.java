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
		adminRst.setNum(rs.getString("Admin_Num"));                      //��admin�����еı����Ϊ��ѯ���ı��
		adminRst.setName(rs.getString("Admin_Name"));                  //��admin���е�������Ϊ��ѯ��������
		adminRst.setPassword(rs.getString("Admin_Password"));//��admin���������Ϊ��ѯ��������
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
		System.out.println("���Ϊ"+admin.getNum());
		if(!executeQuery.next()){
			String retString = "���������";
			return retString;
		}
		Num = executeQuery.getString("Admin_Num");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}//��sql��䴫�����ݿ��������
	String retString = "�޸�ʧ��";
	String sqlString = "update Admin set Admin_Password = ? where Admin_Num = ?";
	try {
		prst = con.prepareStatement(sqlString);
		prst.setString(1, newPassword);
		prst.setString(2, Num);
		int rst = prst.executeUpdate();
		if(rst > 0){
			retString = "�����޸ĳɹ���";
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//��sql��䴫�����ݿ��������
	return retString;
}
}

