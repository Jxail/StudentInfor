package table;

public class Student {
   private int stuID;
   private String stuName;
   private String stuSex;
   private int stuAge;
   private int stuGroup;
   public Student(int stuID, String stuName, String stuPwd) {
	  super();
	  this.stuID = stuID;
	  this.stuName = stuName;
   }
	public Student(int stuID, String stuName, String stuSex, int stuAge, int stuGroup) {
		 this.stuID = stuID;
		 this.stuName = stuName;
		 this.stuSex = stuSex;
		 this.stuAge = stuAge;
		 this.stuGroup = stuGroup;
} 
	public Student(int stuID) {
		this.stuID = stuID;
	}

	public Student() {
		// TODO 自动生成的构造函数存�?
	}
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public int getStuGroup() {
		return stuGroup;
	}
	public void setStuGroup(int stuGroup) {
		this.stuGroup = stuGroup;
	}
	 
	}
