package lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.Enroll;
import lms.vo.SSubject;

public class CanclePController implements Controller {
	// 교수: 강의 취소
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String professor = (String)request.getSession().getAttribute("sessionId");
		
		SSubject sub = new SSubject(subject, professor);
		Service service = Service.getInstance();
		service.cancleP(sub);
		
		request.setAttribute("subject", subject);
		request.setAttribute("professor", professor);
		HttpUtil.forward(request, response, "/result/canclePresult.jsp");
	}

}
