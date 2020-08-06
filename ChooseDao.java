package dao;


import java.sql.ResultSet;
import java.util.ArrayList;

import dbuilt.DBHelper;
import entity.Choose;

public class ChooseDao {
	
	//���ѧ����ѡ��
	public void addStuChoose(String sno,String tno,String cno) {
		String sql="insert into choose values(?,?,?,1)";
		DBHelper.executeUpdate(sql,sno,tno,cno);
	} 
	//��ӽ�ʦ��ѡ��
	public void addTeacherChoose(String sno,String tno) {
		String sql="update choose set status=2 where sno=? and tno=?";
		DBHelper.executeUpdate(sql,sno,tno);
	} 
	//��ѯȫ��
	public ArrayList<Choose> getAllChoose(){
		ArrayList<Choose> list=new ArrayList<Choose>();
		String sql = "select * from choose ";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Choose choose = new Choose();
        		choose.setSno(rs.getString(1));
        		choose.setTno(rs.getString(2));
        		choose.setCno(rs.getInt(3));
        		choose.setStatus(rs.getInt(4));
        		list.add(choose);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	}
	//��ѯȫ��byCno
		public ArrayList<Choose> getAllChoose(String cno){
			ArrayList<Choose> list=new ArrayList<Choose>();
			String sql = "select * from choose where Cno='"+cno+"'";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		Choose choose = new Choose();
	        		choose.setSno(rs.getString(1));
	        		choose.setTno(rs.getString(2));
	        		choose.setCno(rs.getInt(3));
	        		choose.setStatus(rs.getInt(4));
	        		list.add(choose);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		}
	//��ѯbySno
	public ArrayList<Choose> getChooseBySno (String sno){	
		ArrayList<Choose> list=new ArrayList<Choose>();
		String sql = "select * from choose where Sno="+sno;
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Choose choose = new Choose();
        		choose.setSno(rs.getString(1));
        		choose.setTno(rs.getString(2));
        		choose.setCno(rs.getInt(3));
        		choose.setStatus(rs.getInt(4));
        		list.add(choose);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//��ѯbySnoCno
		public ArrayList<Choose> getChooseBySnoCno (String sno,String cno){	
			ArrayList<Choose> list=new ArrayList<Choose>();
			String sql = "select * from choose where Sno='"+sno+"' and Cno='"+cno+"'";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		Choose choose = new Choose();
	        		choose.setSno(rs.getString(1));
	        		choose.setTno(rs.getString(2));
	        		choose.setCno(rs.getInt(3));
	        		choose.setStatus(rs.getInt(4));
	        		list.add(choose);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		} 
	//��ѯbyTno
	public ArrayList<Choose> getChooseByTno (String tno){	
		ArrayList<Choose> list=new ArrayList<Choose>();
		String sql = "select * from choose where Tno='"+tno+"'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Choose choose = new Choose();
        		choose.setSno(rs.getString(1));
        		choose.setTno(rs.getString(2));
        		choose.setCno(rs.getInt(3));
        		choose.setStatus(rs.getInt(4));
        		list.add(choose);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//��ѯbyTnoCno
		public ArrayList<Choose> getChooseByTnoCno (String tno,String cno){	
			ArrayList<Choose> list=new ArrayList<Choose>();
			String sql = "select * from choose where Tno='"+tno+"' and Cno='"+cno+"'";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		Choose choose = new Choose();
	        		choose.setSno(rs.getString(1));
	        		choose.setTno(rs.getString(2));
	        		choose.setCno(rs.getInt(3));
	        		choose.setStatus(rs.getInt(4));
	        		list.add(choose);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		} 
	//��ѯbyCno
		public ArrayList<Choose> getChooseByCno (String cno){	
			ArrayList<Choose> list=new ArrayList<Choose>();
			String sql = "select * from choose where Cno='"+cno+"'";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		Choose choose = new Choose();
	        		choose.setSno(rs.getString(1));
	        		choose.setTno(rs.getString(2));
	        		choose.setCno(rs.getInt(3));
	        		choose.setStatus(rs.getInt(4));
	        		list.add(choose);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		} 
	//��ѯ��ʦ��ѡ��byTno
		public ArrayList<Choose> getTeacherChooseByTno (String tno){	
			ArrayList<Choose> list=new ArrayList<Choose>();
			String sql = "select * from choose where Tno='"+tno+"' and status=2";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		Choose choose = new Choose();
	        		choose.setSno(rs.getString(1));
	        		choose.setTno(rs.getString(2));
	        		choose.setCno(rs.getInt(3));
	        		choose.setStatus(rs.getInt(4));
	        		list.add(choose);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		} 
	
	//��ѡbySno��Tno
	public void deleteChooseBySnoTno (String sno,String tno) {
		String sql = "delete from choose where Sno=? and Tno=?";
		DBHelper. executeUpdate(sql,sno,tno);
	} 
	//��ʦȡ��ѡ��bySno��Tno
		public void cancelChooseBySnoTno (String sno,String tno) {
			String sql="update choose set status=1 where sno=? and tno=?";
			DBHelper.executeUpdate(sql,sno,tno);
		} 
	//ȷ������ѡ��
	public void confirmBySnoTno (String sno,String tno) {
		String sql="update choose set status=3 where sno=? and tno=?";
		DBHelper.executeUpdate(sql,sno,tno);
	} 
	//��ѯ�Ѿ�ѡ�������bySno
	public int chooseNumBySno (String sno) {
		String sql="select count(Sno) from choose where Sno='"+sno+"'";
		int num=DBHelper.executeUpdate(sql,sno);
		return num;
	} 
	//��ѯ�Ѿ�ѡ�������byTno
	public int chooseNumByTno (String tno) {
		String sql="select count(Sno) from choose where Tno='"+tno+"'";
		return DBHelper.executeUpdate(sql,tno);
	} 
}
 