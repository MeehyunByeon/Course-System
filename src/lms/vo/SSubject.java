package lms.vo;

public class SSubject {
	private String id;
	private String name;
	private int count;
	private String prof;
	private int number;
	private int current;
	
	public SSubject(String id, String name, int count, String prof) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.prof = prof;
	}
	
	public SSubject(String id, String name, int count, int number) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.number = number;
	}
	public SSubject(String id, String name, int count, int number, int current) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.number = number;
		this.setCurrent(current);
	}

	public SSubject() {
		
	}

	public SSubject(String id, String prof) {
		this.id = id;
		this.prof = prof;
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
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
}
