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


@WebServlet("/Administrator.action")
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teaDao=new TeacherDao();
	private StudentDao stuDao=new StudentDao();
	private CadminiDao cadDao=new CadminiDao();
	private ChooseDao chooseDao=new ChooseDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String opttype=request.getParameter("func");
		String cano=request.getParameter("cano");
		
		switch(opttype) {
		case "��ҳ":
			response.sendRedirect("Administrator\\Administrator.jsp");
			break;
		case "������Ա":
			response.sendRedirect("Administrator\\Administrator_add.jsp");
			break;
		case "�鿴˫ѡ":
			request.getSession().setAttribute("chooseList", chooseDao.getAllChoose());
			response.sendRedirect("Administrator\\Administrator_check.jsp");
			break;
		case "ά��ѧ����Ϣ":
			request.getSession().setAttribute("stulist",null );
			response.sendRedirect("Administrator\\Administrator_mtStu.jsp");
			break;
		case "ά����ʦ��Ϣ":
			request.getSession().setAttribute("tealist", null);
			response.sendRedirect("Administrator\\Administrator_mtTea.jsp");
			break;
		case "ά������Ա��Ϣ":
			request.getSession().setAttribute("cadList", cadDao.getAllCadminis());
			response.sendRedirect("Administrator\\Administrator_mtCad.jsp");
			break;
		case "��������":
			response.sendRedirect("Administrator\\Administrator_person.jsp");
			break;
		case "��ȫ�˳�":
			response.sendRedirect("Login.html ");
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
			response.sendRedirect("Administrator\\Administrator_add.jsp");
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
			String cno=request.getParameter("cno");
			teaDao.addTeacher(tno, tname, tsex, title, leadnum, intro, "123",email, tdiscipline, cno);
			response.sendRedirect("Administrator\\Administrator_add.jsp");
			break;
		case "add_cadmini":
			String addcano=request.getParameter("cano");
			String addpwd=request.getParameter("pwd");
			String addcaname=request.getParameter("caname");
			String addcno=request.getParameter("cno");
			cadDao.addCadmini(addcano, addpwd, addcaname, addcno);
			response.sendRedirect("Administrator\\Administrator_add.jsp");
		case "ȷ��ѡ��":
			String sno_q=request.getParameter("sno");
			String tno_q=request.getParameter("tno");
			System.out.println(sno_q+" "+tno_q);
			chooseDao.confirmBySnoTno(sno_q, tno_q);
			request.getSession().setAttribute("chooseList", chooseDao.getAllChoose());
			response.sendRedirect("Administrator\\Administrator_check.jsp");
			break;
		case "ɾ��ѡ��":
			String sno_d=request.getParameter("sno");
			String tno_d=request.getParameter("tno");
			chooseDao.deleteChooseBySnoTno(sno_d, tno_d);
			request.getSession().setAttribute("chooseList", chooseDao.getAllChoose());
			response.sendRedirect("Administrator\\Administrator_check.jsp");
			break;
		case "��ѯѡ��":
			String inqueryType=request.getParameter("inqueryType");
			String message=request.getParameter("message");
			ArrayList<Choose> cholist=new ArrayList<Choose>();
			switch(inqueryType) {
			case "colno":
				cholist=chooseDao.getChooseByCno(message);
				break;
			case "stuno":
				cholist=chooseDao.getChooseBySno(message);			
				break;
			case "teano":
				cholist=chooseDao.getChooseByTno(message);
				break;	
			}
			request.getSession().setAttribute("chooseList", cholist);
			response.sendRedirect("Administrator\\Administrator_check.jsp");
			break;
		case "��ѯѧ��":
			String inqueryType2=request.getParameter("inqueryType");
			String message2=request.getParameter("message");
			ArrayList<Student> stulist=new ArrayList<Student>();
			switch(inqueryType2) {
			case "sno":
				stulist.add(stuDao.getStudent(message2));
				break;
			case "sname":
				stulist=stuDao.getStudentByName(message2);		
				break;
			}
			request.getSession().setAttribute("stulist",stulist );
			response.sendRedirect("Administrator\\Administrator_mtStu.jsp");
			break;
		case "����ѧ����Ϣ":
			String sno1=request.getParameter("sno");
			String sname1=request.getParameter("sname");
			String sex=request.getParameter("sex");
			String grade2=request.getParameter("grade");
			String school2=request.getParameter("school");
			String pwd=request.getParameter("pwd");
			String dis=request.getParameter("discipline");
			System.out.println(sno1+" "+sname1+" "+sex+" "+grade2+" "+school2+" "+pwd+" "+dis);
			stuDao.updateStudent(sno1, sname1, sex, grade2, school2, pwd, dis);
			response.sendRedirect("Administrator\\Administrator_mtStu.jsp");
			break;
		case "ɾ��ѧ��":
			String sno2=request.getParameter("sno");
			stuDao.deleteStudents(sno2);
			response.sendRedirect("Administrator\\Administrator_mtStu.jsp");
			break;
		case "��ѯ��ʦ":
			String inqueryType3=request.getParameter("inqueryType");
			String message3=request.getParameter("message");
			ArrayList<Teacher> tealist=new ArrayList<Teacher>();
			switch(inqueryType3) {
			case "teano":
				tealist.add(teaDao.getTeacher(message3));
				break;
			case "teaname":
				tealist=teaDao.getTeachersByTname(message3);
				break;
			}
			request.getSession().setAttribute("tealist", tealist);
			response.sendRedirect("Administrator\\Administrator_mtTea.jsp");
			break;
		case "���½�ʦ��Ϣ":
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
			response.sendRedirect("Administrator\\Administrator_mtTea.jsp");
			break;
		case "ɾ����ʦ":
			String tno2=request.getParameter("tno");
			teaDao.deleteByTno(tno2);
			response.sendRedirect("Administrator\\Administrator_mtTea.jsp");
			break;
		case "���¹���Ա":
			String update_cano=request.getParameter("cano");
			String update_pwd=request.getParameter("pwd");
			String update_caname=request.getParameter("caname");
			String update_cno=request.getParameter("cno");
			cadDao.update(update_cano, update_pwd, update_caname, update_cno);
			request.getSession().setAttribute("cadList", cadDao.getAllCadminis());
			response.sendRedirect("Administrator\\Administrator_mtCad.jsp");
			break;
		case "ɾ������Ա":
			String delete_cano=request.getParameter("cano");
			cadDao.delete(delete_cano);
			request.getSession().setAttribute("cadList", cadDao.getAllCadminis());
			response.sendRedirect("Administrator\\Administrator_mtCad.jsp");
			break;
		case "pwdUpdate":
			String oldpwd=request.getParameter("oldpwd");
			String newpwd=request.getParameter("newpwd");
			if(oldpwd.equals(cadDao.getCadmini(cano).getPwd()))
				cadDao.updatePWD(cano, newpwd);
			response.sendRedirect("Administrator\\Administrator_person.jsp");
			break;	
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
