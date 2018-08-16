package com.snsoft.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.dao.CheckDao;
import com.snsoft.utils.DaoUtils;
import com.snsoft.utils.GetSqlbyId;
import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class AddApplyRecord
 */
public class AddApplyRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddApplyRecord() {
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
//		System.out.println(request.getParameter("username"));
//		System.out.println(request.getMethod());
//		String str = new String(request.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
//		System.out.println(request.getCharacterEncoding());
//		System.out.println(str);
		
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		List<Object> params = new ArrayList<Object>();
		String result  = "";
		paramsMap.put("user_time", request.getParameter("user_time"));
		paramsMap.put("peroid",request.getParameter("period"));
		paramsMap.put("class_id",request.getParameter("class_id"));
		CheckDao checkDao = new CheckDao();
		String checksql = GetSqlbyId.findSqlById("checkconflict");
		if(!checkDao.Check(checksql, paramsMap)){
			result = ProrocalUtils.serializeResult(1, "教室使用冲突,请更换使用时间", null);
			response.setHeader("content-type","text/html;charset=UTF-8");
			response.getWriter().write(result);
			return;
		}
		
		params.add(request.getParameter("account"));
		params.add(request.getParameter("class_id"));
		params.add(request.getParameter("user_time"));
		params.add(request.getParameter("username"));
		params.add(request.getParameter("period"));
		params.add(request.getParameter("type"));
		params.add(request.getParameter("email"));
		params.add(request.getParameter("describe"));
		params.add(new Timestamp(System.currentTimeMillis()));
		result = DaoUtils.wanNengDao("AddApply", params, 1);
		
		System.out.println(result);
		response.getWriter().write(result);
		
	}

}
