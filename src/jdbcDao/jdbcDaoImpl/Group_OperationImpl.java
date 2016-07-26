package jdbcDao.jdbcDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import jdbcDao.Group_Operation;
import myUtil.ConnJdbc;
import myUtil.StringUtil;
import table.LqGroup;

public class Group_OperationImpl implements Group_Operation {
     
	static Connection conn = null;
	static PreparedStatement pres = null;
	static int rs;
	public boolean addGroup(LqGroup lqgroup) {	
		int gID = lqgroup.getgID();
		String gName = lqgroup.getgName();
		String gDesc = lqgroup.getgDesc();
		try{
		conn = ConnJdbc.getConnJdbc();
		
		pres = conn.prepareStatement("insert into LqGroup values(?,?,?)");
		pres.setInt(1, gID);
		pres.setString(2, gName);
		pres.setString(3, gDesc);
		rs = pres.executeUpdate();
		if(rs==0)  return false;
		else return true;
	    }catch(SQLException e){
	    	e.fillInStackTrace();
	    	return false;
	    }finally{
	    	try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	    }
     }

	@Override
	public boolean delGroup(LqGroup lqgroup) {
		String gName = lqgroup.getgName();
		try {
		conn = ConnJdbc.getConnJdbc();
		pres = conn.prepareStatement("delete from LqGroup where gName=?");
	    pres.setString(1, gName);
		rs = pres.executeUpdate();
		if(rs==0) 
			return false;
		    else return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updGroup(LqGroup lqgroup) {
		// TODO 自动生成的方法存根
	   try {
	   int gID = lqgroup.getgID();
	   String gName = lqgroup.getgName();
	   String gDesc = lqgroup.getgDesc();
	   conn = ConnJdbc.getConnJdbc();
	   pres = conn.prepareStatement("update LqGroup set gName=?,gDesc=? where gID=?");
	   pres.setString(1, gName);
	   pres.setString(2,gDesc );
	   pres.setInt(3, gID);
	   rs = pres.executeUpdate();
	   if(rs==0) return false;
	   else return true;
	}catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
		return false;
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	}
	@Override
	public Vector serchGroup(LqGroup lqgroup) {
		// TODO 自动生成的方法存根
		StringBuffer sql = new StringBuffer("select gID,gName,gDesc from LqGroup");
		Vector vec = new Vector();  //用来存放查询到的所有记录
		 try {
			
			 String gName = lqgroup.getgName();
			 System.out.println(gName);
			 if(StringUtil.isNotEmpty(gName)){
					sql.append(" where gName like '%"+gName+"%'");  //加入查询条件
				}
		      	conn = ConnJdbc.getConnJdbc();
				pres = conn.prepareStatement(sql.toString());  //将StringBuffer类型转换为String类型
				ResultSet rs = pres.executeQuery();
				while(rs.next()){
					Vector v = new Vector();  //用来存放每条记录中的内容
					v.add(rs.getInt(1));      //将查询到的存放在字符集中的内容添加到v中
					v.add(rs.getString(2));
					v.add(rs.getString(3));
					vec.add(v);  
				}
				return vec;		
			}catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return vec;
			}finally{
				if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
			}
			
		}
		
	}//对应整个类的结束	



