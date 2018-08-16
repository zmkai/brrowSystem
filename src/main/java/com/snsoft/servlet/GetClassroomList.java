package com.snsoft.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.dao.GetClassroomListDao;
import com.snsoft.utils.GetSqlbyId;
import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class GetClassroomList
 */
public class GetClassroomList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClassroomList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = " ";
		GetClassroomListDao dao = new GetClassroomListDao();
		String sql = GetSqlbyId.findSqlById("getClassList");
		List<Map<String, Object>> resultList = dao.getClassList(sql, null);
		if(resultList!=null){
			result = ProrocalUtils.serializeResult(0, "查询成功", resultList);
		}else {
			result = ProrocalUtils.serializeResult(1, "查询失败", null);
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
