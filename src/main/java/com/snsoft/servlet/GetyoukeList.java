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
 * Servlet implementation class GetyoukeList
 */
public class GetyoukeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetyoukeList() {
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
		String account = (String) ProrocalUtils.getRequestParams(request).get("account");
		//String account = request.getParameter("account");
		System.out.println(account);
		String result = "";
		List<Object> params = new ArrayList<Object>();
		if(account==null){
			result = ProrocalUtils.serializeResult(1, "»±…Ÿ’À∫≈≤Œ ˝", null);
		}else {
			params.add(account);
			result = DaoUtils.wanNengDao("getOneApplys", params, 3);
		}
		System.out.println(result);
		response.getWriter().write(result);
	}

}
