package com.snsoft.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.dao.CheckDao;
import com.snsoft.dao.UpdateBorrowInfoDao;
import com.snsoft.utils.GetSqlbyId;
import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class UpdateBorrowInfo
 */
public class UpdateBorrowInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBorrowInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = " ";
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		String user_time =request.getParameter("user_time");
		String class_id =request.getParameter("class_id");
		String user =request.getParameter("user");
		String peroid =request.getParameter("peroid");
		String describe =request.getParameter("describe");
		String type =request.getParameter("type");
		String record_id = request.getParameter("record_id");
		paramsMap.put("user_time", user_time);
		paramsMap.put("peroid", peroid);
		paramsMap.put("class_id", class_id);
		
		List<Object> paramsList = new ArrayList<Object>();
		UpdateBorrowInfoDao dao = new UpdateBorrowInfoDao();
		
		if(user_time==null||class_id==null||user==null||peroid==null||type==null){
			result = ProrocalUtils.serializeResult(1, "参数不完整", null);
		}else {
			CheckDao checkDao = new CheckDao();
			String checksql = GetSqlbyId.findSqlById("checkconflict");
			if(!checkDao.Check(checksql, paramsMap)){
				result = ProrocalUtils.serializeResult(1, "教室使用冲突,请选择时间或节次", null);
				response.setHeader("content-type","text/html;charset=UTF-8");
				response.getWriter().write(result);
				return;
			}
			/*
			 * SET class_id = ?,
				user_time = ?,
				username = ?,
				period = ?,
				describe_info = ?,
				usetype = ?,
				operatetime = ?
				WHERE
					record_id = ?
			 */
			paramsList.add(class_id);
			paramsList.add(user_time);
			paramsList.add(user);
			paramsList.add(peroid);
			paramsList.add(describe);
			paramsList.add(type);
			paramsList.add(new Timestamp(System.currentTimeMillis()));
			paramsList.add(record_id);
			
			String sql = GetSqlbyId.findSqlById("updateBrrowRecord");
			if(dao.updateInfo(sql, paramsList)){
				result = ProrocalUtils.serializeResult(0, "更新成功", null);
			}else {
				result = ProrocalUtils.serializeResult(1, "更新失败", null);
			}
		}
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
