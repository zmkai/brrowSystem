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
	 * ����10�����ݣ��������򷵻أ����򷵻�null
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getTenBorrowList(String sql,List<Object> params){
		System.out.println("�����ѯ��������");
		List<Map<String, Object>> list = cp.findMore(sql, params);
		System.out.println(list);
		if(list!=null&&list.size()>0){
			return list;
		}else {
			return null;
		}
	}

}
