package com.snsoft.dao;

import java.util.List;

import com.snsoft.utils.Operations;



public class UpdateBorrowInfoDao {
	private Operations cp;
	
	public UpdateBorrowInfoDao() {
		cp = new Operations();
	}
	
	/**
	 * ������Ϣ
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean updateInfo(String sql,List<Object> params){
		return cp.indelUpdate(sql, params);
	}

}
