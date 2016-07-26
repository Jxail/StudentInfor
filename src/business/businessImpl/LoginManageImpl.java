package business.businessImpl;

import business.LoginManage;
import jdbcDao.jdbcDaoImpl.Login_OperationImpl;
import table.Admin;

public class LoginManageImpl implements LoginManage {

	public boolean checkUser(Admin admin) {
		//调用该方法来判断要用户输入的用户名和密码是够正确
		Admin a = new Login_OperationImpl().login_conn(admin);  //把从界面传来的admin对象传给dao处理
		//如果返回null说明验证失败返回false，再返回给界面界面收到就会显示登陆失败
		if(a == null) return false;   
		else return true;
	}

}
