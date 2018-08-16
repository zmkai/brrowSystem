package com.snsoft.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.dao.AddBrrowRecordDao;
import com.snsoft.dao.CheckDao;
import com.snsoft.utils.GetSqlbyId;
import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class AddBorrowInfo
 */
public class AddBorrowInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBorrowInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = " ";
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		String user_time =request.getParameter("user_time");
		String class_id =request.getParameter("class_id");
		String user =request.getParameter("user");
		String peroid =request.getParameter("peroid");
		String describe =request.getParameter("describe");
		String type =request.getParameter("type");
		paramsMap.put("user_time", user_time);
		paramsMap.put("peroid", peroid);
		paramsMap.put("class_id", class_id);
		
		CheckDao checkDao = new CheckDao();
		String checksql = GetSqlbyId.findSqlById("checkconflict");
		if(!checkDao.Check(checksql, paramsMap)){
			result = ProrocalUtils.serializeResult(1, "教室使用冲突,请更换使用时间", null);
			response.setHeader("content-type","text/html;charset=UTF-8");
			response.getWriter().write(result);
			return;
		}
		List<Object> paramsList = new ArrayList<Object>();
		AddBrrowRecordDao dao = new AddBrrowRecordDao();
		if(user_time==null||class_id==null||user==null||peroid==null||type==null){
			result = ProrocalUtils.serializeResult(1, "参数不完整", null);
		}else {
			paramsList.add(UUID.randomUUID().toString().substring(0, 20));
			paramsList.add(class_id);
			paramsList.add(user_time);
			paramsList.add(user);
			paramsList.add(peroid);
			paramsList.add(describe);
			paramsList.add(type);
			paramsList.add("0");
			paramsList.add(new Timestamp(System.currentTimeMillis()));
			
			System.out.println("开始输出参数集合");
			for (Object object : paramsList) {
				System.out.println(object);
			}
			String sql = GetSqlbyId.findSqlById("insertRecord");
			if(dao.addRecord(sql, paramsList)){
				result = ProrocalUtils.serializeResult(0, "添加成功", null);
			}else {
				result = ProrocalUtils.serializeResult(1, "添加失败", null);
			}
			
		}
		System.out.println(result);
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.getWriter().write(result);
	
	}

}
