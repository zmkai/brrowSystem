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
	 * У��Ҫ��ӵ����ݻ��߸��������Ƿ��ͻ
	 * @param sql
	 * @param requestParmas
	 * @return
	 */
	public boolean Check(String sql,Map<String, Object> requestParmas){
		System.out.println("�����г�ͻ�ĺ���");
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
