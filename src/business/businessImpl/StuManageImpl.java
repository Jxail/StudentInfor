package business.businessImpl;

import java.util.Vector;

import business.StuManage;
import jdbcDao.jdbcDaoImpl.Stu_OperationImpl;
import table.Admin;
import table.Student;

public class StuManageImpl implements StuManage {

	public boolean AddStuImpl(Student student) {
		boolean ab= new Stu_OperationImpl().addStu(student);//调用dao类获取返回的一个对象
		if(ab==false)  return false;
		else return true;
	}
	@Override
	public boolean DelStuImpl(Student student) {
		boolean db = new Stu_OperationImpl().delStu(student);
		if(db==false)  return false;
		else return true;
	}
	public boolean UpdateStuImpl(Student student) {
		boolean ub = new Stu_OperationImpl().updStu(student);
		if(ub==false)  return false;
		else return true;
	}
	@Override
	public Vector SerchStuImpl(Student student) {
		return new Stu_OperationImpl().serchStu(student);
	}
	
}
