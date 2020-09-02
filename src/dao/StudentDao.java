package dao;


import java.sql.ResultSet;
import java.util.ArrayList;

import dbuilt.DBHelper;

import entity.Student;

public class StudentDao {
	/************************************************/
	//查询,Sno
	public Student getStudent (String sno){
		
		Student stu = new Student();
		String sql = "select * from student where Sno="+sno;
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		stu.setSno(rs.getString(1));
        		stu.setSname(rs.getString(2));
        		stu.setSex(rs.getString(3));
        		stu.setGrade(rs.getString(4));
        		stu.setSchool(rs.getString(5));
        		stu.setPwd(rs.getString(6));
        		stu.setDiscipline(rs.getString(7));
        		stu.setEmail(rs.getString(8));
        		stu.setPhone(rs.getString(9));
        		stu.setCno(rs.getString(10));
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
	/************************************************/
	//添加
	public void addStudent(String sno,String sname,String sex,String grade,String school,String pwd,String dis,String email,String phone,String cno) {
		String sql="insert into student values(?,?,?,?,?,?,?,?,?,?)";
		DBHelper.executeUpdate(sql,sno,sname,sex,grade,school,pwd,dis,email,phone,cno);
	} 
	//修改,sno
		public void updateStudent(String sno,String sname,String sex,String grade,String school,String pwd,String dis,String email,String phone,String cno) {
			String sql = "update student set Sname=?,sex=?,grade=?,school=?,pwd=?,discipline=?,email=?,phone=?,Cno=? where Sno=?";
			DBHelper.executeUpdate(sql,sname,sex,grade,school,pwd,dis,email,phone,cno,sno);
			
		} 
		//查询一个学院的全部
		public ArrayList<Student> getAllStudents (String cno){
			ArrayList<Student> list = new ArrayList<Student>();
			String sql = "select * from student where Cno="+cno;
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		Student stu = new Student();
	        		stu.setSno(rs.getString(1));
	        		stu.setSname(rs.getString(2));
	        		stu.setSex(rs.getString(3));
	        		stu.setGrade(rs.getString(4));
	        		stu.setSchool(rs.getString(5));
	        		stu.setPwd(rs.getString(6));
	        		stu.setDiscipline(rs.getString(7));
	        		stu.setEmail(rs.getString(8));
	        		stu.setPhone(rs.getString(9));
	        		stu.setCno(rs.getString(10));
					list.add(stu);
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return list;
		} 	
	//查询全部
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
        		stu.setGrade(rs.getString(4));
        		stu.setSchool(rs.getString(5));
        		stu.setPwd(rs.getString(6));
        		stu.setDiscipline(rs.getString(7));
        		stu.setEmail(rs.getString(8));
        		stu.setPhone(rs.getString(9));
        		stu.setCno(rs.getString(10));
				list.add(stu);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	
	//删除bySno
	public void deleteStudents (String sno) {
		String sql = "delete from student where Sno=?";
		DBHelper. executeUpdate(sql,sno);
	} 
	
}
 