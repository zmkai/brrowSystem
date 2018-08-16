package com.snsoft.dao;

import java.util.List;

import com.snsoft.utils.Operations;



public class AddBrrowRecordDao {
	private Operations cp;
	//构造函数
	public AddBrrowRecordDao() {
		cp = new Operations();
	}
	
	/**
	 * 添加记录
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean addRecord(String sql ,List<Object> params){
		return cp.indelUpdate(sql, params);
	}
		


}
