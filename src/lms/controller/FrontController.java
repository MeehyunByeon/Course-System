package lms.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> map = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Controller>();
		map.put("/login.do", new LoginController());
		map.put("/enrollP.do", new EnrollPController());
		map.put("/cancleP.do", new CanclePController());
		map.put("/listP.do", new ListPController());
		map.put("/detailP.do", new detailPController());
		
		map.put("/searchS.do", new SearchSController());
		map.put("/enrollS.do", new EnrollSController());
		map.put("/cancleS.do", new CancleSController());
		map.put("/listS.do", new ListSController());
		
		map.put("/showAll.do", new ShowAllController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Controller cont = map.get(path);
		cont.execute(req, resp);
	}
}
