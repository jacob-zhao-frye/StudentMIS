package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.StringUtil;
import model.Teacher;

public class TeacherDao extends BaseDao {
	public boolean addTeacher (Teacher tea) {
		String sql ="insert into Teacher(Teacher_Num,Teacher_Name,Teacher_Nation,Teacher_Sex ,Teacher_Birth,Teacher_Address,Teacher_ID,Teacher_Phone,Teacher_Password) "+" values(?,?,?,?,?,?,?,?,?)";
		try {
		PreparedStatement preparedstatement = con.prepareStatement(sql);
		preparedstatement.setString(1,tea.getNum().trim());
		preparedstatement.setString(2,tea.getName().trim());
		preparedstatement.setString(3,tea.getNation().trim());
		preparedstatement.setString(4,tea.getSex().trim());
		preparedstatement.setString(5,tea.getBirth().trim());
		preparedstatement.setString(6,tea.getAddress().trim());
		preparedstatement.setString(7,tea.getID().trim());
		preparedstatement.setString(8,tea.getPhone().trim());
		preparedstatement.setString(9, tea.getPassword().trim());
		if(preparedstatement.executeUpdate() > 0) return true;
		}catch(SQLException e){
			System.out.println(sql);
			e.printStackTrace();
		}
		return false;	
}
	public boolean update(Teacher teacher){
		String sql = "update Teacher set Teacher_Name='"+teacher.getName()+"',"
				+ "Teacher_Nation='"+teacher.getNation()+"',Teacher_Sex='"+teacher.getSex()+"' ,"
				+ "Teacher_Birth='"+teacher.getBirth()+"' ,Teacher_Address='"+teacher.getAddress()+"',"
				+ "Teacher_ID='"+teacher.getID()+"',Teacher_Phone='"+teacher.getPhone()+"',"
				+ "Teacher_Password='"+teacher.getPassword()+"' where Teacher_Num='"+teacher.getNum()+"'";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}		
	public Teacher login(Teacher teacher){
		String sql = "select * from Teacher where Teacher_Num=? and Teacher_Password=?";
		Teacher teacherRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, teacher.getNum());
			prst.setString(2, teacher.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				teacherRst = new Teacher();
				teacherRst.setNum(executeQuery.getString("Teacher_Num"));
				teacherRst.setName(executeQuery.getString("Teacher_Name"));
				teacherRst.setNation(executeQuery.getString("Teacher_Nation"));
				teacherRst.setSex(executeQuery.getString("Teacher_Sex"));
				teacherRst.setAddress(executeQuery.getString("Teacher_Address"));
				teacherRst.setBirth(executeQuery.getString("Teacher_Birth"));
				teacherRst.setPhone(executeQuery.getString("Teacher_Phone"));
				teacherRst.setID(executeQuery.getString("Teacher_ID"));
				teacherRst.setPassword(executeQuery.getString("Teacher_Password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacherRst;
	}
	public List<Teacher> getTeacherList(Teacher	 teacher){
		List<Teacher> retList = new ArrayList<Teacher>();
		StringBuffer sqlString = new StringBuffer("select * from Teacher");
		if(!StringUtil.isEmpty(teacher.getName())){
			sqlString.append(" and Teacher_Name like '%"+teacher.getName()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Teacher t = new Teacher();             //将查询返回的结果值返回到S
				t.setNum(executeQuery.getString("Teacher_Num"));
				t.setName(executeQuery.getString("Teacher_Name"));
				t.setSex(executeQuery.getString("Teacher_Sex"));
				t.setPassword(executeQuery.getString("Teacher_Password"));
				t.setAddress(executeQuery.getString("Teacher_Address"));
				t.setNation(executeQuery.getString("Teacher_Nation"));
				t.setID(executeQuery.getString("Teacher_ID"));
				t.setPhone(executeQuery.getString("Teacher_Phone"));
				t.setBirth(executeQuery.getString("Teacher_Birth"));
				retList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(String num){
		String sql = "delete from Teacher where Teacher_Num=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, num);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public String editPassword(Teacher teacher,String newPassword){
		String sql = "select * from Teacher where Teacher_Num=? and Teacher_Password=?";
		PreparedStatement prst = null;
		String id = null;
		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, teacher.getNum());
			prst.setString(2, teacher.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getString("Teacher_Num");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update Teacher set Teacher_Password = ? where Teacher_Num = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setString(2, id);
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
