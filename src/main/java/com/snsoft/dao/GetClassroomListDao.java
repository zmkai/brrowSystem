package com.snsoft.dao;

import java.util.List;
import java.util.Map;

import com.snsoft.utils.Operations;

public class GetClassroomListDao {
	private Operations cp;
	
	public GetClassroomListDao() {
		cp = new Operations();
	}
	
	/**
	 * 返回教室的map集合
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getClassList(String sql,List<Object> params) {
		List<Map<String, Object>> list = cp.findMore(sql, params);
		if(list!=null&&list.size()>0){
			return list;
		}else {
			return null;
		}
	}

}
