package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import dbuilt.DBHelper;
import entity.Cmanager;

public class CmanagerDao {
	/************************************************/
	//新增
	public void addCmanager(String cmno,String pwd,String cmname,String cno,String phone) {
		String sql = "insert into cmanager values (?,?,?,?,?)";
		DBHelper.executeUpdate(sql,cmno,pwd,cmname,cno,phone);
	}
	//查询,Cmno
	public Cmanager getCadmini(String cmno) {
		Cmanager cmanager = new Cmanager();
		String sql = "select * from Cmanager where Cmno=\'"+cmno+"\'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		cmanager.setCmno(rs.getString(1));
        		cmanager.setPwd(rs.getString(2));
        		cmanager.setCmname(rs.getString(3));
        		cmanager.setCno(rs.getString(4));
        		cmanager.setPhone(rs.getString(5));
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return cmanager;
	}
	//查询全部
	public ArrayList<Cmanager> getAllCmanager (){
		ArrayList<Cmanager> list = new ArrayList<Cmanager>();
		String sql = "select * from cmanager ";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Cmanager cmanager = new Cmanager();
        		cmanager.setCmno(rs.getString(1));
        		cmanager.setPwd(rs.getString(2));
        		cmanager.setCmname(rs.getString(3));
        		cmanager.setCno(rs.getString(4));
        		cmanager.setPhone(rs.getString(5));
				list.add(cmanager);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//更改信息
	public void update(String cmno,String pwd,String cmname,String cno,String phone) {
		String sql = "update cmanager set pwd=?,Cmname=?,Cno=?,phone=? where Cmno=?";
		DBHelper.executeUpdate(sql,pwd,cmname,cno,phone,cmno);
	}
	//删除
	public void delete(String cmno) {
		String sql = "delete from cmanager where Cmno=?";
		DBHelper. executeUpdate(sql,cmno);
	}
	/************************************************/
}
