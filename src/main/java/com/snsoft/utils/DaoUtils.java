package com.snsoft.utils;

import java.util.List;
import java.util.Map;

public class DaoUtils {
	
	public static String wanNengDao(String sql,List<Object> params,int flag){
		String resultString = "";
		Operations dao = new Operations();
		String mysql = GetSqlbyId.findSqlById(sql);
		//���flag����1������롢�޸ģ�ɾ��һ����¼
		if(flag==1){
			if(dao.indelUpdate(mysql, params)){
				resultString = ProrocalUtils.serializeResult(0, "�����ɹ�", null);
			}else {
				resultString = ProrocalUtils.serializeResult(1,"����ʧ��", null);
			}
		}
		//���flag����2�����ѯһ������
		if(flag==2){
			Map<String, Object> resultMap = dao.findOne(mysql, params);
			if(resultMap!=null&&resultMap.size()>0){
				resultString = ProrocalUtils.serializeResult(0, "��ѯ�ɹ�", resultMap);
			}else {
				resultString = ProrocalUtils.serializeResult(1, "��ǰ������", null);
			}
		}
		//���flag==3�����ѯ��������
		if(flag==3){
			List<Map<String, Object>> resultlistList = dao.findMore(mysql, params);
			if(resultlistList!=null&&resultlistList.size()>0){
				resultString = ProrocalUtils.serializeResult(0, "��ѯ�ɹ�", resultlistList);
			}else {
				resultString = ProrocalUtils.serializeResult(1, "��ǰ������", null);
			}
		}
		
		return resultString;
	}

}
