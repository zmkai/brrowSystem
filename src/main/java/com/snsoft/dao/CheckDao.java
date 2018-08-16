package com.snsoft.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.snsoft.utils.Operations;

public class CheckDao {
	Operations cp = null;
	public CheckDao() {
		cp = new Operations();
	}
	/**
	 * 校验要添加的数据或者更新数据是否冲突
	 * @param sql
	 * @param requestParmas
	 * @return
	 */
	public boolean Check(String sql,Map<String, Object> requestParmas){
		System.out.println("进入判冲突的函数");
		List<Object> params = new ArrayList<Object>();
		params.add(requestParmas.get("class_id"));
		params.add(requestParmas.get("peroid"));
		params.add(requestParmas.get("user_time"));
		boolean flag = true;
		if(cp.findOne(sql, params)!=null&&cp.findOne(sql, params).size()>0){
			flag = false;
		}
		System.out.println("flag="+flag);
		return flag;
	}
}
