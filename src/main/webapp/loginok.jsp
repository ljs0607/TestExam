<%@ page contentType="text/html; charset=GBK" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>�û���¼</title>
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
				out.println("<h1>��ӭ"+uname+"�û�!!!</h1>");
				session.invalidate(); 
			} 
			else { 
				out.println("���ȵ�¼��лл") ;
				out.println("<br>��������֮����ҳ���Զ����ص�¼ҳ��!");
				response.setHeader("Refresh","5;URL=login.jsp");
			}
		%>
	</div>
</body>
</html>