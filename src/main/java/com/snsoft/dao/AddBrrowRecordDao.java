package com.snsoft.dao;

import java.util.List;

import com.snsoft.utils.Operations;



public class AddBrrowRecordDao {
	private Operations cp;
	//���캯��
	public AddBrrowRecordDao() {
		cp = new Operations();
	}
	
	/**
	 * ��Ӽ�¼
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean addRecord(String sql ,List<Object> params){
		return cp.indelUpdate(sql, params);
	}
		


}
