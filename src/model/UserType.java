package model;

public enum UserType {
	TEACHER("教师", 0), STUDENT("学生", 1), INSTRUCTOR("辅导员", 2), ADMIN("管理员", 3);
	private String name;
	private int index;
   private String num;
	private UserType(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String toString() {
		return this.name;
	}
}
