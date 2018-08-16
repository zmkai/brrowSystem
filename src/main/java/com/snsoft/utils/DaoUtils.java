package com.snsoft.utils;

import java.util.List;
import java.util.Map;

public class DaoUtils {
	
	public static String wanNengDao(String sql,List<Object> params,int flag){
		String resultString = "";
		Operations dao = new Operations();
		String mysql = GetSqlbyId.findSqlById(sql);
		//如果flag等于1，则插入、修改，删除一条记录
		if(flag==1){
			if(dao.indelUpdate(mysql, params)){
				resultString = ProrocalUtils.serializeResult(0, "操作成功", null);
			}else {
				resultString = ProrocalUtils.serializeResult(1,"操作失败", null);
			}
		}
		//如果flag等于2，则查询一条数据
		if(flag==2){
			Map<String, Object> resultMap = dao.findOne(mysql, params);
			if(resultMap!=null&&resultMap.size()>0){
				resultString = ProrocalUtils.serializeResult(0, "查询成功", resultMap);
			}else {
				resultString = ProrocalUtils.serializeResult(1, "当前无数据", null);
			}
		}
		//如果flag==3，则查询多条数据
		if(flag==3){
			List<Map<String, Object>> resultlistList = dao.findMore(mysql, params);
			if(resultlistList!=null&&resultlistList.size()>0){
				resultString = ProrocalUtils.serializeResult(0, "查询成功", resultlistList);
			}else {
				resultString = ProrocalUtils.serializeResult(1, "当前无数据", null);
			}
		}
		
		return resultString;
	}

}
