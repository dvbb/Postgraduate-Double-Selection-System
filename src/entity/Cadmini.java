package entity;

public class Cadmini {
	String CAno,pwd,Caname;
	int Cno;
	public Cadmini() {
	}
	public Cadmini(String cAno, String pwd, String caname, int cno) {
		super();
		CAno = cAno;
		this.pwd = pwd;
		Caname = caname;
		Cno = cno;
	}
	public String getCAno() {
		return CAno;
	}
	public void setCAno(String cAno) {
		CAno = cAno;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCaname() {
		return Caname;
	}
	public void setCaname(String caname) {
		Caname = caname;
	}
	public int getCno() {
		return Cno;
	}
	public void setCno(int cno) {
		Cno = cno;
	}

	
	
}
