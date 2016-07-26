package jdbcDao.jdbcDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import jdbcDao.Login_Operation;
import myUtil.ConnJdbc;
import table.Admin;

public class Login_OperationImpl implements Login_Operation {

	   static Connection conn = null;
	   static PreparedStatement pres = null;
	   static ResultSet rs=null;
	   
	   public Admin login_conn(Admin admin) {
		// TODO 自动生成的方法存根
		String aName = admin.getAdminName();  //Admin类创建的admin对象调用get方法获取admin的用户名和密码
		String aPwd = admin.getAdminPwd();
		Admin a = null;
		try{
		    conn = ConnJdbc.getConnJdbc();
			pres = conn.prepareStatement("select * from admin where aName=? and aPwd=?");
			pres.setString(1,aName);
			pres.setString(2,aPwd);
			//pres.executeupdate();//增删改
			rs = pres.executeQuery();//查
			if(rs.next()){
				String name = rs.getString(1);
				String psw = rs.getString(2);
				a =  new Admin(name,psw);
				a.setAdminPwd(psw);
				a.setAdminName(name);
			}
			}catch(SQLException e){
				e.printStackTrace();
				
			}finally {
				    try {
						conn.close();
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					}
//返回一个对象，对象中封装了用户名和密码，加入没有查到用户输入的，则没有封装进去，则返回null、
//LoginManageImpl根据返回a的结果（null或者非null来判断是否登陆成功）
		return a;		
		}
		}
	
	
	




