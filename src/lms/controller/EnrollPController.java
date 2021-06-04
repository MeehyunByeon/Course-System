package lms.controller;

import java.io.IOException;

import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lms.service.Service;
import lms.vo.SSubject;

public class EnrollPController implements Controller{
	// 교수: 강의 등록
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("subId");
		String name = request.getParameter("subName");
		int count = Integer.parseInt(request.getParameter("subCount"));
		String profId = (String)request.getSession().getAttribute("sessionId");
		
		SSubject subject = new SSubject(sid, name, count, profId);
		subject.setId(sid);
		subject.setName(name);
		subject.setCount(count);
		subject.setProf(profId);
		
		// service
		Service s = Service.getInstance();
		s.enrollP(subject);
		
		request.setAttribute("sid", sid);
		request.setAttribute("name", name);
		request.setAttribute("count", count);
		request.setAttribute("profId", profId);
		HttpUtil.forward(request, response, "/result/enrollPresult.jsp");
	}
}