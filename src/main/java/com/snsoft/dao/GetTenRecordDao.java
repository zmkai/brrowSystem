package com.snsoft.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.snsoft.utils.Operations;

public class GetTenRecordDao {
	private Operations cp;
	public GetTenRecordDao() {
		cp = new Operations();
	}
	
	/**
	 * ·µ»Ø10Ìõ¼ÇÂ¼
	 * @param sql
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> getTenRecords(String sql,int page){
		List<Object> params = new ArrayList<Object>();
		params.add((page-1)*10);
		return cp.findMore(sql, params);
	}

}
