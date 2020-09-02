package dao;


import java.sql.ResultSet;
import java.util.ArrayList;

import dbuilt.DBHelper;
import entity.Choose;

public class ChooseDao {
	/************************************************/
	//添加选择
	public void addChoose(String sno,String tno,String cno,String status,String wish) {
		String sql="insert into choose values(?,?,?,?,?)";
		DBHelper.executeUpdate(sql,sno,tno,cno,status,wish);
	} 
	//添加学生的选择
	public void addStuChoose(String sno,String tno,String i,String wish) {
		String sql="insert into choose values(?,?,?,0,?)";
		DBHelper.executeUpdate(sql,sno,tno,i,wish);
	} 
	//学生退选,Sno,Tno
		public void deleteBySnoTno (String sno,String tno) {
			String sql = "delete from choose where Sno=? and Tno=?";
			DBHelper. executeUpdate(sql,sno,tno);
		} 
	//添加教师的选择
	public void addTeacherChoose(String sno,String tno) {
		String sql="update choose set status=1 where Sno=? and Tno=?";
		DBHelper.executeUpdate(sql,sno,tno);
	} 
	//教师退选,Sno,Tno
	public void cancelChooseBySnoTno (String sno,String tno) {
		String sql="update choose set status=0 where Sno=? and Tno=?";
		DBHelper.executeUpdate(sql,sno,tno);
	} 
	//管理员确认双选关系,sno,wish 
	public void chooseConfirm (String sno,String wish) {
		String sql="update choose set status=2 where Sno=? and wish=?";
		DBHelper.executeUpdate(sql,sno,wish);
	} 
	//查询双选关系,Sno
	public ArrayList<Choose> getChooseBySno (String sno){	
		ArrayList<Choose> list=new ArrayList<Choose>();
		String sql = "select * from choose where Sno="+sno;
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Choose choose = new Choose();
        		choose.setSno(rs.getString(1));
        		choose.setTno(rs.getString(2));
        		choose.setCno(rs.getString(3));
        		choose.setStatus(rs.getString(4));
        		choose.setWish(rs.getString(5));
        		list.add(choose);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//查询双选关系,Tno
	public ArrayList<Choose> getChooseByTno (String tno){	
		ArrayList<Choose> list=new ArrayList<Choose>();
		String sql = "select * from choose where Tno='"+tno+"'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Choose choose = new Choose();
        		choose.setSno(rs.getString(1));
        		choose.setTno(rs.getString(2));
        		choose.setCno(rs.getString(3));
        		choose.setStatus(rs.getString(4));
        		choose.setWish(rs.getString(5));
        		list.add(choose);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	//查询教师的选择,Tno
	public ArrayList<Choose> getTeacherChooseByTno (String tno){	
		ArrayList<Choose> list=new ArrayList<Choose>();
		String sql = "select * from choose where Tno='"+tno+"' and status=1";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Choose choose = new Choose();
        		choose.setSno(rs.getString(1));
        		choose.setTno(rs.getString(2));
        		choose.setCno(rs.getString(3));
        		choose.setStatus(rs.getString(4));
        		choose.setWish(rs.getString(5));
        		list.add(choose);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//查询全部
		public ArrayList<Choose> getAll (String cno){	
			ArrayList<Choose> list=new ArrayList<Choose>();
			String sql = "select * from choose where Cno="+cno;
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		Choose choose = new Choose();
	        		choose.setSno(rs.getString(1));
	        		choose.setTno(rs.getString(2));
	        		choose.setCno(rs.getString(3));
	        		choose.setStatus(rs.getString(4));
	        		choose.setWish(rs.getString(5));
	        		list.add(choose);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		} 
	//查询全部
	public ArrayList<Choose> getAll (){	
		ArrayList<Choose> list=new ArrayList<Choose>();
		String sql = "select * from choose";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Choose choose = new Choose();
        		choose.setSno(rs.getString(1));
        		choose.setTno(rs.getString(2));
        		choose.setCno(rs.getString(3));
        		choose.setStatus(rs.getString(4));
        		choose.setWish(rs.getString(5));
        		list.add(choose);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//删除
	public void delete (String sno,String wish) {
		String sql="delete from choose where Sno=? and wish=?";
		DBHelper.executeUpdate(sql,sno,wish);
	} 
	/************************************************/

}
 