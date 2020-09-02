package entity;

public class Cmanager {
	String Cmno,pwd,phone,Cno,Cmname;
	public Cmanager() {}
	
	public Cmanager(String cmno, String pwd, String phone, String cno, String cmname) {
		super();
		Cmno = cmno;
		this.pwd = pwd;
		this.phone = phone;
		Cno = cno;
		Cmname = cmname;
	}

	public String getCmno() {
		return Cmno;
	}
	public void setCmno(String cmno) {
		Cmno = cmno;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCmname() {
		return Cmname;
	}
	public void setCmname(String cmname) {
		Cmname = cmname;
	}
	
	
}
