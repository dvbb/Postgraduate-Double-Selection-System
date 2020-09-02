package entity;

public class Manager {
	String Mno,pwd,phone;
	public Manager() {}
	public Manager(String mno, String pwd, String phone) {
		super();
		Mno = mno;
		this.pwd = pwd;
		this.phone = phone;
	}
	public String getMno() {
		return Mno;
	}
	public void setMno(String mno) {
		Mno = mno;
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
	
}
