package com.snsoft.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.utils.ProrocalUtils;
import com.snsoft.utils.WebUtils;

/**
 * Servlet implementation class Sendemail
 */
public class Sendemail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sendemail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		String email = request.getParameter("applyemail");
		int flag = Integer.parseInt(request.getParameter("flag"));
		if(email==null){
			System.out.println("email不能为空");
		}
		try {
			WebUtils.sendEmail(email, flag);
			result = ProrocalUtils.serializeResult(0, "邮件发送成功", null);
			response.getWriter().write(result);
			return;
		} catch (Exception e) {
			System.out.println("发送邮件出现错误");
			e.printStackTrace();
			result = ProrocalUtils.serializeResult(1, "邮件发送失败", null);
			response.getWriter().write(result);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
