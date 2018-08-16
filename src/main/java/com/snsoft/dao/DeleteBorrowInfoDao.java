package com.snsoft.dao;

import java.util.List;

import com.snsoft.utils.Operations;

public class DeleteBorrowInfoDao {
	private Operations cp;
	public DeleteBorrowInfoDao() {
		cp = new Operations();
	}
	
	public boolean deleteRecord(String sql,List<Object> params){
			return cp.indelUpdate(sql, params);
	}

}
