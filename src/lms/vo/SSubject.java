package lms.vo;

public class SSubject {
	private String id;
	private String name;
	private int count;
	private String prof;
	
	public SSubject(String jId, String jName, int jCount, String jProf)
	{
		this.id = jId;
		this.name = jName;
		this.count = 0;
		this.prof = jProf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public void enroll(SSubject subject) {
		
	}
	
	
}
