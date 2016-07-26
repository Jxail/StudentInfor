package table;

public class Admin{
	private int aID;
	private String aName;
	private String aPwd;
   public Admin(String aName, String aPwd) {
		// TODO 自动生成的构造函数存�?
	    this.aName = aName;
		this.aPwd = aPwd;
	}
	public Admin(String delText) {
		this.aID = aID;
	// TODO 自动生成的构造函数存�?
}
	/* public Admin(int aID, String aName, String aPwd) {
		super();
		this.aID = aID;
		this.aName = aName;
		this.aPwd = aPwd;
	}*/
	public int getAdminID() {
		return aID;
	}
	public void setAdminID(int adminID) {
		this.aID = adminID;
	}
	public String getAdminName() {
		return aName;
	}
	public void setAdminName(String adminName) {
		this.aName = adminName;
	}
	public String getAdminPwd() {
		return aPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.aPwd = adminPwd;
	}

}
