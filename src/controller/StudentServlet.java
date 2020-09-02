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
import entity.Student;
import entity.Teacher;

@WebServlet("/student.action")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao stuDao=new StudentDao();
	private	TeacherDao teaDao=new TeacherDao();
	private ChooseDao chooseDao=new ChooseDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡsession�е��û�
		Student stu=(Student)request.getSession().getAttribute("user");
		String opttype=request.getParameter("func");
		switch(opttype) {
		case "��ҳ":		
			response.sendRedirect("Student\\Stu_main.html");
			break;
		case "ѡ��ʦ":	
			ArrayList<Teacher> tlist=teaDao.getTeachersByCnoDis(stu.getCno(), stu.getDiscipline());
			request.getSession().setAttribute("tlist", tlist);
			request.getSession().setAttribute("chooselist", chooseDao.getChooseBySno(stu.getSno()));
			response.sendRedirect("Student\\Stu_choose.jsp");
			break;
		case "�鿴ѡ��":		
			ArrayList<Teacher> ctlist=teaDao.getTeachersByCnoDis(stu.getCno(), stu.getDiscipline());
			request.getSession().setAttribute("tlist", ctlist);
			request.getSession().setAttribute("chooselist", chooseDao.getChooseBySno(stu.getSno()));
			response.sendRedirect("Student\\Stu_check.jsp");
			break;
		case "��������":		
			response.sendRedirect("Student\\Stu_person.jsp");
			break;
		case "��ȫ�˳�":		
			response.sendRedirect("Login.html");
			request.getSession().setAttribute("user", null);
			break;	
			
		/*************ҳ����չ���ܿ���*************/	
		case "ѡ��־Ը":
			String wish=request.getParameter("wish");
			String cTno=request.getParameter("Tno");
			chooseDao.addStuChoose(stu.getSno(), cTno, stu.getCno(), wish);
			request.getSession().setAttribute("chooselist", chooseDao.getChooseBySno(stu.getSno()));
			response.sendRedirect("Student\\Stu_choose.jsp");
			break;
		case "��ѡ":
			String tTno=request.getParameter("Tno");
			chooseDao.deleteBySnoTno(stu.getSno(), tTno);
			request.getSession().setAttribute("chooselist", chooseDao.getChooseBySno(stu.getSno()));
			response.sendRedirect("Student\\Stu_choose.jsp");
			break;
		case "ȷ�ϸ���":
			String oldpwd=request.getParameter("oldpwd");
			String newpwd=request.getParameter("newpwd");
			//��������ͬ��ִ�и���
			if(oldpwd.equals(stu.getPwd())) 
				stuDao.updatePwd(stu.getSno(), newpwd);
			response.sendRedirect("Student\\Stu_person.jsp");
			break;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
