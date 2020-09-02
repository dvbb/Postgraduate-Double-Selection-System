package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CmanagerDao;
import dao.ManagerDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Cmanager;
import entity.Manager;
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
				request.getSession().setAttribute("user", stu);
				response.sendRedirect("Student\\Stu_main.html");
				}
			else
				response.sendRedirect("Login.html");
			break;
		case 6:
			TeacherDao teaDao=new TeacherDao();
			Teacher teacher=teaDao.getTeacher(account);
			if(teacher.getTno().equals(account)&&teacher.getPwd().equals(pwd)) {
				p=true;
				request.getSession().setAttribute("user", teacher);
				response.sendRedirect("Teacher\\Tea_main.html");
			}
			else
				response.sendRedirect("Login.html");
			break;
		case 5:
			CmanagerDao cmDao=new CmanagerDao();
			Cmanager cmanager=cmDao.getCadmini(account);
			if(cmanager.getCmno().equals(account)&&cmanager.getPwd().equals(pwd)) {
				p=true;
				request.getSession().setAttribute("user", cmanager);
				response.sendRedirect("Cmanager\\Cmanager_main.html");
			}
			else
				response.sendRedirect("Login.html");
			break;
		case 4:
			ManagerDao mDao=new ManagerDao();
			Manager manager=mDao.getManager(account);
			if(manager.getMno().equals(account)&&manager.getPwd().equals(pwd)) {
				p=true;
				request.getSession().setAttribute("user", manager);
				response.sendRedirect("Manager\\Manager_main.html");
			}
			break;
		}
		if(p==false)
			response.sendRedirect("Login.html");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
