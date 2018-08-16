package com.snsoft.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.snsoft.utils.ProrocalUtils;
import com.snsoft.utils.WebUtils;

/**
 * Servlet implementation class MoNiLogin
 */
public class MoNiLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoNiLogin() {
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
		String result = "";
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(WebUtils.checkVPN(account, password)!=0){
			result = ProrocalUtils.serializeResult(0, "µÇÂ¼³É¹¦", null);
		}else {
			result = ProrocalUtils.serializeResult(1, "µÇÂ¼Ê§°Ü", null);
		}
		System.out.println(result);
		response.getWriter().write(result);
	}

}
