package lms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.SSubject;


public class ListPController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String profId = (String)request.getSession().getAttribute("sessionId");
		
		Service service = Service.getInstance();
		ArrayList<SSubject> listP = service.listP(profId);
		
		request.setAttribute("profId", profId);
		request.setAttribute("listP", listP);
		HttpUtil.forward(request, response, "/result/listP.jsp");
	}
}
