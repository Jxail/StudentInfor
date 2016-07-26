
package business;
import java.util.Vector;
import table.Student;

/**
 * 用于添加学生信息的传�?
 * @author Administrator
 */
public interface StuManage {
	/**
	 * 实现添加学生的功�?
	 */
	public boolean  AddStuImpl(Student student);
	/**
	 * 实现删除学生的功�?
	 */
	public boolean DelStuImpl(Student student);
	 /**
     * 实现更新学生信息的功�?
     */
	public boolean UpdateStuImpl(Student student);
	/**
     * 实现查询学生信息的功�?
     */
	public Vector SerchStuImpl(Student student);
}

