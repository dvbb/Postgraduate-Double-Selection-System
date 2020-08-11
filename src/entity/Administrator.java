package entity;

public class Administrator {
	String Ano,pwd;
	public Administrator() {	
	}
	public Administrator(String ano, String pwd) {
		super();
		Ano = ano;
		this.pwd = pwd;
	}

	public String getAno() {
		return Ano;
	}

	public void setAno(String ano) {
		Ano = ano;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
