package com.snsoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.snsoft.dao.GetBorrowInfoListDao;
import com.snsoft.utils.GetSqlbyId;
import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class GetBorrowInfoList
 */
public class GetBorrowInfoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBorrowInfoList() {
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
		GetBorrowInfoListDao dao = new GetBorrowInfoListDao();
		String result ="";
		String sql = GetSqlbyId.findSqlById("getBorrowRecordAll");
		if(dao.getTenBorrowList(sql, null)!=null){
			result = ProrocalUtils.serializeResult(0, "查询成功",dao.getTenBorrowList(sql, null));
		}else {
			result = ProrocalUtils.serializeResult(1, "当前无数据", null);
		}
		System.out.println(result);
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.getWriter().write(result);
	}

}
