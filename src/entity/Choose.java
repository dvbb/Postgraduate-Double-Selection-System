package entity;

public class Choose {
	String Sno,Tno,Cno,status,wish;
	public Choose() {}
	public Choose(String sno, String tno, String cno, String status, String wish) {
		super();
		Sno = sno;
		Tno = tno;
		Cno = cno;
		this.status = status;
		this.wish = wish;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWish() {
		return wish;
	}
	public void setWish(String wish) {
		this.wish = wish;
	}
	
	
}
