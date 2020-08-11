package dbuilt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class DBHelper {
	/* ����driver,url,user,pwd�� */
	private static String driver="com.mysql.jdbc.Driver";	// mysql.SQL���ݿ�����
	private static String url="jdbc:mysql://127.0.0.1:3306/j2ee";
	private static String user = "root", pwd = "123";
	private static Connection con;
	
    /*������������*/
	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
    /*ִ����ɾ�Ĳ���*/
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
	
	/*ִ�ж������ɾ�Ĳ���*/
	@SuppressWarnings("deprecation")
	public static int executeUpdate(String sql,Object... params) {
		int r=0;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pcmd=con.prepareStatement(sql);
			int count=1;
			for(Object param:params) {	
				if(param instanceof String)
					pcmd.setString(count++, param.toString());	//��ʹ��count��count������
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
	
	/*ִ�в�ѯ����*/
	public static ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
//			Statement cmd = con.createStatement();
//			//����֧���ƶ����α�
//			Statement cmd=con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//����֧�ָ��µ��α�
			Statement cmd=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = cmd.executeQuery(sql);
		} catch (Exception ex) { 
			ex.printStackTrace();
		}
		return rs;
	}
	/*ִ�ж������ѯ����*/
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
	
   /*ִ�йر����ݿ����Ӳ���*/
	public static void closeConnection() {
		try {
           if(!con.isClosed())
			con.close();
		  } catch (Exception ex) {
		}
	}
	
	
	
}
