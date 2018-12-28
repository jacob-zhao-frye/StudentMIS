package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.StringUtil;
import model.Student;

public class StudentDao extends BaseDao {
	public boolean addStudent (Student stu) {
		String sql = "insert into Student(Student_Num,Student_Name,Student_Nation,Student_Sex ,Student_Birth,Student_Address,Student_ID,Student_Phone,Class_Num,Student_Password) "+" values(?,?,?,?,?,?,?,?,?,?)";
		try {
		PreparedStatement preparedstatement = con.prepareStatement(sql);
		preparedstatement.setString(1,stu.getNum());
		preparedstatement.setString(2,stu.getName());
		preparedstatement.setString(3,stu.getNation());
		preparedstatement.setString(4,stu.getSex());
		preparedstatement.setString(5,stu.getBirth());
		preparedstatement.setString(6,stu.getAddress());
		preparedstatement.setString(7,stu.getID());
		preparedstatement.setString(8,stu.getPhone());
		preparedstatement.setString(9,stu.getClassNum());
		preparedstatement.setString(10, stu.getPassword());

		if(preparedstatement.executeUpdate() > 0) return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;	
}
 public List<Student> getStudentList(Student	 student){
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select * from Student");
		if(!StringUtil.isEmpty(student.getName())){
			sqlString.append(" and Student_Name like '%"+student.getName()+"%'");
		}
		if(student.getClassNum() != null){
			sqlString.append(" and  Class_Num="+student.getClassNum());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Student s = new Student();             //将查询返回的结果值返回到S
				s.setNum(executeQuery.getString("Student_Num"));
				s.setName(executeQuery.getString("Student_Name"));
				s.setClassNum(executeQuery.getString("Class_Num"));
				s.setSex(executeQuery.getString("Student_Sex"));
				s.setPassword(executeQuery.getString("Student_Password"));
				s.setAddress(executeQuery.getString("Student_Address"));
				s.setNation(executeQuery.getString("Student_Nation"));
				s.setID(executeQuery.getString("Student_ID"));
				s.setPhone(executeQuery.getString("Student_Phone"));
				s.setBirth(executeQuery.getString("Student_Birth"));
				retList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
 
	public boolean update(Student student){
		String sql = "update Student set Student_Name='"+student.getName()+"',"
				+ "Student_Nation='"+student.getNation()+"',Student_Sex='"+student.getSex()+"' ,"
				+ "Student_Birth='"+student.getBirth()+"' ,Student_Address='"+student.getAddress()+"',"
				+ "Student_ID='"+student.getID()+"',Student_Phone='"+student.getPhone()+"',"
				+ "Class_Num='"+student.getClassNum()+"',Student_Password='"+student.getPassword()+"' where Student_Num='"+student.getNum()+"'";
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
	public boolean delete(String num){
		String sql = "delete from Student where Student_Num=?";
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
	public Student login(Student student){
		String sql = "select * from Student where Student_Num=? and Student_Password=?";
		Student studentRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, student.getNum());
			prst.setString(2, student.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				studentRst = new Student();
				studentRst.setNum(executeQuery.getString("Student_Num"));
				studentRst.setName(executeQuery.getString("Student_Name"));
				studentRst.setNation(executeQuery.getString("Student_Nation"));
				studentRst.setSex(executeQuery.getString("Student_Sex"));
				studentRst.setAddress(executeQuery.getString("Student_Address"));
				studentRst.setBirth(executeQuery.getString("Student_Birth"));
				studentRst.setPhone(executeQuery.getString("Student_Phone"));
				studentRst.setID(executeQuery.getString("Student_ID"));
				studentRst.setClassNum(executeQuery.getString("Class_Num"));
				studentRst.setPassword(executeQuery.getString("Student_Password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRst;
	}
	public String editPassword(Student student,String newPassword){
		String sql = "select * from Student where Student_Num=? and Student_Password=?";
		PreparedStatement prst = null;
		String id = null;
		try {
			prst = con.prepareStatement(sql);
			prst.setString(1, student.getNum());
			prst.setString(2, student.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getString("Student_Num");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update Student set Student_Password = ? where Student_Num = ?";
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