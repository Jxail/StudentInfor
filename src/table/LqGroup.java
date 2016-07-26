package table;

public class LqGroup {
    private int gID;
    private String gName;
    private String gDesc;
    public LqGroup(String gName){
    	super();
    	this.gName = gName;
    }
  
	public LqGroup(int gID, String gName, String gDesc) {
		super();
		this.gID = gID;
		this.gName = gName;
		this.gDesc = gDesc;
	}
	
	public LqGroup() {
		// TODO 自动生成的构造函数存�?
	}
	public int getgID() {
		return gID;
	}
	public void setgID(int gID) {
		this.gID = gID;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgDesc() {
		return gDesc;
	}
	public void setgDesc(String gDesc) {
		this.gDesc = gDesc;
	}
	public String toString(){
		return this.getgName();
	}
}
