package lms.vo;

public class Professor {
	private String id;
	private String pwd;
	private String name;
	
	public Professor(String pId, String pPwd, String pName)
	{
		this.id = pId;
		this.pwd = pPwd;
		this.name = pName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
