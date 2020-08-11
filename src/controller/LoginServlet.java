package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdministratorDao;
import dao.CadminiDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Administrator;
import entity.Cadmini;
import entity.Student;
import entity.Teacher;


@WebServlet("/Login.action")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account=request.getParameter("account");
		String pwd=request.getParameter("pwd");
		
		int i=account.length();
		boolean p=false;
		
		//根据数据库设计，学生、教师、学院管理员、管理员的账号分别为8位、6位、5位、4位。
		switch(i){
		case 8:
			StudentDao stuDao=new StudentDao();
			Student stu=stuDao.getStudent(account);
			if(stu.getSno().equals(account)&&stu.getPwd().equals(pwd)) {
				p=true;
				request.getSession().setAttribute("stu", stu);
				response.sendRedirect("Student.jsp");
				}
			else
				response.sendRedirect("Login.html");
			break;
		case 6:
			TeacherDao teaDao=new TeacherDao();
			Teacher teacher=teaDao.getTeacher(account);
			if(teacher.getTno().equals(account)&&teacher.getPwd().equals(pwd)) {
				p=true;
				request.getSession().setAttribute("teacher", teacher);
				response.sendRedirect("Teacher\\Teacher.jsp");
				}
			else
				response.sendRedirect("Login.html");
			break;
		case 5:
			CadminiDao caDao=new CadminiDao();
			Cadmini cadmini=caDao.getCadmini(account);
			if(cadmini.getCAno().equals(account)&&cadmini.getPwd().equals(pwd)) {
				p=true;
				request.getSession().setAttribute("cadmini", cadmini);
				response.sendRedirect("CAdmini\\CAdmini.jsp");
				}
			else
				response.sendRedirect("Login.html");
			break;
		case 4:
			AdministratorDao dao=new AdministratorDao();
			Administrator admini=dao.getAdministrator(account);
			if(admini.getAno().equals(account)&&admini.getPwd().equals(pwd)) {
				p=true;
				request.getSession().setAttribute("admini", admini);
				response.sendRedirect("Administrator\\Administrator.jsp");
				}
			else
				response.sendRedirect("Login.html");
			break;
		}
		if(p==false)
			response.sendRedirect("Login.html");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
