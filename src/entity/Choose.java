package entity;

public class Choose {
	String Sno,Tno;
	int Cno,status;
	public Choose() {
	}
	public Choose(String sno, String tno, int cno, int status) {
		super();
		Sno = sno;
		Tno = tno;
		Cno = cno;
		this.status = status;
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
	public int getCno() {
		return Cno;
	}
	public void setCno(int cno) {
		Cno = cno;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
