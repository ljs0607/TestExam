package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.MySQLDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;



@WebServlet({ "/UserLogin", "/chapter6/UserLogin" })
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("name");
		String upwd = request.getParameter("pwd");
		String dbupwd;
		String sql = "SELECT * FROM javaweb.reg WHERE name='"+uname+"';";
		MySQLDb db = new MySQLDb();
		ResultSet rs = db.getResult(sql);
		try {
			if(rs.next()){
				dbupwd = rs.getString("pwd");
				if(upwd.equals(dbupwd)){
		    	   HttpSession session = request.getSession();
		    	   session.setAttribute("id", rs.getString("id"));
		    	   session.setAttribute("name", uname);
		    	   response.sendRedirect("loginok.jsp");
					//关闭数据库
		    	   db.Release();
		    	 }else{
		    		 out.println("<script>alert(\"用户名或密码错误\");window.history.back();</script>");
		    		 return;
		    	 }
			}else{
				out.println("<script>alert(\"用户名或密码错误\");window.history.back();</script>");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
