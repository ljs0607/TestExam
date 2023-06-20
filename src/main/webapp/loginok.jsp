<%@ page contentType="text/html; charset=GBK" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<style type="text/css">
	body{
		line-height:30px;
	}
</style>
</head>
<body>
	<div>
		<% 
			String id = (String)session.getAttribute("id");
			String uname = (String)session.getAttribute("name");
			if (id != null ) {
				out.println("<h1>欢迎"+uname+"用户!!!</h1>");
				session.invalidate(); 
			} 
			else { 
				out.println("请先登录，谢谢") ;
				out.println("<br>经过五秒之后，网页会自动返回登录页面!");
				response.setHeader("Refresh","5;URL=login.jsp");
			}
		%>
	</div>
</body>
</html>