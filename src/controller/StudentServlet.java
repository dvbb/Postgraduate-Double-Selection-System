package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChooseDao;
import dao.StudentDao;
import dao.TeacherDao;

@WebServlet("/student.action")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao stuDao=new StudentDao();
	private ChooseDao chooseDao=new ChooseDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opttype=request.getParameter("func");
		//��ȡ��ǰѧ����Ϣ
		String sno=request.getParameter("sno");
		String cno=request.getParameter("cno");
		String dis=request.getParameter("discipline");
		switch(opttype) {
		case "��ҳ":
			request.getSession().setAttribute("stu", stuDao.getStudent(sno));
			response.sendRedirect("Student.jsp");
			break;
		case "ѡ��ʦ":		
			//��ѯ��ѡ��ĵ�ʦ
			TeacherDao tdao=new TeacherDao();
			request.getSession().setAttribute("tlist", tdao.getTeachersByCnoByDis(cno, dis));
			request.getSession().setAttribute("chooselist", chooseDao.getChooseBySno(sno));
			response.sendRedirect("Stu_choose.jsp");
			break;
		case "�鿴ѡ��":		
			//��ѯ�Ѿ�ѡ��ĵ�ʦ
			request.getSession().setAttribute("chooselist", chooseDao.getChooseBySno(sno));
			response.sendRedirect("Stu_check.jsp");
			break;
		case "��������":		
			response.sendRedirect("Stu_person.jsp");
			break;
		case "��ȫ�˳�":		
			response.sendRedirect("Login.html");
			break;
		case "choose":		
			String tno=request.getParameter("tno");
			chooseDao.addStuChoose(sno, tno, cno);
			request.getSession().setAttribute("chooselist", chooseDao.getChooseBySno(sno));
			response.sendRedirect("Stu_choose.jsp");
			break;
		case "cancel":
			String tno2=request.getParameter("tno");
			chooseDao.deleteChooseBySnoTno(sno, tno2);
			request.getSession().setAttribute("chooselist", chooseDao.getChooseBySno(sno));
			response.sendRedirect("Stu_choose.jsp");
			break;	
		case "pwdUpdate":
			String oldpwd=request.getParameter("oldpwd");
			String newpwd=request.getParameter("newpwd");
			System.out.println(oldpwd);
			System.out.println(newpwd);
			//��������ͬ��ִ�и���
			if(oldpwd.equals(stuDao.getStudent(sno).getPwd())) 
				stuDao.updatePwd(sno, newpwd);
			response.sendRedirect("Stu_person.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
