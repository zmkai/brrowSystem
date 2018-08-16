package com.snsoft.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.utils.DaoUtils;
import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class GetApplyDetail
 */
public class GetApplyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetApplyDetail() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		String result = "";
		if(id>0){
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			result = DaoUtils.wanNengDao("getApplyDetail", params, 2);
		}else {
			result = ProrocalUtils.serializeResult(1, "所需id参数错误", null);
		}
		System.out.println(result);
		response.getWriter().write(result);
	}

}
