package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import dbuilt.DBHelper;
import entity.Teacher;

public class TeacherDao {
	/************************************************/
	//��ѯ��ʦ��Tno
	public Teacher getTeacher(String tno) {
		Teacher teacher =new Teacher();
		String sql = "select * from teacher where Tno=\'"+tno+"\'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		teacher.setTno(rs.getString(1));
        		teacher.setTname(rs.getString(2));
        		teacher.setSex(rs.getString(3));
        		teacher.setTitle(rs.getString(4));
        		teacher.setLeadnum(rs.getString(5));
        		teacher.setIntro(rs.getString(6));
        		teacher.setPwd(rs.getString(7));
        		teacher.setEmail(rs.getString(8));
        		teacher.setDiscipline(rs.getString(9));
        		teacher.setCno(rs.getString(10));
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
        return teacher;
    }
	//��ѯȫ����ʦ
	public ArrayList<Teacher> getAllTeachers (String cno){
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from Teacher where Cno="+cno;
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Teacher teacher = new Teacher();
        		teacher.setTno(rs.getString(1));
        		teacher.setTname(rs.getString(2));
        		teacher.setSex(rs.getString(3));
        		teacher.setTitle(rs.getString(4));
        		teacher.setLeadnum(rs.getString(5));
        		teacher.setIntro(rs.getString(6));
        		teacher.setPwd(rs.getString(7));
        		teacher.setEmail(rs.getString(8));
        		teacher.setDiscipline(rs.getString(9));
        		teacher.setCno(rs.getString(10));
				list.add(teacher);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//��ѯȫ����ʦ
	public ArrayList<Teacher> getAllTeachers (){
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from Teacher ";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Teacher teacher = new Teacher();
        		teacher.setTno(rs.getString(1));
        		teacher.setTname(rs.getString(2));
        		teacher.setSex(rs.getString(3));
        		teacher.setTitle(rs.getString(4));
        		teacher.setLeadnum(rs.getString(5));
        		teacher.setIntro(rs.getString(6));
        		teacher.setPwd(rs.getString(7));
        		teacher.setEmail(rs.getString(8));
        		teacher.setDiscipline(rs.getString(9));
        		teacher.setCno(rs.getString(10));
				list.add(teacher);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//��ѯ��ʦ,Cno��discipline
	public ArrayList<Teacher> getTeachersByCnoDis (String i,String dis){
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from Teacher where Cno="+i+" and discipline='"+dis+"';";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Teacher teacher = new Teacher();
        		teacher.setTno(rs.getString(1));
        		teacher.setTname(rs.getString(2));
        		teacher.setSex(rs.getString(3));
        		teacher.setTitle(rs.getString(4));
        		teacher.setLeadnum(rs.getString(5));
        		teacher.setIntro(rs.getString(6));
        		teacher.setPwd(rs.getString(7));
        		teacher.setEmail(rs.getString(8));
        		teacher.setDiscipline(rs.getString(9));
        		teacher.setCno(rs.getString(10));
				list.add(teacher);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	/************************************************/
	//������ʦ
	public void addTeacher(String tno,String tname,String sex,String title,String leadnum,String intro,
			String pwd,String email,String dis,String cno) {
		String sql="insert into teacher values(?,?,?,?,?,?,?,?,?,?)";
		DBHelper.executeUpdate(sql, tno,tname,sex,title,leadnum,intro,pwd,email,dis,cno);
	}
	//���½�ʦ��ϢByTno
	public void updateTeacherByTno(String tno,String tname,String sex,String title,String leadnum,String intro,
			String pwd,String email,String dis,String cno) {
		String sql= "update teacher set Tname=?,sex=?,title=?,leadnum=?,intro=?,pwd=?,email=?,discipline=?,Cno=? where Tno=?";
		DBHelper.executeUpdate(sql,tname,sex,title,leadnum,intro,pwd,email,dis,cno,tno);
	}
	
	
	

	//��ѯ������ʦ��Tno,Cno
		public Teacher getTeacherByTnoCno(String tno,String cno) {
			Teacher teacher =new Teacher();
			String sql = "select * from teacher where Tno='"+tno+"' and Cno='"+cno+"'";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		teacher.setTno(rs.getString(1));
	        		teacher.setTname(rs.getString(2));
	        		teacher.setSex(rs.getString(3));
	        		teacher.setTitle(rs.getString(4));
	        		teacher.setLeadnum(rs.getString(5));
	        		teacher.setIntro(rs.getString(6));
	        		teacher.setPwd(rs.getString(7));
	        		teacher.setEmail(rs.getString(8));
	        		teacher.setDiscipline(rs.getString(9));
	        		teacher.setCno(rs.getString(10));
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return teacher;
		}
		//��ѯ��ʦ��Tname
				public ArrayList<Teacher> getTeachersByTname(String tname){
					ArrayList<Teacher> list = new ArrayList<Teacher>();
					String sql = "select * from Teacher where Tname='"+tname+"'";
					ResultSet rs = DBHelper.executeQuery(sql);
			        try{
			        	while (rs.next()) {
			        		Teacher teacher = new Teacher();
			        		teacher.setTno(rs.getString(1));
			        		teacher.setTname(rs.getString(2));
			        		teacher.setSex(rs.getString(3));
			        		teacher.setTitle(rs.getString(4));
			        		teacher.setLeadnum(rs.getString(5));
			        		teacher.setIntro(rs.getString(6));
			        		teacher.setPwd(rs.getString(7));
			        		teacher.setEmail(rs.getString(8));
			        		teacher.setDiscipline(rs.getString(9));
			        		teacher.setCno(rs.getString(10));
							list.add(teacher);
			        	}
			        } catch (Exception ex) {
						ex.printStackTrace();
					}
					DBHelper.closeConnection();
					return list;
				} 
		
		//��ѯ��ʦ��Tname,Cno
		public ArrayList<Teacher> getTeachersByTnameCno (String tname,String cno){
			ArrayList<Teacher> list = new ArrayList<Teacher>();
			String sql = "select * from Teacher where Tname='"+tname+"' and Cno='"+cno+"'";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		Teacher teacher = new Teacher();
	        		teacher.setTno(rs.getString(1));
	        		teacher.setTname(rs.getString(2));
	        		teacher.setSex(rs.getString(3));
	        		teacher.setTitle(rs.getString(4));
	        		teacher.setLeadnum(rs.getString(5));
	        		teacher.setIntro(rs.getString(6));
	        		teacher.setPwd(rs.getString(7));
	        		teacher.setEmail(rs.getString(8));
	        		teacher.setDiscipline(rs.getString(9));
	        		teacher.setCno(rs.getString(10));
					list.add(teacher);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		} 
	//��������
	public void updatePwd (String tno,String pwd) {
		String sql = "update teacher set pwd=? where Tno=?";
		DBHelper. executeUpdate(sql,pwd,tno);
	} 
	//ɾ����ʦ
	public void deleteByTno (String tno) {
		String sql = "delete from teacher where Tno=?";
		DBHelper. executeUpdate(sql,tno);
	} 
}
