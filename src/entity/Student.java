package entity;

public class Student {
	private  String Sno,Sname,sex,school,pwd,discipline;
	private  int grade,Cno;
	
	
	public Student() {	
	}
	public Student(String sno, String sname, String sex, String school, String pwd,String discipline, int grade, int cno) {
		super();
		Sno = sno;
		Sname = sname;
		this.sex = sex;
		this.school = school;
		this.pwd = pwd;
		this.grade = grade;
		this.discipline=discipline;
		Cno = cno;
	}
	
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getCno() {
		return Cno;
	}
	public void setCno(int cno) {
		Cno = cno;
	}

	public boolean isNull() {
		if(Sno==null)
			return true;
		return false;
		
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}


	
	
	
	
}
