package jdbcDao;

import java.util.Vector;

import table.Student;

public interface Stu_Operation {
	/**
	 * 实现添加学生的功�?
	 * @param student
	 * @return
	 */
	public boolean addStu(Student student);
   /**
    * 实现删除学生的功�?
    */
	
	public boolean delStu(Student student);
	
	/**
	 * 实现更改学生信息的功�?
	 */
	public boolean updStu(Student student);
	/**
	 * 实现查询学生的功�?
	 */
	public Vector serchStu(Student student);
}
