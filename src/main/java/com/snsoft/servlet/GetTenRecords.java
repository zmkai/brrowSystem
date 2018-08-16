package com.snsoft.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.snsoft.dao.GetTenRecordDao;
import com.snsoft.utils.GetSqlbyId;
import com.snsoft.utils.ProrocalUtils;

/**
 * Servlet implementation class GetTenRecords
 */
public class GetTenRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTenRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageString = request.getParameter("page");
		String result ="";
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		try {
			System.out.println("���봦�����");
			int page = Integer.parseInt(pageString);
			if(page<1){
				result = ProrocalUtils.serializeResult(1, "ҳ�뷢������", null);
			}else {
				System.out.println("��ʼ��ѯ");
				String sql = GetSqlbyId.findSqlById("getTenRecords");
				resultList = new GetTenRecordDao().getTenRecords(sql, page);
				if(resultList==null||resultList.size()<1){
					result = ProrocalUtils.serializeResult(1, "��ǰ������", null);
				}else {
					result = ProrocalUtils.serializeResult(0, "��ѯ�ɹ�", resultList);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		response.getWriter().write(result);
	}

}
