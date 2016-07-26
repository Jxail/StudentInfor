package business;

import java.util.Vector;

import table.LqGroup;

public interface GroupManage {
	/**
	 * 实现添加小组的功�?
	 * @return
	 */
   public boolean addGroupImpl(LqGroup lqgroup);
   /**
    *实现删除小组的功�?
    */
   public boolean delGroupImpl(LqGroup lqgroup);
   /**
    * 实现更新小组信息的功�?
    */
   public boolean updGroupImpl(LqGroup lqgroup);
   /**
    * 实现查询小组信息的功�?
    */
   public Vector<Vector> serchGroupImpl(LqGroup lqgroup);
}
