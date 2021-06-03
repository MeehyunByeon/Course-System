package lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.Enroll;

public class detailPController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		
		Service service = Service.getInstance();
		ArrayList<Enroll> detailP = service.detailP(subject);
		
		request.setAttribute("subject", subject);
		request.setAttribute("detailP", detailP);
		HttpUtil.forward(request, response, "/result/listPdetail.jsp");

	}

}
