package dao;


import java.sql.ResultSet;
import java.util.ArrayList;

import dbuilt.DBHelper;

import entity.Student;

public class StudentDao {
	
	//添加单个
	public void addStudent(String sno,String sname,String sex,String school,String dis,String pwd,int grade,int cno) {
		String sql="insert into student values(?,?,?,?,?,?,?,?)";
		DBHelper.executeUpdate(sql,sno,sname,sex,grade,school,pwd,dis,cno);
	} 

	//查询全部-学号排序
	public ArrayList<Student> getAllStudents (){
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "select * from student ";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Student stu = new Student();
        		stu.setSno(rs.getString(1));
        		stu.setSname(rs.getString(2));
        		stu.setSex(rs.getString(3));
        		stu.setGrade(rs.getInt(4));
        		stu.setSchool(rs.getString(5));
        		stu.setPwd(rs.getString(6));
        		stu.setDiscipline(rs.getString(7));
        		stu.setCno(rs.getInt(8));
				list.add(stu);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//查询 by姓名byCno
		public ArrayList<Student> getStudentByName (String name,String cno){
			ArrayList<Student> list = new ArrayList<Student>();
			String sql = "select * from student where Sname='"+name+"'and Cno='"+cno+"'";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		Student stu = new Student();
	        		stu.setSno(rs.getString(1));
	        		stu.setSname(rs.getString(2));
	        		stu.setSex(rs.getString(3));
	        		stu.setGrade(rs.getInt(4));
	        		stu.setSchool(rs.getString(5));
	        		stu.setPwd(rs.getString(6));
	        		stu.setDiscipline(rs.getString(7));
	        		stu.setCno(rs.getInt(8));
					list.add(stu);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		} 
		//查询 by姓名
				public ArrayList<Student> getStudentByName (String name){
					ArrayList<Student> list = new ArrayList<Student>();
					String sql = "select * from student where Sname='"+name+"'";
					ResultSet rs = DBHelper.executeQuery(sql);
			        try{
			        	while (rs.next()) {
			        		Student stu = new Student();
			        		stu.setSno(rs.getString(1));
			        		stu.setSname(rs.getString(2));
			        		stu.setSex(rs.getString(3));
			        		stu.setGrade(rs.getInt(4));
			        		stu.setSchool(rs.getString(5));
			        		stu.setPwd(rs.getString(6));
			        		stu.setDiscipline(rs.getString(7));
			        		stu.setCno(rs.getInt(8));
							list.add(stu);
			        	}
			        } catch (Exception ex) {
						ex.printStackTrace();
					}
					DBHelper.closeConnection();
					return list;
				} 
	//查询单个-by学号
	public Student getStudent (String sno){
		
		Student stu = new Student();
		String sql = "select * from student where Sno="+sno;
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		stu.setSno(rs.getString(1));
        		stu.setSname(rs.getString(2));
        		stu.setSex(rs.getString(3));
        		stu.setGrade(rs.getInt(4));
        		stu.setSchool(rs.getString(5));
        		stu.setPwd(rs.getString(6));
        		stu.setDiscipline(rs.getString(7));
        		stu.setCno(rs.getInt(8));
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return stu;
	} 
	//查询单个-by学号byCno
		public Student getStudent (String sno,String cno){
			
			Student stu = new Student();
			String sql = "select * from student where Sno='"+sno+"'and Cno='"+cno+"'";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		stu.setSno(rs.getString(1));
	        		stu.setSname(rs.getString(2));
	        		stu.setSex(rs.getString(3));
	        		stu.setGrade(rs.getInt(4));
	        		stu.setSchool(rs.getString(5));
	        		stu.setPwd(rs.getString(6));
	        		stu.setDiscipline(rs.getString(7));
	        		stu.setCno(rs.getInt(8));
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return stu;
		} 
	//更新密码
	public void updatePwd (String sno,String pwd) {
		String sql = "update student set pwd=? where Sno=?";
		DBHelper. executeUpdate(sql,pwd,sno);
	} 
	//更新全部信息bySname
	public void updateStudent (String sno,String name,String sex,String grade,String school,String pwd,String dis) {
		String sql = "update student set Sname=?,sex=?,grade=?,school=?,pwd=?,discipline=? where Sno=?";
		DBHelper.executeUpdate(sql,name,sex,grade,school,pwd,dis,sno);
		
	} 
	//删除bySno
	public void deleteStudents (String sno) {
		String sql = "delete from student where Sno=?";
		DBHelper. executeUpdate(sql,sno);
	} 
	
}
 