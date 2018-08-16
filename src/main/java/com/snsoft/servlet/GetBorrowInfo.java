package com.snsoft.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.dao.GetBorrowRecordIn2Dao;
import com.snsoft.utils.GetSqlbyId;
import com.snsoft.utils.ProrocalUtils;
import com.snsoft.utils.WebUtils;

/**
 * Servlet implementation class GetBorrowInfo
 */
public class GetBorrowInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBorrowInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetBorrowRecordIn2Dao dao = new GetBorrowRecordIn2Dao();
		String result ="";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		params = ProrocalUtils.getRequestParams(request);
		String dateString = (String) params.get("dateString");
		if(dateString!=null){
			String sql = GetSqlbyId.findSqlById("queryDuring2Week");
			try {
				resultList = dao.getList(sql, WebUtils.getStartAndEndDate(dateString));
			} catch (ParseException e) {
				System.out.println("日期解析失败");
				e.printStackTrace();
			}
			if(resultList!=null){
				result = ProrocalUtils.serializeResult(0, "查询成功", resultList);
			}else {
				result = ProrocalUtils.serializeResult(1, "当前尚无数据", null);
			}
		}else {
			result = ProrocalUtils.serializeResult(1, "日期参数为空", null);
		}
		System.out.println(result);
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
