package lms.service;

import javax.security.auth.Subject;

import lms.dao.LmsDao;
import lms.vo.Student;
import lms.vo.SSubject;
import lms.vo.Enroll;
import lms.vo.Professor;

public class Service {
	private static Service service = new Service();
	private Service() {}
	private LmsDao dao = LmsDao.getInstance();
	
	public static Service getInstance()
	{
		return service;
	}
	
	public boolean loginP(String id, String pwd) {
		return dao.loginP(id, pwd);
	}
	public boolean loginS(String id, String pwd) {
		return dao.loginS(id, pwd);
	}

	public void enroll(SSubject subject) {
		dao.enroll(subject);
	}

	public Enroll search(String subject) {
		return dao.search(subject);
	}
	
	
	
}

