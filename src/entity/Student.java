package entity;

public class Student {
	 String Sno,Sname,sex,school,pwd,discipline,email,phone,grade,Cno;
	 public Student() {}
	public Student(String sno, String sname, String sex, String school, String pwd, String discipline, String email,
			String phone, String grade, String cno) {
		super();
		Sno = sno;
		Sname = sname;
		this.sex = sex;
		this.school = school;
		this.pwd = pwd;
		this.discipline = discipline;
		this.email = email;
		this.phone = phone;
		this.grade = grade;
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
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	} 
	
	
	 
	 
}
