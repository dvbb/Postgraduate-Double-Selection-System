package dao;

import java.sql.ResultSet;

import dbuilt.DBHelper;
import entity.Manager;

public class ManagerDao {
	//获取校管理员，Mno
	public Manager getManager(String Mno) {
		Manager manager = new Manager();
		String sql = "select * from manager where Mno=\'"+Mno+"\'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		manager.setMno(rs.getString(1));
        		manager.setPwd(rs.getString(2));	
        		manager.setPhone(rs.getString(3));
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return manager;
	}
}
