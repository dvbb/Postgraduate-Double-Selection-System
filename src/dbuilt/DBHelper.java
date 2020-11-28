package dbuilt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class DBHelper {
	/* 定义driver,url,user,pwd等 */
	private static String driver="com.mysql.jdbc.Driver";	// mysql.SQL数据库引擎
// 	private static String url="jdbc:mysql://127.0.0.1:3306/lyl";
// 	private static String user = "root", pwd = "123";
	
	//提供了网络数据库接口，至2021.11.1
	private static String url="jdbc:mysql://81.68.214.241:3306/DoubleSelect";
	private static String user = "DoubleSelect", pwd = "RkwR4b2L4ssW4TyY";
	
	private static Connection con;
	
    /*加载驱动程序*/
	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
    /*执行增删改操作*/
	public static void executeUpdate(String sql) {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			Statement cmd = con.createStatement();
			cmd.executeUpdate(sql);
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*执行多参数增删改操作*/
	@SuppressWarnings("deprecation")
	public static int executeUpdate(String sql,Object... params) {
		int r=0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pcmd=con.prepareStatement(sql);
			int count=1;
			for(Object param:params) {	
				if(param instanceof String)
					pcmd.setString(count++, param.toString());	//先使用count，count再自增
				else if(param instanceof Integer)
					pcmd.setInt(count++, new Integer(param.toString()));
				else if(param instanceof Double)
					pcmd.setDouble(count++, new Double(param.toString()));	
				else
					pcmd.setObject(count++, param);
			}
			r=pcmd.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	
	/*执行查询操作*/
	public static ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
//			Statement cmd = con.createStatement();
//			//创建支持移动的游标
//			Statement cmd=con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//创建支持更新的游标
			Statement cmd=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = cmd.executeQuery(sql);
		} catch (Exception ex) { 
			ex.printStackTrace();
		}
		return rs;
	}
	/*执行多参数查询操作*/
	public static ResultSet executeQuery(String sql,Object... objects) {
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			Statement cmd=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = cmd.executeQuery(sql);
		} catch (Exception ex) { 
			ex.printStackTrace();
		}
		return rs;
	}
	
   /*执行关闭数据库连接操作*/
	public static void closeConnection() {
		try {
           if(!con.isClosed())
			con.close();
		  } catch (Exception ex) {
		}
	}
	
	
	
}
