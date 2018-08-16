<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试增加记录</title>
</head>
<body>
	<form action="http://localhost:8080/brrowSystem/addBorrowInfo" method="post">
		<input name ="class_id" type="text" value="1"/><br/>
		<input name ="user_time" type="text" value="2017-04-09"/><br/>
		<input name ="username" type="text" value="凯哥"/><br/>
		<input name ="period" type="text" value="4"/><br/>
		<input name ="type" type="text" value="会议"/><br/>
		<input name ="describe" type="text" value="天气挺好"/><br/>
		<input type="submit" value="确认"/>		
	</form>
</body>
</html>