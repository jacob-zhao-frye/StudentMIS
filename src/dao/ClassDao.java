package dao;

import model.Classes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Util.StringUtil;
public class ClassDao extends BaseDao {

	public boolean addClass(Classes cl) {
		String sql = "insert into Class(Class_Num,Class_Name,Entrance_Year,Faculty_Num) "+"values(?,?,?,?)";
		try {
		PreparedStatement preparedstatement = con.prepareStatement(sql);
		preparedstatement.setString(1,cl.getNum());
		preparedstatement.setString(2, cl.getClassName());
		preparedstatement.setString(3, cl.getEntranceYear());
		preparedstatement.setString(4,cl.getFacultyNum());
		if(preparedstatement.executeUpdate() > 0) return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;	
	}
	
	public List<Classes> getClasslist(Classes classes){
		List<Classes> retlist = new  ArrayList<Classes>();
		String sqlString = "select * from Class";
//		System.out.println(classes.getClassName()+"haha");
		if(!StringUtil.isEmpty(classes.getClassName())){
			sqlString += " where Class_Name like '%"+classes.getClassName()+"%'";			
		}
		try {
			PreparedStatement preparedstatement = con.prepareStatement(sqlString);//
//			preparedstatement.setString(1,classes.getClassName());
			ResultSet executeQuery = preparedstatement.executeQuery();
			while(executeQuery.next()) {                     //如果返回的结果有next
				Classes cl = new Classes();
				cl.setNum(executeQuery.getString("Class_Num"));
				cl.setClassName(executeQuery.getString("Class_Name"));
				cl.setEntranceYear(executeQuery.getString("Entrance_Year"));
				cl.setFacultyNum(executeQuery.getString("Faculty_Num"));
				retlist.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retlist;
	}
	public boolean delete(String classNum) {
		String sql = "delete from Class where Class_Num = ?";
		try {
			PreparedStatement preparedstatement = con.prepareStatement(sql);
			preparedstatement.setString(1, classNum);
			if(preparedstatement.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(Classes cl){
		String sql = "update Class set Class_Name= '"+cl.getClassName()+"' , Entrance_Year=  '"
	+cl.getEntranceYear()+"' , Faculty_Num =  '"+cl.getFacultyNum()+"' where Class_Num=  '"+cl.getNum()+"' ";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.executeUpdate();
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
