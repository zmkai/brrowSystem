package com.snsoft.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.snsoft.utils.Operations;

public class GetBorrowInfoDetailDao {
	private Operations cp;
	
	public GetBorrowInfoDetailDao() {
		cp = new Operations();
	}
	
	/**
	 * 返回详细的记录信息
	 * @param sql
	 * @param params
	 * @return
	 */
	public Map<String, Object> getOneBorrowInfo(String sql,List<Object> params){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = cp.findOne(sql, params);
		if(resultMap!=null&&resultMap.size()>0){
			return resultMap;
		}else {
			return null;
		}
	}

}
