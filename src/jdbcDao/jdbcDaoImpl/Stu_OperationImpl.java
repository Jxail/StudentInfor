package jdbcDao.jdbcDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import jdbcDao.Stu_Operation;
import myUtil.ConnJdbc;
import myUtil.StringUtil;
import table.Admin;
import table.Student;

public class Stu_OperationImpl implements Stu_Operation {
      static Connection conn = null;
      static PreparedStatement pres = null;
      static int rs;
	
	public boolean addStu(Student student) {
		// TODO 自动生成的方法存根
		int stuID = student.getStuID();
		String stuName = student.getStuName();
		String stuSex = student.getStuSex();
		int stuAge = student.getStuAge();
		int stuGroup = student.getStuGroup();
		try{
		    conn = ConnJdbc.getConnJdbc();
			pres = conn.prepareStatement("insert into Student values(?,?,?,?,?) ");
			pres.setInt(1,stuID);
			pres.setString(2,stuName);
			pres.setString(3, stuSex);
			pres.setInt(4, stuAge);
			pres.setInt(5, stuGroup);
			
			rs =  pres.executeUpdate();//增删改  ，返回int类型的整数
			if(rs==0)  return false;
			else return true;		
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}finally {
				    try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
	    
	}
	@Override
	public boolean delStu(Student student) {
		String stuName = student.getStuName();
		try{
		    conn = ConnJdbc.getConnJdbc();
			pres = conn.prepareStatement("delete from Student where stuName=?");
			pres.setString(1,stuName);
		    rs=pres.executeUpdate();//增删改  返回存在的行数
			if(rs==0)
				return false;
				else return true;
			
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}finally {
				    try {
						conn.close();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			}	
	}
	public boolean updStu(Student student) {
		int stuID = student.getStuID();
		String stuName = student.getStuName();
		String stuSex  = student.getStuSex();
		int stuAge     = student.getStuAge();
		int stuGroup   = student.getStuGroup();
		try{
		    conn = ConnJdbc.getConnJdbc();
		    pres = conn.prepareStatement(
					"update Student set stuName=?,stuSex=?,stuAge=?,gID=? "
					+ "where stuID=?");
			pres.setString(1,stuName);
			pres.setString(2, stuSex);
			pres.setInt(3,stuAge);
			pres.setInt(4, stuGroup);
			pres.setInt(5, stuID);
		    rs = pres.executeUpdate();//增删改
			
			if(rs==0){
				return false;
			}
				else return true;
				
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}finally {
				    try {
						conn.close();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
			  }
		  }
      }
	public Vector serchStu(Student student) {
		StringBuffer sql = new StringBuffer("select s.stuID,s.stuName,s.stuSex,"
				+ "s.stuAge,lq.gName from Student s,LqGroup lq where s.gID=lq.gID");
		Vector vec = new Vector();
		try{
			String stuName = student.getStuName();
			String stuSex = student.getStuSex();
			int   gID = student.getStuGroup();
			if(StringUtil.isNotEmpty(stuName)){
				sql.append(" and s.stuName like '%"+stuName+"%'");
			}
			if(StringUtil.isNotEmpty(stuSex)){
				sql.append(" and s.stuSex like '%"+stuSex+"%'");
			}
			if(gID>0){
				sql.append(" and s.gid = "+gID);
			}
		    conn =ConnJdbc.getConnJdbc();
	        pres = conn.prepareStatement(sql.toString());
	        ResultSet rs = pres.executeQuery();
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getInt(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getInt(4));
				v.add(rs.getString(5));
				vec.add(v);
			}
			return vec;
		}catch(SQLException e){
			e.printStackTrace();
			return vec;
		}finally
		{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}	
	}

}