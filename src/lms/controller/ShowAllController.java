package lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.SSubject;

public class ShowAllController implements Controller {
	// 모든 수강신청 리스트
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String session = (String)request.getSession().getAttribute("sessionId");
		Service service = Service.getInstance();
		ArrayList<SSubject> all = service.showAll();
		ArrayList<SSubject> detail = service.showDetail();
		
		request.setAttribute("all", all);
		request.setAttribute("detail", detail);
		request.setAttribute("session", session);
		HttpUtil.forward(request, response, "/result/showAll.jsp");
	}
}
