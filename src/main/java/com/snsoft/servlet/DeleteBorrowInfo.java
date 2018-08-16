package com.snsoft.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.dao.DeleteBorrowInfoDao;
import com.snsoft.utils.GetSqlbyId;
import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class DeleteBorrowInfo
 */
public class DeleteBorrowInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBorrowInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete");
		DeleteBorrowInfoDao dao = new DeleteBorrowInfoDao();
		String result ="";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		params = ProrocalUtils.getRequestParams(request);
		//System.out.println("request-->" + request.getParameter("record_id"));
		list.add(params.get("record_id"));
		String sql = GetSqlbyId.findSqlById("deleteBrrowRecord");
		if(dao.deleteRecord(sql, list)){
			result = ProrocalUtils.serializeResult(0, "É¾³ý³É¹¦", null);
		}else {
			result = ProrocalUtils.serializeResult(1, "É¾³ýÊ§°Ü", null);
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
