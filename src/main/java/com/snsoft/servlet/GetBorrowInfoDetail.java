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

import com.snsoft.dao.GetBorrowInfoDetailDao;
import com.snsoft.utils.GetSqlbyId;
import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class GetBorrowInfoDetail
 */
public class GetBorrowInfoDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBorrowInfoDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetBorrowInfoDetailDao dao = new GetBorrowInfoDetailDao();
		String result ="";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		params = ProrocalUtils.getRequestParams(request);
		list.add(params.get("record_id"));
		String sql = GetSqlbyId.findSqlById("queryBrrowInfoDail");
		if(dao.getOneBorrowInfo(sql, list)!=null){
			result = ProrocalUtils.serializeResult(0, "查找成功",dao.getOneBorrowInfo(sql, list));
		}else {
			result = ProrocalUtils.serializeResult(1, "查找失败", null);
		}
		System.out.println(result);
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.getWriter().write(result);
	
	}

}
