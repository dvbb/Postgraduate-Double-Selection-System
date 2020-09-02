package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChooseDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Cmanager;
import entity.Student;
import entity.Teacher;

@WebServlet("/Cmanager.action")
public class CmanagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StudentDao stuDao=new StudentDao();  
	private static TeacherDao teaDao=new TeacherDao();
	private static ChooseDao chooseDao=new ChooseDao();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opttype=request.getParameter("func");
		request.getSession().setAttribute("stu",null);
		request.getSession().setAttribute("teacher",null);
		
		//获取session中的用户
		Cmanager cmanager=(Cmanager)request.getSession().getAttribute("user");
		String cno=cmanager.getCno();
		request.getSession().setAttribute("cno",cmanager.getCno());
		switch(opttype) {
		case "主页":
			response.sendRedirect("Cmanager\\Cmanager_main.html");
			break;
		case "学生信息管理":
			request.getSession().setAttribute("stuList", stuDao.getAllStudents(cno));
			response.sendRedirect("Cmanager\\Cmanager_stu.jsp");
			break;
		case "教师信息管理":
			request.getSession().setAttribute("teacherList",teaDao.getAllTeachers());
			response.sendRedirect("Cmanager\\Cmanager_tea.jsp");
			break;
		case "双选信息管理":
			request.getSession().setAttribute("chooseList",chooseDao.getAll());
			response.sendRedirect("Cmanager\\Cmanager_choose.jsp");
			break;
		case "安全退出":
			request.getSession().setAttribute("user", null);
			response.sendRedirect("Login.html");
			break;
		/****************************/
		case "新增学生":
			String sadd_sno=request.getParameter("sno");
			String sadd_sname=request.getParameter("sname");
			String sadd_sex=request.getParameter("sex");
			String sadd_grade=request.getParameter("grade");
			String sadd_school=request.getParameter("school");
			String sadd_pwd=request.getParameter("pwd");
			String sadd_dis=request.getParameter("dis");
			String sadd_email=request.getParameter("email");
			String sadd_phone=request.getParameter("phone");
			String sadd_cno=cmanager.getCno();
			stuDao.addStudent(sadd_sno, sadd_sname, sadd_sex, sadd_grade, sadd_school, sadd_pwd, sadd_dis, sadd_email, sadd_phone, sadd_cno);
			request.getSession().setAttribute("stuList", stuDao.getAllStudents(cno));
			response.sendRedirect("Cmanager\\Cmanager_stu.jsp");
			break;
		case "修改学生":
			String modify_sno=request.getParameter("modifysno");
			String modify_sname=request.getParameter("sname");
			String modify_sex=request.getParameter("sex");
			String modify_grade=request.getParameter("grade");
			String modify_school=request.getParameter("school");
			String modify_pwd=request.getParameter("pwd");
			String modify_dis=request.getParameter("dis");
			String modify_email=request.getParameter("email");
			String modify_phone=request.getParameter("phone");
			String modify_cno=request.getParameter("cno");
			stuDao.updateStudent(modify_sno, modify_sname, modify_sex, modify_grade, modify_school, modify_pwd, modify_dis, modify_email, modify_phone, modify_cno);
			request.getSession().setAttribute("stuList", stuDao.getAllStudents(cno));
			response.sendRedirect("Cmanager\\Cmanager_stu.jsp");
			break;
		case "删除学生":
			String sdelete_sno=request.getParameter("sno");
			stuDao.deleteStudents(sdelete_sno);
			request.getSession().setAttribute("stuList", stuDao.getAllStudents(cno));
			response.sendRedirect("Cmanager\\Cmanager_stu.jsp");
			break;
		case "获取学生":
			String search_sno=request.getParameter("sno");
			ArrayList<Student> slist = new ArrayList<Student>();
			slist.add(stuDao.getStudent(search_sno));
			request.getSession().setAttribute("stu",slist);
			response.sendRedirect("Cmanager\\Cmanager_stu.jsp");
			break;
		case "新增教师":
			String tadd_tno=request.getParameter("tno");
			String tadd_tname=request.getParameter("tname");
			String tadd_sex=request.getParameter("sex");
			String tadd_title=request.getParameter("title");
			String tadd_leadnum=request.getParameter("leadnum");
			String tadd_intro=request.getParameter("intro");
			String tadd_pwd=request.getParameter("pwd");
			String tadd_email=request.getParameter("email");
			String tadd_dis=request.getParameter("dis");
			String tadd_cno=request.getParameter("cno");
			teaDao.addTeacher(tadd_tno, tadd_tname, tadd_sex, tadd_title, tadd_leadnum, tadd_intro, tadd_pwd, tadd_email, tadd_dis, tadd_cno);
			request.getSession().setAttribute("teacherList",teaDao.getAllTeachers(cmanager.getCno()));
			response.sendRedirect("Cmanager\\Cmanager_tea.jsp");
			break;
		case "修改教师":
			String tmodify_tno=request.getParameter("tno");
			String tmodify_tname=request.getParameter("tname");
			String tmodify_sex=request.getParameter("sex");
			String tmodify_title=request.getParameter("title");
			String tmodify_leadnum=request.getParameter("leadnum");
			String tmodify_intro=request.getParameter("intro");
			String tmodify_pwd=request.getParameter("pwd");
			String tmodify_email=request.getParameter("email");
			String tmodify_dis=request.getParameter("dis");
			String tmodify_cno=request.getParameter("cno");
			teaDao.updateTeacherByTno(tmodify_tno, tmodify_tname, tmodify_sex, tmodify_title, tmodify_leadnum, tmodify_intro, tmodify_pwd, tmodify_email, tmodify_dis,tmodify_cno);
			request.getSession().setAttribute("teacherList",teaDao.getAllTeachers(cmanager.getCno()));
			response.sendRedirect("Cmanager\\Cmanager_tea.jsp");
			break;
		case "删除教师":
			String tdelete_tno=request.getParameter("tno");
			teaDao.deleteByTno(tdelete_tno);
			request.getSession().setAttribute("teacherList",teaDao.getAllTeachers(cmanager.getCno()));
			response.sendRedirect("Cmanager\\Cmanager_tea.jsp");
			break;
		case "获取教师":
			String tsearch_tno=request.getParameter("searchTno");
			ArrayList<Teacher> tlist = new ArrayList<Teacher>();
			tlist.add(teaDao.getTeacher(tsearch_tno));
			request.getSession().setAttribute("teacher",tlist);
			response.sendRedirect("Cmanager\\Cmanager_tea.jsp");
			break;
		case "新增双选关系":
			String choose_sno=request.getParameter("sno");
			String choose_tno=request.getParameter("tno");
			String choose_cno=request.getParameter("cno");
			String choose_wish=request.getParameter("wish");
			String choose_status=request.getParameter("status");
			chooseDao.addChoose(choose_sno, choose_tno, choose_cno, choose_status, choose_wish);
			request.getSession().setAttribute("chooseList",chooseDao.getAll(cmanager.getCno()));
			response.sendRedirect("Cmanager\\Cmanager_choose.jsp");
			break;
		case "确认双选关系":
			String chooseConfirmSno=request.getParameter("sno");
			String chooseConfirmWish=request.getParameter("wish");
			chooseDao.chooseConfirm(chooseConfirmSno, chooseConfirmWish);
			request.getSession().setAttribute("chooseList",chooseDao.getAll(cmanager.getCno()));
			response.sendRedirect("Cmanager\\Cmanager_choose.jsp");
			break;
		case "删除双选关系":
			String chooseDeleteSno=request.getParameter("sno");
			String chooseDeleteWish=request.getParameter("wish");
			chooseDao.delete(chooseDeleteSno, chooseDeleteWish);
			request.getSession().setAttribute("chooseList",chooseDao.getAll(cmanager.getCno()));
			response.sendRedirect("Cmanager\\Cmanager_choose.jsp");
			break;
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
