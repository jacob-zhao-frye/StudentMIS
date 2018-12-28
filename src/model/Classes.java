package model;

import Util.DbUtil;

public class Classes extends DbUtil {
private String num;
private String ClassName;
private String facultyNum;
private String entranceYear;


public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getFacultyNum() {
	return facultyNum;
}
public void setFacultyNum(String facultyNum) {
	this.facultyNum = facultyNum;
}
public String getEntranceYear() {
	return entranceYear;
}
public void setEntranceYear(String entranceYear) {
	this.entranceYear = entranceYear;
}
public String getClassName() {
	return ClassName;
}
public void setClassName(String className) {
	ClassName = className;

	}
public String  toString(){
	return this.ClassName.trim();}
}
