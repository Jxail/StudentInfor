package business.businessImpl;

import java.util.Vector;

import business.GroupManage;
import jdbcDao.jdbcDaoImpl.Group_OperationImpl;
import table.LqGroup;

public class GroupManageImpl implements GroupManage {

	@Override
	public boolean addGroupImpl(LqGroup lqgroup) {
		boolean ab = new Group_OperationImpl().addGroup(lqgroup);
		if(ab) return true;
		else return false;
	}

	@Override
	public boolean delGroupImpl(LqGroup lqgroup) {
		boolean db = new Group_OperationImpl().delGroup(lqgroup);
		if(db) return true;
		else return false;
	}

	@Override
	public boolean updGroupImpl(LqGroup lqgroup) {
		boolean ub = new Group_OperationImpl().updGroup(lqgroup);
		if(ub) return true;
		else return false;
	}

	
	public Vector serchGroupImpl(LqGroup lqgroup) {
		return new Group_OperationImpl().serchGroup(lqgroup);
		  
	}

}
