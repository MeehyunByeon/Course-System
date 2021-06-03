package lms.service;

import java.util.ArrayList;

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
	// 로그인
	public boolean loginP(String id, String pwd) {
		return dao.loginP(id, pwd);
	}
	
	public boolean loginS(String id, String pwd) {
		return dao.loginS(id, pwd);
	}
	
	// 교수: 강의 등록
	public void enrollP(SSubject subject) {
		dao.enrollP(subject);
	}
	
	// 학생: 수강 신청
	public SSubject searchS(String find) {
		SSubject subject = dao.searchS(find);
		return subject;
	}
	
	public void enrollS(Enroll enroll) {
		dao.enrollS(enroll);
	}
	
	// 학생: 수강 취소
	public void cancleS(Enroll enroll) {
		dao.cancleS(enroll);
	}

	// 교수: 강의 취소
	public void cancleP(SSubject sub) {
		dao.cancleP(sub);
	}
	
	// 교수: 등록한 강의 리스트
	public ArrayList<SSubject> listP(String profId) {
		ArrayList<SSubject> subject = dao.listP(profId);
		return subject;
	}

	// 교수: 등록한 강의 상세 리스트
	public ArrayList<Enroll> detailP(String subject) {
		ArrayList<Enroll> en = dao.detailP(subject);
		return en;
	}
	
	// 학생: 수강신청 리스트
	public ArrayList<SSubject> listS(String studId) {
		ArrayList<SSubject> subject = dao.listS(studId);
		return subject;
	}
	
	public ArrayList<SSubject> showAll() {
		return dao.showAll();
	}
	
	public ArrayList<SSubject> showDetail() {
		return dao.showDetail();
	}
	
}

