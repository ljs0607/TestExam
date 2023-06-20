package utils;
import java.sql.*;
public class MySQLDb {
  private Connection conn=null;
  private Statement stmt =null;
  private ResultSet rs =null;
  /**
   * @return 返回数据库连接对象
   */
  public  Connection  ConnDB() {
	  conn = null;
	  try {  
		  String url="jdbc:mysql://localhost:3306/javaweb?useUnicode=true&character=UTF-8";
		  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		  conn=DriverManager.getConnection(url,"root","123456");
		  return conn;
		}
		catch (Exception fe) {
			System.err.println("ConnDB(): " + fe.getMessage());
			return null;
		}
	}

  /**
   * @return 返回状态集对象
   */
	public Statement CreatStat() {
		stmt = null;
		try {
			if (conn == null) {
				conn = this.ConnDB();
			}
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			return stmt;
		} catch (Exception fe) {
			System.err.println("CreatStat(): " + fe.getMessage());
			return null;
		}

	}
	/**
	 * 获取PreparedStatement的方法
	 * @param sql
	 * @param autoGenereatedKeys
	 * @return
	 */
	public PreparedStatement prepare(String sql, int autoGenereatedKeys) {
		PreparedStatement pstmt = null;
		try {
		if (conn == null){
			conn = this.ConnDB();
		}
		pstmt = conn.prepareStatement(sql, autoGenereatedKeys);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pstmt;
	}
	/**
	 * 
	 * @param sql
	 * @return 返回记录集对象
	 */
	public ResultSet getResult(String sql) {
		rs = null;
		try {
			stmt = this.CreatStat();
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException ex) {
			System.err.println("getResult: " + ex.getMessage());
			return null;
		}

	}
	/**
	 * 执行插入、更新、删除语句的方法
	 * @param sql
	 * @return
	 */
	public boolean exeUpdate(String sql) {
		try {
			stmt = this.CreatStat();
			stmt.executeUpdate(sql);
			if (!conn.getAutoCommit()) {
				conn.commit();
			}
			return true;
		} catch (Exception e) {
			System.err.println("executeUpdate: " + e.toString());
			return false;
		}

	}
	/**
	 * 释放资源的方法
	 * @throws SQLException
	 */
	public void Release() throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
}