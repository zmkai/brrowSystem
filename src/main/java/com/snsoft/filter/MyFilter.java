package com.snsoft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
	
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String result = "";
		if(session.getAttribute("username")!=null){
			System.out.println("已登录");
			result = ProrocalUtils.serializeResult(0, "登录成功", null);
			System.out.println(result);
			chain.doFilter(req, res);
		}else {
			System.out.println("请登录");
			result = ProrocalUtils.serializeResult(1, "即将跳转到登录界面", null);
			System.err.println(result);
			res.getWriter().write(result);
			//System.out.println(req.getCharacterEncoding()+"  "+req.getContentType()+"  "+res.getCharacterEncoding());

			//System.out.println(res.getCharacterEncoding());
			//req.getRequestDispatcher("/login.html").forward(req, res);
			//System.out.println(req.getContextPath());
			res.sendRedirect(req.getContextPath()+"/login2017306.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	  
	}

}
