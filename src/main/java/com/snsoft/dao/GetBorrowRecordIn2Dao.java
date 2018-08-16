package com.snsoft.dao;

import java.util.List;
import java.util.Map;

import com.snsoft.utils.Operations;

public class GetBorrowRecordIn2Dao {
	private Operations cp;
	
	public GetBorrowRecordIn2Dao() {
		cp = new Operations();
	}
	
	public List<Map<String,Object>> getList(String sql ,List<Object> params){
		List<Map<String, Object>> list = cp.findMore(sql, params);
		if(list!=null&&list.size()>0){
			return list;
		}else {
			return null;
		}
	}
}
