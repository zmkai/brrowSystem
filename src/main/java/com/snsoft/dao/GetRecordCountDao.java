package com.snsoft.dao;

import java.util.List;
import java.util.Map;

import com.snsoft.utils.Operations;

public class GetRecordCountDao {
	private Operations cp;
	
	public GetRecordCountDao() {
		cp = new Operations();
	}
	
	public int getCount(String sql,List<Object> params){
		Map<String, Object> map = cp.findOne(sql, params);
		if(map!=null&&map.size()>0){
			String count = (String) map.get("recordCount");
			return Integer.parseInt(count);
		}else {
			return -1;
		}
	}
}
