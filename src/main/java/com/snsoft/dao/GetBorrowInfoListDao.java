package com.snsoft.dao;

import java.util.List;
import java.util.Map;

import com.snsoft.utils.Operations;

public class GetBorrowInfoListDao {
	private Operations cp;
	
	public GetBorrowInfoListDao() {
		cp = new Operations();
	}
	
	/**
	 * 返回10条数据，若存在则返回，否则返回null
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getTenBorrowList(String sql,List<Object> params){
		System.out.println("进入查询多条数据");
		List<Map<String, Object>> list = cp.findMore(sql, params);
		System.out.println(list);
		if(list!=null&&list.size()>0){
			return list;
		}else {
			return null;
		}
	}

}
