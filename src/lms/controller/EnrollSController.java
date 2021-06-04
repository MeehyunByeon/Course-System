package lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.Enroll;

public class EnrollSController implements Controller {
	// 학생: 수강 신청
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String studid = (String)request.getSession().getAttribute("sessionId");
		
		Enroll enroll = new Enroll(eid, studid);
		
		Service s = Service.getInstance();
		s.enrollS(enroll);
		
		request.setAttribute("studid", studid);
		request.setAttribute("eid", eid);
		request.setAttribute("ename", ename);
		HttpUtil.forward(request, response, "/result/enrollSresult.jsp");
	}

}
