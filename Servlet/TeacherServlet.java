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

@WebServlet("/Teacher.action")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teaDao=new TeacherDao();
	private StudentDao stuDao=new StudentDao();
	private ChooseDao chooseDao=new ChooseDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opttype=request.getParameter("func");
		String tno=request.getParameter("tno");
		
		switch(opttype) {
		case "主页":
			request.getSession().setAttribute("teacher", teaDao.getTeacher(tno));
			response.sendRedirect("Teacher\\Teacher.jsp");
			break;
		case "选择学生":
			//获取选择该老师的所有学生
			ArrayList<Choose> chooseList= chooseDao.getChooseByTno(tno);
			ArrayList<Student> stuList=new ArrayList<Student> ();
			for (int i=0;i<chooseList.size();i++) 			
				stuList.add(  stuDao.getStudent( chooseList.get(i).getSno() )  );
			request.getSession().setAttribute("stuList", stuList);
			request.getSession().setAttribute("chooseList", chooseList);
			response.sendRedirect("Teacher\\Teacher_choose.jsp");
			break;
		case "查看选择":
			ArrayList<Choose> chooseList0= chooseDao.getTeacherChooseByTno(tno);
			ArrayList<Student> stuList0=new ArrayList<Student> ();
			for (int i=0;i<chooseList0.size();i++) 			
				stuList0.add(  stuDao.getStudent( chooseList0.get(i).getSno() )  );
			request.getSession().setAttribute("stuList", stuList0);
			request.getSession().setAttribute("chooseList", chooseList0);
			response.sendRedirect("Teacher\\Teacher_check.jsp");
			break;
		case "更改密码":
			
			request.getSession().setAttribute("teacher", teaDao.getTeacher(tno));
			response.sendRedirect("Teacher\\Teacher_person.jsp");
			break;
		case "安全退出":
			response.sendRedirect("Login.html");
			break;
		case "choose":
			String sno=request.getParameter("sno");
			chooseDao.addTeacherChoose(sno, tno);
			//为了保证页面的及时更新，重新将改变的choose的值放入chooseList
			ArrayList<Choose> chooseList1= chooseDao.getChooseByTno(tno);
			request.getSession().setAttribute("chooseList", chooseList1);
			response.sendRedirect("Teacher\\Teacher_choose.jsp");
			break;
		case "cancel":
			String sno1=request.getParameter("sno");
			chooseDao.cancelChooseBySnoTno(sno1, tno);
			//为了保证页面的及时更新，重新将改变的choose的值放入chooseList
			ArrayList<Choose> chooseList2= chooseDao.getChooseByTno(tno);
			request.getSession().setAttribute("chooseList", chooseList2);
			response.sendRedirect("Teacher\\Teacher_choose.jsp");
			break;
		case "cancel_byCheckFrm":
			String sno3=request.getParameter("sno");
			chooseDao.cancelChooseBySnoTno(sno3, tno);
			//为了保证页面的及时更新，重新将改变的choose的值放入chooseList
			ArrayList<Choose> chooseList3= chooseDao.getChooseByTno(tno);
			request.getSession().setAttribute("chooseList", chooseList3);
			response.sendRedirect("Teacher\\Teacher_check.jsp");
			break;
		case "pwdUpdate":
			String oldpwd=request.getParameter("oldpwd");
			String newpwd=request.getParameter("newpwd");
			System.out.println(oldpwd);
			System.out.println(newpwd);
			//旧密码相同，执行更新
			if(oldpwd.equals(teaDao.getTeacher(tno).getPwd())) 
				teaDao.updatePwd(tno, newpwd);
			response.sendRedirect("Teacher\\Teacher_person.jsp");
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
