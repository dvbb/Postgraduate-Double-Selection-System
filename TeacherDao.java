package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import dbuilt.DBHelper;
import entity.Teacher;

public class TeacherDao {
	//新增教师
	public void addTeacher(String tno,String tname,String sex,String title,String leadnum,String intro,
			String pwd,String email,String dis,String cno) {
		String sql="insert into teacher values(?,?,?,?,?,?,?,?,?,?)";
		DBHelper.executeUpdate(sql, tno,tname,sex,title,leadnum,intro,pwd,email,dis,cno);
	}
	//更新教师信息ByTno
	public void updateTeacherByTno(String tno,String tname,String sex,String title,String leadnum,String intro,
			String pwd,String email,String dis) {
		String sql= "update teacher set Tname=?,sex=?,title=?,leadnum=?,intro=?,pwd=?,email=?,discipline=? where Tno=?";
		DBHelper.executeUpdate(sql,tname,sex,title,leadnum,intro,pwd,email,dis,tno);
	}
	//查询全部教师
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
        		teacher.setLeadnum(rs.getInt(5));
        		teacher.setIntro(rs.getString(6));
        		teacher.setPwd(rs.getString(7));
        		teacher.setEmail(rs.getString(8));
        		teacher.setDiscipline(rs.getString(9));
        		teacher.setCno(rs.getInt(10));
				list.add(teacher);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	
	//查询教师,Cno，discipline
	public ArrayList<Teacher> getTeachersByCnoByDis (String cno,String dis){
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from Teacher where Cno="+cno+" and discipline='"+dis+"';";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Teacher teacher = new Teacher();
        		teacher.setTno(rs.getString(1));
        		teacher.setTname(rs.getString(2));
        		teacher.setSex(rs.getString(3));
        		teacher.setTitle(rs.getString(4));
        		teacher.setLeadnum(rs.getInt(5));
        		teacher.setIntro(rs.getString(6));
        		teacher.setPwd(rs.getString(7));
        		teacher.setEmail(rs.getString(8));
        		teacher.setDiscipline(rs.getString(9));
        		teacher.setCno(rs.getInt(10));
				list.add(teacher);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
//	select * from Teacher where Cno=1 and discipline='软件工程';
	//查询单个教师，Tno
	public Teacher getTeacher(String tno) {
		Teacher teacher =new Teacher();
		String sql = "select * from teacher where Tno=\'"+tno+"\'";
//		String sql = "select * from teacher where Tno='t01001'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		teacher.setTno(rs.getString(1));
        		teacher.setTname(rs.getString(2));
        		teacher.setSex(rs.getString(3));
        		teacher.setTitle(rs.getString(4));
        		teacher.setLeadnum(rs.getInt(5));
        		teacher.setIntro(rs.getString(6));
        		teacher.setPwd(rs.getString(7));
        		teacher.setEmail(rs.getString(8));
        		teacher.setDiscipline(rs.getString(9));
        		teacher.setCno(rs.getInt(10));
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return teacher;
	}
	//查询单个教师，Tno,Cno
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
	        		teacher.setLeadnum(rs.getInt(5));
	        		teacher.setIntro(rs.getString(6));
	        		teacher.setPwd(rs.getString(7));
	        		teacher.setEmail(rs.getString(8));
	        		teacher.setDiscipline(rs.getString(9));
	        		teacher.setCno(rs.getInt(10));
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return teacher;
		}
		//查询教师，Tname
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
			        		teacher.setLeadnum(rs.getInt(5));
			        		teacher.setIntro(rs.getString(6));
			        		teacher.setPwd(rs.getString(7));
			        		teacher.setEmail(rs.getString(8));
			        		teacher.setDiscipline(rs.getString(9));
			        		teacher.setCno(rs.getInt(10));
							list.add(teacher);
			        	}
			        } catch (Exception ex) {
						ex.printStackTrace();
					}
					DBHelper.closeConnection();
					return list;
				} 
		
		//查询教师，Tname,Cno
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
	        		teacher.setLeadnum(rs.getInt(5));
	        		teacher.setIntro(rs.getString(6));
	        		teacher.setPwd(rs.getString(7));
	        		teacher.setEmail(rs.getString(8));
	        		teacher.setDiscipline(rs.getString(9));
	        		teacher.setCno(rs.getInt(10));
					list.add(teacher);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		} 
	//更新密码
	public void updatePwd (String tno,String pwd) {
		String sql = "update teacher set pwd=? where Tno=?";
		DBHelper. executeUpdate(sql,pwd,tno);
	} 
	//删除教师
	public void deleteByTno (String tno) {
		String sql = "delete from teacher where Tno=?";
		DBHelper. executeUpdate(sql,tno);
	} 
}
