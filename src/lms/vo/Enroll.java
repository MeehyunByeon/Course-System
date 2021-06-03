package lms.vo;

public class Enroll {
	private String subject;
	private String student;
	private String name;
	
	public Enroll() {
		super();
	}
	
	public Enroll(String subject, String student, String name) {
		this.subject = subject;
		this.student = student;
		this.name = name;
	}
	
	public Enroll(String subject, String student) {
		this.subject = subject;
		this.student = student;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
