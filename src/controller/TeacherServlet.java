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
import entity.Choose;
import entity.Student;
import entity.Teacher;

@WebServlet("/Teacher.action")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teaDao=new TeacherDao();
	private StudentDao stuDao=new StudentDao();
	private ChooseDao chooseDao=new ChooseDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opttype=request.getParameter("func");
		Teacher teacher=(Teacher)request.getSession().getAttribute("user");
		
		switch(opttype) {
		case "主页":
			response.sendRedirect("Teacher\\Tea_main.html");
			break;
		case "选择学生":
			//获取选择该老师的所有学生
			ArrayList<Choose> chooseList= chooseDao.getChooseByTno(teacher.getTno());
			ArrayList<Student> stuList=new ArrayList<Student> ();
			for (int i=0;i<chooseList.size();i++) 			
				stuList.add(  stuDao.getStudent( chooseList.get(i).getSno() )  );
			request.getSession().setAttribute("stuList", stuList);
			request.getSession().setAttribute("chooseList", chooseList);
			response.sendRedirect("Teacher\\Tea_choose.jsp");
			break;
		case "查看选择":
			ArrayList<Choose> chooseList0= chooseDao.getTeacherChooseByTno(teacher.getTno());
			ArrayList<Student> stuList0=new ArrayList<Student> ();
			for (int i=0;i<chooseList0.size();i++) 			
				stuList0.add(  stuDao.getStudent( chooseList0.get(i).getSno() )  );
			request.getSession().setAttribute("stuList", stuList0);
			request.getSession().setAttribute("chooseList", chooseList0);
			response.sendRedirect("Teacher\\Tea_check.jsp");
			break;
		case "更改密码":
			request.getSession().setAttribute("teacher", teaDao.getTeacher(teacher.getTno()));
			response.sendRedirect("Teacher\\Tea_person.jsp");
			break;
		case "安全退出":
			request.getSession().setAttribute("user", null);
			response.sendRedirect("Login.html");
			break;
		/****************************/
		case "选择":
			String choose_sno=request.getParameter("sno");
			chooseDao.addTeacherChoose(choose_sno, teacher.getTno());
			ArrayList<Choose> chooseList1= chooseDao.getChooseByTno(teacher.getTno());
			request.getSession().setAttribute("chooseList", chooseList1);
			response.sendRedirect("Teacher\\Tea_choose.jsp");
			break;
		case "退选":
			String cancel_sno=request.getParameter("sno");
			chooseDao.cancelChooseBySnoTno(cancel_sno, teacher.getTno());
			ArrayList<Choose> chooseList2= chooseDao.getChooseByTno(teacher.getTno());
			request.getSession().setAttribute("chooseList", chooseList2);
			ArrayList<Student> stuList2=new ArrayList<Student> ();
			for (int i=0;i<chooseList2.size();i++) 			
				stuList2.add(  stuDao.getStudent( chooseList2.get(i).getSno() )  );
			request.getSession().setAttribute("stuList", stuList2);
			response.sendRedirect("Teacher\\Tea_choose.jsp");
			break;
		case "确认更新":
			String oldpwd=request.getParameter("oldpwd");
			String newpwd=request.getParameter("newpwd");
			//旧密码相同，执行更新
			if(oldpwd.equals(teacher.getPwd())) 
				teaDao.updatePwd(teacher.getTno(), newpwd);
			response.sendRedirect("Teacher\\Tea_person.jsp");
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
