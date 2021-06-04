package lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lms.service.Service;
import lms.vo.Professor;
import lms.vo.Student;

public class LoginController implements Controller{
	// 로그인
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String job = request.getParameter("job");
		String path = null;
		boolean result=false;
		
		Service s = Service.getInstance();

		if(job.equals("prof")) {
			path = "profMenu.jsp";
			result = s.loginP(id, pwd);
		}
		else if(job.equals("student")) {
			path = "studMenu.jsp";
			result = s.loginS(id, pwd);
		}
		
		if(result)
		{
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", id);
		}
		else if(!result){
			path = "/yongInLMS.jsp";
			request.setAttribute("result", "No ID!!!");
		}

		HttpUtil.forward(request, response, path);
		
	}
}
