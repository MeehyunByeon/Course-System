package lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.SSubject;

public class ListSController implements Controller {
	// 학생: 수강신청 리스트
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String studId = (String)request.getSession().getAttribute("sessionId");
		
		Service service = Service.getInstance();
		ArrayList<SSubject> listS = service.listS(studId);
		
		request.setAttribute("studId", studId);
		request.setAttribute("listS", listS);
		HttpUtil.forward(request, response, "/result/listS.jsp");
	}

}
