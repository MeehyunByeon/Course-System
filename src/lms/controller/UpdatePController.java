package lms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;
import lms.vo.SSubject;

public class UpdatePController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String upname = request.getParameter("upname");
		int upcount = Integer.parseInt(request.getParameter("upcount"));
		String prof = (String)request.getSession().getAttribute("sessionId");
		
		SSubject sub = new SSubject();
		sub.setId(id);
		sub.setName(upname);
		sub.setCount(upcount);
		sub.setProf(prof);
		
		Service service = Service.getInstance();
		service.updateP(sub);
		
		String msg = null;
		if(sub==null)
			msg="Update Fail!!!";
		
		request.setAttribute("id", id);
		request.setAttribute("sub", sub);
		request.setAttribute("msg", msg);
		HttpUtil.forward(request, response, "/result/updatePresult.jsp");
	}

}
