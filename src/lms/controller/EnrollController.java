package lms.controller;

import java.io.IOException;

import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.SSubject;

public class EnrollController implements Controller{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int count = Integer.parseInt(request.getParameter("count"));
		String prof = request.getParameter("prof");
		
		SSubject subject = new SSubject(id, name, count, prof);
		subject.setId(id);
		subject.setName(name);
		subject.setCount(count);
		subject.setProf(prof);
		
		// service
		Service s = Service.getInstance();
		subject.enroll(subject);
		
		request.setAttribute("id", id);
		HttpUtil.forward(request, response, "/result/memberInsertOutput.jsp");
	}
}