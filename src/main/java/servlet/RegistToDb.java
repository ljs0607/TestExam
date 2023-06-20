package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.MySQLDb;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/RegistToDb")
public class RegistToDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("name");
		String upwd = request.getParameter("pwd");
		String upwd2 = request.getParameter("pwd2");
			if(!upwd.equals(upwd2) ) {
				out.println("<script>alert('两次输入的密码不一致');window.history.back();</script>");
			}

		String sql = "INSERT INTO javaweb.reg(name,pwd) VALUES('" + uname + "','" + upwd  + "');";

		MySQLDb db = new MySQLDb();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		out.println("</head>");
		out.println("<body>");
		if(db.exeUpdate(sql)) {			
			out.println(uname + "，用户,恭喜您！注册成功，请<a href = \"login.jsp\">请返回登录</a>");
		}else {
			out.println(uname + "，用户,抱歉！注册失败，请<a href = \"index.jsp\">请返回注册</a>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
