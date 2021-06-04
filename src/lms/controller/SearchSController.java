package lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.SSubject;

public class SearchSController implements Controller {
	// 학생: 수강신청 과목 검색
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String find = request.getParameter("subject");
		
		Service s = Service.getInstance();
		SSubject subject = s.searchS(find);
		
		String msg = null;
		if(subject == null) {
			msg = "No Subject!!!";
		}
		
		request.setAttribute("subject", subject);
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/searchS.jsp");
	}
}
