package com.snsoft.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username==null||password==null){
			result = ProrocalUtils.serializeResult(1, "«ÎÃÓ»Î’À∫≈∫Õ√‹¬Î", null);
		}else if(username.equals("Adminer")&&password.equals("jiaowuwang")){
			request.getSession().setAttribute("username", username);
			result = ProrocalUtils.serializeResult(0, "µ«¬º≥…π¶", null);
		}else {
			result = ProrocalUtils.serializeResult(1, "√‹¬ÎªÚ’À∫≈¥ÌŒÛ", null);
		}
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.getWriter().write(result);
		
	}

}
