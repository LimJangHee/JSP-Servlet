package controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class InsertBookController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		int isbn = request.getParameter("isbn");
		String name = request.getParameter("name");  
		String writer = request.getParameter("writer");  
		String publisher = request.getParameter("publisher");  
		String receive = request.getParameter("receive");  
	}

}
