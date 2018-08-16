package com.snsoft.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore.Entry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Connection;
import org.jsoup.Connection.Request;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

public class WebUtils {
	
	public static void main(String[] args) throws Exception {
		//getStartAndEndDate("2017-10-31");
//		Map<String,String> map = new HashMap<String, String>();
//		map.put("s_id", "195140040");
//		map.put("s_password", "zmk157382");
//		map.put("submit", "%E7%99%BB%E5%BD%95");
//		moniLogin(map);
		
		//sendEmail("1232",1);
		//moniLogin(null);
		moniloginjwc();
		
	}
	public static List<Object> getStartAndEndDate(String dateString) throws ParseException{
		List<Object> params = new ArrayList<Object>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(dateString));
		int i = calendar.get(Calendar.DAY_OF_WEEK)-1;
		if(i==0){
			i=7;
		}
		System.out.println("��������"+i);
		calendar.add(Calendar.DAY_OF_WEEK, (1-i));
		String startDateString = format.format(calendar.getTime());
		calendar.add(Calendar.DAY_OF_WEEK, 13);
		String endDateString = format.format(calendar.getTime());
		
		System.out.println("start:"+startDateString);
		System.out.println("end:"+endDateString);
		params.add(startDateString);
		params.add(endDateString);
		return params;
	}
	
	
	public static Map<String, String> getRequest(HttpServletRequest request){
		if(request==null){
			return null;
		}
		Map<String, String> paramsMap = new HashMap<String, String>();
		String json = "";
		try {
			request.setCharacterEncoding("UTF-8");
			if("GET".equals(request.getMethod())){
				json = request.getQueryString();
			}
			if("POST".equals(request.getMethod())){
				Map<String, String[]> map = request.getParameterMap();
				Set<String> key = map.keySet();
				for (String string : key) {
					System.out.println(string);
					String value = new String(request.getParameter(string).getBytes("ISO8859-1"),"UTF-8"); 
					paramsMap.put(string, value);
					}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return paramsMap;
	}
	
	public static boolean moniLogin(Map<String, String> params) throws IOException{
		boolean flag = false;
		org.jsoup.Connection connection = Jsoup.connect("http://fix.syau.edu.cn/Login.php");
		Response response = connection.execute();
		Map<String,String> cookies1 = response.cookies();
		//System.out.println(response.parse());
	    //��ȡ��������
        Connection con = Jsoup.connect("http://fix.syau.edu.cn/apply.php").cookies(response.cookies());
        Map<String, String> data= new HashMap<String, String>();
        data.put("s_id", "195140040");
        data.put("s_password", "zmk157382");
        data.put("submit", "%E7%99%BB%E5%BD%95");
        Response response2 = con.data(data).execute();
        for(Map.Entry<String, String> entry:response2.headers().entrySet()){
        	System.out.println(entry);
        }
        System.out.println(response2.body());
//        Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//        		Accept-Encoding:gzip, deflate
//        		Accept-Language:zh-CN,zh;q=0.8
//        		Cache-Control:max-age=0
//        		Cookie:PHPSESSID=mmgc7i0hag50irj0e2u7u78aa3
//        		Host:fix.syau.edu.cn
//        		Proxy-Connection:keep-alive
//        		Referer:http://fix.syau.edu.cn/Login.php
//        		Upgrade-Insecure-Requests:1
//        		User-Agent:Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36
		return flag;
	}
	
    public static int checkVPN(String account, String password)
            throws ClientProtocolException, IOException
        {
            String url = "http://fix.syau.edu.cn/Login.php";
            String logout = "http://fix.syau.edu.cn/Logout.php";
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse responseGet = httpClient.execute(httpGet);
            Header headers[] = responseGet.getAllHeaders();
            String phpsessid = "";
            Header aheader[];
            int j = (aheader = headers).length;
            for(int i = 0; i < j; i++)
            {
                Header header = aheader[i];
                System.out.println(header.getName()+":"+header.getValue());
                if(header.getName().equals("Set-Cookie"))
                {
                    phpsessid = header.getValue().substring(0, header.getValue().indexOf(";"));
                    System.out.println("phpsessid="+phpsessid);
                }
            }

            httpClient.getConnectionManager().shutdown();
            HttpPost httpPost = new HttpPost(url);
            httpClient = new DefaultHttpClient();
            httpPost.addHeader("Cookie", phpsessid);
            Map params = new HashMap();
            params.put("s_id", account);
            params.put("s_password", password);
            params.put("submit", "登录");
            java.util.List formParams = new ArrayList();
            java.util.Map.Entry entry;
            for(Iterator iterator = params.entrySet().iterator(); iterator.hasNext(); formParams.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
                entry = (java.util.Map.Entry)iterator.next();

            httpPost.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
            HttpResponse responsePost = httpClient.execute(httpPost);
            headers = responsePost.getAllHeaders();
            Header aheader1[];
            int l = (aheader1 = headers).length;
            for(int k = 0; k < l; k++)
            {
                Header header = aheader1[k];
                if(header.getName().equals("Location") && header.getValue().equals("apply.php"))
                {
                    httpClient.getConnectionManager().shutdown();
                    httpClient = new DefaultHttpClient();
                    HttpGet httpGet2 = new HttpGet(logout);
                    httpGet2.addHeader("Cookie", phpsessid);
                    httpClient.execute(httpGet2);
                    httpClient.getConnectionManager().shutdown();
                    return account.length() != 10 || '5' != account.charAt(4) ? 2 : 1;
                }
            }

            httpClient.getConnectionManager().shutdown();
            return 0;
        }
    
    
    public static void sendEmail(String email,int flag) throws Exception{
    	// �����˵� ���� �� ���루�滻Ϊ�Լ�����������룩
        // PS: ĳЩ���������Ϊ���������䱾������İ�ȫ�ԣ��� SMTP �ͻ��������˶������루�е������Ϊ����Ȩ�롱��, 
        //     ���ڿ����˶������������, ����������������ʹ������������루��Ȩ�룩��
        String myEmailAccount = "zmk1937915896@163.com";
        String myEmailPassword = "1937915896";
        
     // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ��(ֻ��һ��, ���Ǿ���)��ʽΪ: smtp.xxx.com
        // ����163����� SMTP ��������ַΪ: smtp.163.com
        String myEmailSMTPHost = "smtp.163.com";
        // �ռ�������
      //  String receiveMailAccount = "1937915896@qq.com";
        String receiveMailAccount = email;
        
     // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤

     // 2. �������ô����Ự����, ���ں��ʼ�����������
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
        // 3. ����һ���ʼ�
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount,flag);
    	
     // 4. ���� Session ��ȡ�ʼ��������
        Transport transport = session.getTransport();
     // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
        transport.connect(myEmailAccount, myEmailPassword);
        
     // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
        transport.sendMessage(message, message.getAllRecipients());
     // 7. �ر�����
        transport.close();
    }
    
    
    /**
     * ����һ��ֻ�����ı��ļ��ʼ�
     *
     * @param session �ͷ����������ĻỰ
     * @param sendMail ����������
     * @param receiveMail �ռ�������
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,int flag) throws Exception {
        // 1. ����һ���ʼ�
        MimeMessage message = new MimeMessage(session);

        // 2. From: �����ˣ��ǳ��й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸��ǳƣ�
        message.setFrom(new InternetAddress(sendMail, "¼��ϵͳ", "UTF-8"));

        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "�װ����û�", "UTF-8"));

        // 4. Subject: �ʼ����⣨�����й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ı��⣩
        message.setSubject("��˽��", "UTF-8");

        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ���������й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ķ������ݣ�
       if(flag==0){
    	   message.setContent("�װ����û����, ������������Ѿ�ͨ�������!!!!!", "text/html;charset=UTF-8");
       }
       if(flag==1){
    	   message.setContent("�װ����û����,���ź�, �����������û��ͨ�����!!!!", "text/html;charset=UTF-8");
       }
        

        // 6. ���÷���ʱ��
        message.setSentDate(new Date());

        // 7. ��������
        message.saveChanges();

        return message;
    }
    
    public static void moniloginjwc() throws IOException{
    	String url = "http://210.47.163.27:9001/logout.do";
    	Connection connection = Jsoup.connect(url);
    	Response response = connection.execute();
    	String url2 = "http://210.47.163.27:9001/loginAction.do";
    	//response.cookies();
    	Connection connection2 = Jsoup.connect(url2).cookies(response.cookies());
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("zjh", "195140040");
    	params.put("mm", "1937915896");
    	Response response2 = connection2.data(params).execute();
    	//System.out.println(response2.body());
    	System.out.println(response2.parse());
    	
    	
    }
}
