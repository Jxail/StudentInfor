package jdbcDao;

import java.util.Vector;

import table.LqGroup;

public interface Group_Operation {
	/**
	 * 添加蓝桥分组信息
	 * @param lqgroup
	 * @return
	 */
    public boolean addGroup(LqGroup lqgroup);
    /**
     * 删除蓝桥分组
     */
    public boolean delGroup(LqGroup lqgroup);
    /**
     * 更新蓝桥分组信息
     */
    public boolean updGroup(LqGroup lqgroup);
    /**
     * 查询蓝桥分组信息
     */
    public Vector serchGroup(LqGroup lqgroup);
}
