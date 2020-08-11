package entity;

public class Teacher {
	String Tno,Tname,sex,title,intro,pwd,email,discipline;
	int leadnum,Cno;
	public Teacher() {	
	}
	
	
	public Teacher(String tno, String tname, String sex, String title, String intro, String pwd, String email,
			String discipline, int leadnum, int cno) {
		super();
		Tno = tno;
		Tname = tname;
		this.sex = sex;
		this.title = title;
		this.intro = intro;
		this.pwd = pwd;
		this.email = email;
		this.discipline = discipline;
		this.leadnum = leadnum;
		Cno = cno;
	}


	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getLeadnum() {
		return leadnum;
	}
	public void setLeadnum(int leadnum) {
		this.leadnum = leadnum;
	}
	public int getCno() {
		return Cno;
	}
	public void setCno(int cno) {
		Cno = cno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
}
