package com.snsoft.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Connection;
import org.jsoup.Jsoup;


public class WebUtils1
{
	public static final int TEACHER = 1;
    	public static final int STUDENT = 2;
    	public static final int PASSWORD_ERROR = 0;

    public static void main(String args[])
        throws ClientProtocolException, IOException
    {
        int result = checkVPN("2016191007", "x120358x");
        System.out.println(result);
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
                phpsessid = header.getValue().substring(0, header.getValue().indexOf(";"));
        }

        httpClient.getConnectionManager().shutdown();
        HttpPost httpPost = new HttpPost(url);
        httpClient = new DefaultHttpClient();
        httpPost.addHeader("Cookie", phpsessid);
        Map params = new HashMap();
        params.put("s_id", account);
        params.put("s_password", password);
        params.put("submit", "µÇÂ¼");
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
}
