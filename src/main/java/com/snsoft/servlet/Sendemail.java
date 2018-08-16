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
			System.out.println("email����Ϊ��");
		}
		try {
			WebUtils.sendEmail(email, flag);
			result = ProrocalUtils.serializeResult(0, "�ʼ����ͳɹ�", null);
			response.getWriter().write(result);
			return;
		} catch (Exception e) {
			System.out.println("�����ʼ����ִ���");
			e.printStackTrace();
			result = ProrocalUtils.serializeResult(1, "�ʼ�����ʧ��", null);
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
