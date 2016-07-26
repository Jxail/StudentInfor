package business;

import table.Admin;

public interface LoginManage {
  /**
   * 主要用于�?查用户输入的用户名和密码是否正确
   */
	public boolean checkUser(Admin admin);
	
}
