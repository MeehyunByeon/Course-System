package lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.Enroll;

public class CancleSController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String student = (String)request.getSession().getAttribute("sessionId");
		
		Enroll enroll = new Enroll(subject, student);
		Service service = Service.getInstance();
		service.cancleS(enroll);
		
		request.setAttribute("subject", subject);
		request.setAttribute("student", student);
		HttpUtil.forward(request, response, "/result/cancleSresult.jsp");
	}

}
