package lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.SSubject;

public class SearchPController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String find = request.getParameter("subject");
		String prof = (String)request.getSession().getAttribute("sessionId");
		
		Service s = Service.getInstance();
		SSubject sub = s.searchP(find, prof);
		
		String msg = null;
		if(sub == null) {
			msg = "No Subject!!!";
		}
		
		request.setAttribute("sub", sub);
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/updateP.jsp");
	}

}
