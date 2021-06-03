package lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.Enroll;

public class SearchController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String subject = request.getParameter("subject");
		
		Service s = Service.getInstance();
		Enroll enroll = s.search(subject);
		if(subject == null) request.setAttribute("result", "No Subject!!!");
		
		request.setAttribute("subject", enroll);
		HttpUtil.forward(request, response, "/search.jsp");
	}
}
