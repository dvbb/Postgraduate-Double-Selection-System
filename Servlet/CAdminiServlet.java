package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CadminiDao;
import dao.ChooseDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Choose;
import entity.Student;
import entity.Teacher;

@WebServlet("/CAdmini.action")
public class CAdminiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teaDao=new TeacherDao();
	private StudentDao stuDao=new StudentDao();
	private CadminiDao cadDao=new CadminiDao();
	private ChooseDao chooseDao=new ChooseDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opttype=request.getParameter("func");
		String cano=request.getParameter("cano");
		String cno=request.getParameter("cno");
		
		switch(opttype) {
		case "主页":
			response.sendRedirect("CAdmini\\CAdmini.jsp");
			break;
		case "新增人员":
			response.sendRedirect("CAdmini\\CAdmini_add.jsp");
			break;
		case "查看双选":
			request.getSession().setAttribute("chooseList", chooseDao.getAllChoose(cno));
			response.sendRedirect("CAdmini\\CAdmini_check.jsp");
			break;
		case "维护学生信息":
			request.getSession().setAttribute("stulist",null );
			response.sendRedirect("CAdmini\\CAdmini_mtStu.jsp");
			break;
		case "维护教师信息":
			response.sendRedirect("CAdmini\\CAdmini_mtTea.jsp");
			break;
		case "更改密码":
			response.sendRedirect("CAdmini\\CAdmini_person.jsp");
			break;
		case "安全退出":
			response.sendRedirect("Login.html");
			break;
		case "add_student":
			String sno=request.getParameter("sno");
			String sname=request.getParameter("sname");
			String ssex=request.getParameter("ssex");
			String grade=request.getParameter("grade");
			String school=request.getParameter("school");
			String sdiscipline=request.getParameter("sdiscipline");
			String scno=request.getParameter("scno");
			int sscno = Integer.parseInt(scno);
			int ggrade=Integer.parseInt(grade);
			stuDao.addStudent(sno, sname, ssex, school, sdiscipline, "123", ggrade, sscno);
			break;
		case "add_teacher":
			String tno=request.getParameter("tno");
			String tname=request.getParameter("tname");
			String tsex=request.getParameter("tsex");
			String title=request.getParameter("title");
			String leadnum=request.getParameter("leadnum");
			String intro=request.getParameter("intro");
			String email=request.getParameter("email");
			String tdiscipline=request.getParameter("tdiscipline");
			String cno5=request.getParameter("cno");
			teaDao.addTeacher(tno, tname, tsex, title, leadnum, intro, "123",email, tdiscipline, cno5);
			break;
		case "查询选择":
			String inqueryType=request.getParameter("inqueryType");
			String message=request.getParameter("message");
			String cno3=request.getParameter("cno");
			ArrayList<Choose> cholist=new ArrayList<Choose>();
			switch(inqueryType) {
			case "stuno":
				cholist=chooseDao.getChooseBySnoCno(message,cno3);			
				break;
			case "teano":
				cholist=chooseDao.getChooseByTnoCno(message,cno3);
				break;	
			}
			request.getSession().setAttribute("chooseList", cholist);
			response.sendRedirect("CAdmini\\CAdmini_check.jsp");
			break;
		case "查询学生":
			String inqueryType2=request.getParameter("inqueryType");
			String message2=request.getParameter("message");
			String cno1=request.getParameter("cno");
			ArrayList<Student> stulist=new ArrayList<Student>();
			switch(inqueryType2) {
			case "sno":
				stulist.add(stuDao.getStudent(message2,cno1));
				break;
			case "sname":
				stulist=stuDao.getStudentByName(message2,cno1);		
				break;
			}
			request.getSession().setAttribute("stulist",stulist );
			response.sendRedirect("CAdmini\\CAdmini_mtStu.jsp");
			break;
		case "更新学生信息":
			String sno1=request.getParameter("sno");
			String sname1=request.getParameter("sname");
			String sex=request.getParameter("sex");
			String grade2=request.getParameter("grade");
			String school2=request.getParameter("school");
			String pwd=request.getParameter("pwd");
			String dis=request.getParameter("discipline");
			System.out.println(sno1+" "+sname1+" "+sex+" "+grade2+" "+school2+" "+pwd+" "+dis);
			stuDao.updateStudent(sno1, sname1, sex, grade2, school2, pwd, dis);
			response.sendRedirect("CAdmini\\CAdmini_mtStu.jsp");
			break;
		case "删除学生":
			String sno2=request.getParameter("sno");
			stuDao.deleteStudents(sno2);
			response.sendRedirect("CAdmini\\CAdmini_mtStu.jsp");
			break;
		case "查询教师":
			String inqueryType3=request.getParameter("inqueryType");
			String message3=request.getParameter("message");
			String cno2=request.getParameter("cno");
			ArrayList<Teacher> tealist=new ArrayList<Teacher>();
			switch(inqueryType3) {
			case "teano":
				tealist.add(teaDao.getTeacher(message3));
				break;
			case "teaname":
				tealist=teaDao.getTeachersByTnameCno(message3, cno2);
				break;
			}
			request.getSession().setAttribute("tealist", tealist);
			response.sendRedirect("CAdmini\\CAdmini_mtTea.jsp");
			break;
		case "更新教师信息":
			String tno1=request.getParameter("tno");
			String tname1=request.getParameter("tname");
			String sex1=request.getParameter("sex");
			String title1=request.getParameter("title");
			String leadnum1=request.getParameter("leadnum");
			String intro1=request.getParameter("intro");
			String pwd1=request.getParameter("pwd");
			String email1=request.getParameter("email");
			String dis1=request.getParameter("dis");
			System.out.println(tno1+" "+ tname1+" "+sex1+" " +title1+" "+ leadnum1+" "+ intro1+" "+ pwd1+" "+ email1+" "+ dis1);
			teaDao.updateTeacherByTno(tno1, tname1, sex1, title1, leadnum1, intro1, pwd1, email1, dis1);
			response.sendRedirect("CAdmini\\CAdmini_mtTea.jsp");
			break;
		case "删除教师":
			String tno2=request.getParameter("tno");
			teaDao.deleteByTno(tno2);
			response.sendRedirect("CAdmini\\CAdmini_mtTea.jsp");
			break;
		case "pwdUpdate":
			String oldpwd=request.getParameter("oldpwd");
			String newpwd=request.getParameter("newpwd");
			if(oldpwd.equals(cadDao.getCadmini(cano).getPwd()))
				cadDao.updatePWD(cano, newpwd);
			response.sendRedirect("CAdmini\\CAdmini_person.jsp");
			break;	
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
